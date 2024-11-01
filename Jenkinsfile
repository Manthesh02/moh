@Library('moh') _ // Reference to your shared library

pipeline {
    agent any

    parameters sharedParams() // Load parameters from sharedParams.groovy

    stages {
        stage('Parameter Check') {
            steps {
                script {
                    // Log the parameters for verification
                    echo "Selected Sites: ${params.SITE}"
                    echo "Selected Services: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
