@Library('moh') _

pipeline {
    agent any

    stages {
        stage('Test Fetch Params') {
            steps {
                script {
                    def params = moh.fetchParams()
                    echo "Fetched Sites: ${params.sites.join(', ')}"
                    echo "Fetched Services: ${params.services.join(', ')}"
                    echo "Fetched Version: ${params.version}"
                }
            }
        }
    }
}
