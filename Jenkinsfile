pipeline {
  agent {
    docker {
      image 'jboss/wildfly'
      args '--build-arg DB_HOST=172.25.141.81 --build-arg DB_NAME=postgresdb --build-arg DB_USER=postgres --build-arg DB_PASS=irtt'
    }

  }
  stages {
    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            bat(script: 'docker --version', returnStatus: true, returnStdout: true)
          }
        }
        stage('Demo') {
          steps {
            bat(script: 'node --version', returnStdout: true, returnStatus: true)
          }
        }
      }
    }
  }
}