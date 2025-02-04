package org.fors.wwms.macho

object Macho {

    @JvmStatic
    fun logInfo(msg: String): String {
        println("Logging: $msg")
        return "Logged: $msg" // This is returned to be used in the next step
    }

    fun executePipeline(input: String) {
        // Register methods beforehand (you could do this dynamically, too)
        MethodRegistry.registerMethod("logInfo", Macho::class.java.getMethod("logInfo", String::class.java))

        // Initialize the execution context
        val context = ExecutionContext()

        // Tokenize the input
        val tokens = Tokenizer.tokenize(input)

        // Lex the tokens
        val lexedTokens = Lexer.lex(tokens)

        // Process tokens and execute SQL or Java methods
        Executor.executeCommand(lexedTokens, context)

        println("Current Results: ${context.results}")
    }
}