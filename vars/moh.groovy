class Moh {
    static List<String> fetchSites() {
        println "Fetching sites..."
        return ["Site1:10.0.0.1", "Site2:10.0.0.2"]
    }

    static List<String> fetchServices() {
        println "Fetching services..."
        return ["Service1", "Service2"]
    }

    static String fetchVersion() {
        println "Fetching version..."
        return "1.0.0"
    }
}
