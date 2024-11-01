def call(def sites, def services, def version) {
    def siteList = sites.split(',')
    def serviceList = services.split(',')

    siteList.each { site ->
        def siteDetails = site.split(':')
        def namespace = siteDetails[0]
        def ip = siteDetails[1]

        serviceList.each { service ->
            try {
                println "Connecting to site with namespace: ${namespace} and IP: ${ip}"
                println "Updating service: ${service} to version: ${version}"

                sh """
                    sshpass -p '${credentials('ssh-credentials').password}' ssh -o StrictHostKeyChecking=no ${credentials('ssh-credentials').username}@${ip} "
                    namespace=${namespace} &&
                    docker pull oasissys/${service}:${version} &&
                    kubectl set image deployment/${service} ${service}=oasissys/${service}:${version} -n ${namespace}
                "
                println "Successfully updated ${service} to version ${version} in ${namespace}"
            } catch (Exception e) {
                println "Failed to update ${service} in ${namespace}: ${e.message}"
            }
        }
    }
}
