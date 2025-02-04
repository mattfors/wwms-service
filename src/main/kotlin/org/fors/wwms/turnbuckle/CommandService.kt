package org.fors.wwms.turnbuckle

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class CommandService(private val commandLoader: CommandLoader) {

    private val commandMap = mapOf(
        "sql" to ::SqlCommandAdapter,
        "macho" to ::MachoCommandAdapter
    )

    lateinit var commands: List<BuckleCommand>

    @PostConstruct
    fun init() {
        commands = commandLoader.loadCommands("turnebuckle/commands.toml")
    }

    fun listCommands(): List<BuckleCommand> = commands

    fun execute(command: BuckleCommand) {
        commandMap[command.type]?.invoke()?.execute(emptyMap())
    }
}