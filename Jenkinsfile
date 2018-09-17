pipeline {
  agent {
    dockerfile {
      filename 'Dockerfile'
    }

  }
  stages {
    stage('Test') {
      steps {
        bat(script: 'docker --version', returnStatus: true, returnStdout: true)
      }
    }
  }
}