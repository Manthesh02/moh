@Library('moh') _

pipeline {
    agent any
    parameters moh()
    stages {
        stage('Test Stage') {
            steps {
                script {
                    // Print the selected option
                    echo "Selected Option: ${params.TEST_PARAM}"
                }
            }
        }
    }
}
