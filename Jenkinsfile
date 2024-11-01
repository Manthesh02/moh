@Library('moh') _

def paramsMap = moh.getParameterDefinitions()

pipeline {
    agent any
    parameters {
        paramsMap.each { param ->
            parameter(param)
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
