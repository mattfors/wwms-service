package org.fors.wwms.turnbuckle

data class BuckleCommand (
    val buckleId: String,
    val type: String,
    val commandString: String
)