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
                    script: 'return ["Default Site"]'
                ],
                script: 'return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93"]' // Add your actual sites here
            ]
        ),
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Specify the Version to deploy')
    ]
}
