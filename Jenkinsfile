@Library('moh') _

pipeline {
    agent any

    parameters {
        // Directly call the method from your shared library that returns the parameters
        sharedParams() // This function should return a list of parameters
    }

    stages {
        stage('Display Selected Site') {
            steps {
                script {
                    echo "Selected Site(s): ${params.SITE.join(', ')}"
                }
            }
        }
    }
}
