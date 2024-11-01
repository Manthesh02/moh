@Library('moh') _

pipeline {
  agent any
  stages {
    stage('Test Stage') {
      steps {
        script {
          // Access parameters defined by the "moh" library
          echo "Selected Sites: ${params.SITE}"
          echo "Selected Services: ${params.SERVICE}"
          echo "Version: ${params.VERSION}"
        }
      }
    }
  }
}
