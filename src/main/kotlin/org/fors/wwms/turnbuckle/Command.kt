package org.fors.wwms.turnbuckle

interface Command {
    fun execute(parameters: Map<String, String>): List<Map<String, Any>>
}