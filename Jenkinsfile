@Library('moh') _

pipeline {
    agent any
    parameters {
        script {
            return moh.getParameterDefinitions()
        }
    }
    stages {
        stage('Display Parameters') {
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
