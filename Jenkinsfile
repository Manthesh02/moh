@Library('moh') _

pipeline {
    agent any

    parameters {
        script {
            return sharedParams()
        }
    }

    stages {
        stage('Parameter Check') {
            steps {
                script {
                    echo "Selected Service: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                    echo "Run Tests: ${params.RUN_TESTS}"
                }
            }
        }
    }
}
