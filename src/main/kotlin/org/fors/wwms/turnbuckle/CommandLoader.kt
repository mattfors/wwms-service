package org.fors.wwms.turnbuckle

import com.moandjiezana.toml.Toml
import org.springframework.stereotype.Service
import java.io.InputStream


data class BuckleCommandWrapper(
    val commands: List<BuckleCommand>
)

@Service
class CommandLoader {

    fun loadCommands(resourcePath: String): List<BuckleCommand> {
        val inputStream: InputStream = this::class.java.classLoader.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource not found: $resourcePath")

        val toml: Toml = Toml().read(inputStream)
        val config: BuckleCommandWrapper = toml.to(BuckleCommandWrapper::class.java)
       return config.commands;
    }
}