package org.fors.wwms.controller

import org.fors.wwms.turnbuckle.BuckleCommand
import org.fors.wwms.turnbuckle.CommandService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/turnbuckle")
class TurnbuckleController(private val commandService: CommandService) {

    @GetMapping
    fun getAllCommands(): List<BuckleCommand> {
        return commandService.listCommands()
    }

    @GetMapping("/{buckleId}")
    fun executeCommand(@PathVariable buckleId: String) {
        val command = commandService.listCommands().find { it.buckleId == buckleId }
            ?: throw IllegalArgumentException("Command not found: $buckleId")
        commandService.execute(command)
    }
}