@Library('moh') _

def sharedParams = moh.fetchParams()

pipeline {
    agent any

    parameters {
        choice(
            name: 'SITE',
            choices: sharedParams.sites,
            description: 'Select the Site (namespace:IP)'
        )
        choice(
            name: 'SERVICE',
            choices: sharedParams.services,
            description: 'Select the Service'
        )
        string(
            name: 'VERSION',
            defaultValue: sharedParams.version,
            description: 'Specify the Version to deploy'
        )
    }

    stages {
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE}"
                    echo "Selected Service: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
        // Additional stages can be added here...
    }
}
