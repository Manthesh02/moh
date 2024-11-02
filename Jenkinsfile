@Library('moh') _ // Ensure your shared library is loaded

node {
    properties([
        parameters([
            activeChoice(name: 'SITE',
                choiceType: 'PT_SINGLE_SELECT',
                script: [
                    class: 'org.biouno.unochoice.model.GroovyScript',
                    script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                        'return Moh.fetchSites()',
                        true
                    )
                ]
            ),
            activeChoice(name: 'SERVICE',
                choiceType: 'PT_SINGLE_SELECT',
                script: [
                    class: 'org.biouno.unochoice.model.GroovyScript',
                    script: new org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SecureGroovyScript(
                        'return Moh.fetchServices()',
                        true
                    )
                ]
            ),
            string(name: 'VERSION', 
                defaultValue: '1.0.0', 
                description: 'Specify the Version to deploy'
            )
        ])
    ])

    stage('Display Parameters') {
        steps {
            echo "Selected Site: ${params.SITE}"
            echo "Selected Service: ${params.SERVICE}"
            echo "Version: ${params.VERSION}"
        }
    }
}
