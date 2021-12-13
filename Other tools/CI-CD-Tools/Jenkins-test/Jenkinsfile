pipeline {
  agent any
  stages {
    stage('Init') {
      steps {
        echo 'This is the pipeline begin.'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn package -Dmaven.test.skip=true'
      }
    }

  }
}