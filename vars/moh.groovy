def fetchParams() {
    return [
        sites: [
            'MHHTP:10.5.43.89', 'LGHJP:10.5.43.93', 'RGHPJ:10.5.43.94', 'ATHJ:10.5.43.95',
            'KAAHJ:10.5.43.74', 'MHHB:10.5.43.75', 'AZMHP:10.5.43.79', 'JEHP:10.5.43.92',
            'PANAH:10.5.43.92', 'CHTP:10.5.43.92', 'KABHP:10.5.43.89', 'MCHN:10.5.43.88',
            'AYRH:10.5.43.87', 'SARAT:10.5.43.87', 'MAHANI:10.5.43.83', 'JIPCP:10.5.43.81',
            'SBSHP:10.5.43.86', 'QBMHP:10.5.43.86', 'KHP:10.5.43.86', 'MSHP:10.5.43.86',
            'THP:10.5.43.86', 'MUWHP:10.5.43.86', 'QHP:10.5.43.86', 'RHP:10.5.43.86',
            'JPSHP:10.5.43.78', 'KAHTP:10.5.43.90', 'MCHKP:10.5.43.85', 'AGHP:10.5.43.84',
            'MGHP:10.5.43.84', 'HHP:10.5.43.84', 'MHP:10.5.43.84', 'PAH:10.5.43.84',
            'PRPB:10.5.43.84', 'GHP:10.5.43.84'
        ],
        services: [
            'word-report', 'dataset-setup', 'scm-integration',
            'nphies-clinical-service', 'dataset-processing', 'active-mq',
            'medical-extensions', 'release-notes-service', 'security-service',
            'message-broker', 'email-service', 'word-documents', 'oasis-app-service'
        ],
        version: '1.0.0' // Default version
    ]
}
