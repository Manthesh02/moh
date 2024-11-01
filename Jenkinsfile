@Library('moh') _

pipeline {
    agent any
    parameters sharedParams()
    stages {
        stage('Check Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE}"
                    echo "Selected Services: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
