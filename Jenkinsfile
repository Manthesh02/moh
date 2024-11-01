pipeline {
    agent any

    parameters {
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
        // No need to redefine Active Choices here
    }

    stages {
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
