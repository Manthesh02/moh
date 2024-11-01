@Library('moh') _ // Replace 'moh' with the name of your shared library

pipeline {
    agent any

    parameters sharedParams() // Ensure sharedParams() is properly defined

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
