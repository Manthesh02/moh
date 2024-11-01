@Library('test-m0h') _

pipeline {
    agent any
    parameters sharedParams()
    stages {
        stage('Update Service') {
            steps {
                script {
                    updateService(params.SITE, params.SERVICE, params.VERSION)
                }
            }
        }
    }
}
