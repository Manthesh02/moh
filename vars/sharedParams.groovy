// vars/sharedParams.groovy
def call() {
    return [
        activeChoice(
            name: 'SITE',
            type: 'PT_CHECKBOX',
            description: 'Select the Site (namespace:IP)',
            choiceType: 'CHECKBOX',
            script: [
                classpath: [],
                fallbackScript: [
                    classpath: [],
                    script: 'return ["MHHTP:10.5.43.89","LGHJP:10.5.43.93","RGHPJ:10.5.43.94"]'
                ],
                script: 'return ["MHHTP:10.5.43.89","LGHJP:10.5.43.93","RGHPJ:10.5.43.94"]'
            ]
        ),
        activeChoice(
            name: 'SERVICE',
            type: 'PT_CHECKBOX',
            description: 'Select the Service',
            choiceType: 'CHECKBOX',
            script: [
                classpath: [],
                fallbackScript: [
                    classpath: [],
                    script: 'return ["word-report","dataset-setup","scm-integration"]'
                ],
                script: 'return ["word-report","dataset-setup","scm-integration"]'
            ]
        ),
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
    ]
}
