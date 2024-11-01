def call() {
    return [
        activeChoice(
            name: 'SITE',
            type: 'PT_CHECKBOX',
            description: 'Select the Site (namespace:IP)',
            choiceType: 'CHECKBOX',
            script: [
                classpath: [],
                script: '''
                    // Replace this URL with your actual data source
                    def sites = ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93"];
                    return sites
                '''
            ]
        ),
        // Other parameters can go here
    ]
}
