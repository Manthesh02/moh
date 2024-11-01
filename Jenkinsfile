pipeline {
    agent any
    parameters {
        activeChoiceParam(
            name: 'SITE',
            type: 'CHECKBOX',
            description: 'Select the Site (namespace:IP)',
            groovyScript: [
                script: 'return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93", "RGHPJ:10.5.43.94"]'
            ]
        ),
        activeChoiceParam(
            name: 'SERVICE',
            type: 'CHECKBOX',
            description: 'Select the Service',
            groovyScript: [
                script: 'return ["word-report", "dataset-setup", "scm-integration", "nphies-clinical-service", "dataset-processing", "active-mq", "medical-extensions", "release-notes-service", "security-service", "message-broker", "email-service", "word-documents", "oasis-app-service"]'
            ]
        ),
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
    }
    stages {
        stage('Parameter Check') {
            steps {
                script {
                    // Log the selected parameters for verification
                    echo "Selected Sites: ${params.SITE}"
                    echo "Selected Services: ${params.SERVICE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
