@Library('moh') _

pipeline {
    agent any

    parameters {
        activeChoice(name: 'SITE', type: 'PT_CHECKBOX', description: 'Select the Site (namespace:IP)', choiceType: 'CHECKBOX', script: [
            classpath: [],
            fallbackScript: [
                classpath: [],
                script: 'return ["default-site:0.0.0.0"]'
            ],
            script: 'return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93"]'
        ])
    }

    stages {
        stage('Parameter Check') {
            steps {
                script {
                    echo "Selected Site: ${params.SITE}"
                }
            }
        }
    }
}
