@Library('moh') _  // Ensure the library name matches your configuration

pipeline {
    agent any

    parameters {
        // You need to define parameters directly without script blocks
        activeChoice(name: 'SITE', type: 'PT_CHECKBOX', description: 'Select the Site (namespace:IP)', choiceType: 'CHECKBOX', script: [
            classpath: [],
            script: '''
                // Replace this URL with your actual data source
                def sites = ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93"];
                return sites
            '''
        ])
    }

    stages {
        stage('Display Selected Sites') {
            steps {
                script {
                    echo "Selected Sites: ${params.SITE}"
                }
            }
        }
    }
}
