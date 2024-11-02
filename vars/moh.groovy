class Moh {
    static List<String> fetchSites() {
        return ["MHHTP:10.5.43.89", "LGHJP:10.5.43.93"] // Update with actual data
    }

    static List<String> fetchServices() {
        return ["word-report", "dataset-setup"] // Update with actual data
    }

    static String fetchVersion() {
        return "1.0.0" // Default version or fetch dynamically if needed
    }
}
