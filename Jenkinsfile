@Library('moh') _

pipeline {
    agent any
    parameters moh()
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
