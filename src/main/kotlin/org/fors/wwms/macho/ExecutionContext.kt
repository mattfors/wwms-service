package org.fors.wwms.macho

// A context class that carries the state and parameters during execution.
data class ExecutionContext(
    val parameters: MutableMap<String, Any> = mutableMapOf(),
    val results: MutableList<Any> = mutableListOf(),
    val log: MutableList<String> = mutableListOf()  // Example of tracking logs during execution
) {
    // Method to add a result (e.g., from a SQL execution or Java method)
    fun addResult(result: Any) {
        results.add(result)
    }

    // Method to get a parameter by name
    fun getParameter(name: String): Any? {
        return parameters[name]
    }

    // Method to set a parameter value
    fun setParameter(name: String, value: Any) {
        parameters[name] = value
    }

    // Method to log info
    fun logInfo(message: String) {
        log.add(message)
    }
}
