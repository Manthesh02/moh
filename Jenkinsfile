@Library('moh') _

pipeline {
    agent any

    parameters {
        // Add static or basic parameters here
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
    }

    stages {
        stage('Initialize Parameters') {
            steps {
                script {
                    // Dynamically load and add Active Choices parameters
                    def params = sharedParams()
                    params.each { param ->
                        echo "Parameter Name: ${param.name}"
                        // In a real setup, you may need to handle these params appropriately
                    }
                }
            }
        }

        stage('Display Selected Site') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
