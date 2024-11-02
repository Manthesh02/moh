def fetchParams() {
    echo "Fetching parameters..."
    def params = [
        sites: ['MHHTP:10.5.43.89', 'LGHJP:10.5.43.93'],
        services: ['word-report', 'dataset-setup'],
        version: '1.0.0'
    ]
    echo "Parameters fetched: ${params}"
    return params
}
