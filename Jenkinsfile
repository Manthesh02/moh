pipeline {
    agent any
    parameters {
        [$class: 'ExtendedChoiceParameterDefinition',
            name: 'SITE',
            type: 'PT_CHECKBOX',
            description: 'Select the Site (namespace:IP)',
            value: 'MHHTP:10.5.43.89,LGHJP:10.5.43.93,RGHPJ:10.5.43.94'
        ],
        [$class: 'ExtendedChoiceParameterDefinition',
            name: 'SERVICE',
            type: 'PT_CHECKBOX',
            description: 'Select the Service',
            value: 'word-report,dataset-setup,scm-integration,nphies-clinical-service,dataset-processing,active-mq,medical-extensions,release-notes-service,security-service,message-broker,email-service,word-documents,oasis-app-service'
        ],
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
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
