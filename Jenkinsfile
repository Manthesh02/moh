@Library('moh') _

pipeline {
    agent any

    parameters {
        activeChoice(
            name: 'SITE',
            description: 'Select the Site (namespace:IP)',
            choiceType: 'PT_CHECKBOX',
            script: [
                $class: 'org.biouno.unochoice.model.GroovyScript',
                script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                    '''return moh.getSiteMappings()''',
                    true
                )
            ]
        )
        activeChoice(
            name: 'SERVICE',
            description: 'Select the Service to update',
            choiceType: 'PT_CHECKBOX',
            script: [
                $class: 'org.biouno.unochoice.model.GroovyScript',
                script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                    '''return moh.getServiceList()''',
                    true
                )
            ]
        )
        string(
            name: 'VERSION',
            defaultValue: '1.0.0',
            description: 'Specify the Version to deploy'
        )
    }

    stages {
        stage('Update Service') {
            steps {
                script {
                    def selectedSites = params.SITE?.join(', ')
                    def selectedServices = params.SERVICE?.join(', ')
                    def version = params.VERSION
                    
                    echo "Selected Sites: ${selectedSites ?: 'None selected'}"
                    echo "Selected Services: ${selectedServices ?: 'None selected'}"
                    echo "Version: ${version}"
                    
                    // Here you would include logic to update the services on the selected sites
                    // For example:
                    // selectedSites.split(',').each { site ->
                    //     // Logic to update each service on the site
                    // }
                }
            }
        }
    }
}
