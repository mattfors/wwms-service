package org.fors.wwms.turnbuckle

class SqlCommandAdapter : Command {
    override fun execute(parameters: Map<String, String>): List<Map<String, Any>> {
        println("sql command executor")
        return emptyList()
    }
}