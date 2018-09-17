pipeline {
  agent {
    docker {
      image 'jboss/wildfly'
      args '--build-arg DB_HOST=172.25.141.81 --build-arg DB_NAME=postgresdb --build-arg DB_USER=postgres --build-arg DB_PASS=irtt'
    }

  }
  stages {
    stage('Test') {
      steps {
        bat 'docker --version'
      }
    }
  }
}