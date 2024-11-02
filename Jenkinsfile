pipeline {
    agent any
    stages {
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE.join(', ')}"
                    echo "Selected Services: ${params.SERVICE.join(', ')}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
        // Add more stages as needed
        stage('Deploy') {
            steps {
                script {
                    // Example deployment logic
                    echo "Deploying version ${params.VERSION} to sites: ${params.SITE.join(', ')}"
                    echo "Using services: ${params.SERVICE.join(', ')}"
                }
            }
        }
    }
}
