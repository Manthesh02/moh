@Library('moh') _

pipeline {
    agent any

    parameters {
        script {
            sharedParams() // Load parameters from shared library
        }
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
