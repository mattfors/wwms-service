package org.fors.wwms.macho

object Executor {
    // Execute the SQL command and manage the context
    private fun executeSql(sql: String, context: ExecutionContext): Any {
        // Here we simulate the SQL execution, replace this with actual DB interaction (e.g., MyBatis or Hibernate)
        val queryResult = emptyList<String>()
        println("Executed SQL: $sql with parameters: ${context.parameters}")
        context.addResult(queryResult)
        return queryResult
    }

    // Invoke Java methods based on registered methods
    private fun invokeJavaMethod(methodName: String, params: List<Any>, context: ExecutionContext) {
        println("Execute method: $methodName with parameters: $params")
        MethodRegistry.getMethod(methodName)?.invoke(context, *params.toTypedArray()) ?: run {
            // Handle unknown methods
            println("Method $methodName not registered.")
        }

    }

    // Process the pipeline of tokens
    fun executeCommand(tokens: List<Token>, context: ExecutionContext) {
        var currentResult: Any? = null

        // Process each token
        for (token in tokens) {
            println("Processing token: $token")
            when (token.type) {
                TokenType.SQL -> {
                    // Replace parameters in SQL from context and execute
                    val sql = token.value
                    val parameters = context.parameters
                    currentResult = executeSql(sql, context) // Execute SQL and store result in context
                }
                TokenType.METHOD -> {
                    // For methods, extract the method name and parameters
                    val methodName = token.value.substringBefore("(") // Extract method name
                    val params = extractParamsFromMethod(token.value)

                    // Invoke Java method (e.g., logInfo)
                    invokeJavaMethod(methodName, params, context)
                }
                TokenType.PIPE -> {
                    // Handle pipe operation by passing result from previous command to the next one
                    currentResult?.let {
                        context.addResult(it)  // Add the result to context for the next step
                    }
                }
            }
        }
    }

    // Extract parameters from a method call (e.g., logInfo(:param))
    private fun extractParamsFromMethod(method: String): List<Any> {
        // Extract method parameters (e.g., :param)
        return listOf(method.substringAfter("(").substringBefore(")"))
    }
}