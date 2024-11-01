pipeline {
    agent any

    stages {
        stage('Display Selected Site') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE}"  // Access the parameter defined in the job configuration
                }
            }
        }
    }
}
