@Library('moh') _

pipeline {
    agent any

    parameters {
        activeChoice(name: 'SITE', type: 'PT_CHECKBOX', description: 'Select the Site (namespace:IP)', choiceType: 'CHECKBOX', script: [
            classpath: [],
            script: 'return ["MHHTP:10.5.43.89","LGHJP:10.5.43.93"]'
        ])
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
    }

    stages {
        stage('Display Parameters') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE}"
                    echo "Version: ${params.VERSION}"
                }
            }
        }
    }
}
