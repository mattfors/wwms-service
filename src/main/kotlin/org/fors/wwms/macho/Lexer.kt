package org.fors.wwms.macho

import java.lang.reflect.Method

object Lexer {

    fun lex(tokens: List<Token>): List<Token> {
        val lexedTokens = mutableListOf<Token>()

        tokens.forEach { token ->
            when (token.type) {
                TokenType.SQL -> {
                    // Here, we can add logic to check if the SQL is valid
                    if (token.value.contains("DROP", true)) {
                        println("Warning: SQL contains 'DROP' operation!")
                    }
                    lexedTokens.add(token)
                }
                TokenType.METHOD -> {
                    // Extract the method name from the method call (before the opening parenthesis)
                    val methodName = token.value.split("(")[0].trim()

                    // Check if the method is registered in the MethodRegistry
                    if (MethodRegistry.isMethodRegistered(methodName)) {
                        lexedTokens.add(token)
                    } else {
                        println("Warning: Unknown method: $methodName at line ${token.lineNumber}, position ${token.start}")
                    }
                }
                TokenType.PIPE -> {
                    lexedTokens.add(token)
                }
            }
        }

        return lexedTokens
    }
}