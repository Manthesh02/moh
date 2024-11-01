@Library('moh') _  // Load the shared library

pipeline {
    agent any
    stages {
        stage('Define Parameters') {
            steps {
                script {
                    def paramsDef = moh()  // Call the shared parameters
                    properties([parameters(paramsDef)])
                }
            }
        }
        stage('Display Selected Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITES.join(', ')}"
                    echo "Selected Services: ${params.SERVICES.join(', ')}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
