@Library('moh') _  // Make sure the library name matches what you configured in Jenkins

pipeline {
    agent any

    parameters {
        // Load parameters from the shared library
        script {
            def params = sharedParams()  // Call the function to get parameters
            params.each { param -> 
                parameter(param)  // Add each parameter to the Jenkins pipeline
            }
        }
    }

    stages {
        stage('Display Selected Sites') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE}"
                }
            }
        }
    }
}
