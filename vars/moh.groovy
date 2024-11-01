def call() {
    return [
        activeChoice(name: 'SITE', 
                     type: 'PT_CHECKBOX', 
                     description: 'Select the Site (namespace:IP)', 
                     choiceType: 'CHECKBOX', 
                     script: [
                         """return ['Site1', 'Site2', 'Site3']"""
                     ])
    ]
}
