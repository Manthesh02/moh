@Library('moh') _

pipeline {
    agent any
    parameters sharedParams()
    stages {
        stage('Test Stage') {
            steps {
                script {
                    // Print the selected options
                    echo "Selected Option: ${params.TEST_PARAM}"
                }
            }
        }
    }
}
