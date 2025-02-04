package org.fors.wwms.turnbuckle

class MachoCommandAdapter: Command {
    override fun execute(parameters: Map<String, String>): List<Map<String, Any>> {
        println("macho command executor");
        return emptyList();
    }
}