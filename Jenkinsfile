pipeline {
  agent any
  tools { maven 'Maven3' } // same name as configured in Jenkins
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        bat 'mvn clean package -DskipTests'
      }
    }
    stage('Test') {
      steps {
        bat 'mvn test'
      }
    }
    stage('Package') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
  }
  post {
    success {
      echo '✅ Build successful!'
    }
    failure {
      echo '❌ Build failed!'
    }
  }
}
