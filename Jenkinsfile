@Library('moh') _

pipeline {
    agent any

    parameters sharedParams() // Load parameters

    stages {
        stage('Parameter Check') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE}"
                }
            }
        }
        // Add more stages as needed
    }
}
