package org.agoncal.application.petstore.util;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient
{
	public static <T> T get(Class<T> type, String path) 
	{
		Response res = getBuilder(path).get();
		T data =  isVaild(res) ? res.readEntity(type) : null;
		return data;
	}
	public static <T> T post(Class<T> type, String path, Entity<?> entity) 
	{
		Response res = getBuilder(path).post(entity);
		T data =  isVaild(res) ? res.readEntity(type) : null;
		return data;
	}
	
	public static <T> T delete(Class<T> type, String path) 
	{
		Response res = getBuilder(path).delete();
		T data =  isVaild(res) ? res.readEntity(type) : null;
		return data;
	}
	
	private static boolean isVaild(Response res)
	{
		if(res.getStatus() != Response.Status.OK.getStatusCode())
		{
			throw new RuntimeException("Network call failed.");
		}
		return true;
	}
	private static Invocation.Builder getBuilder(String path) {
		return ClientBuilder.newClient().target("http://localhost:8082/applicationPetstore/rest").path(path).request(MediaType.APPLICATION_JSON);
	}
}