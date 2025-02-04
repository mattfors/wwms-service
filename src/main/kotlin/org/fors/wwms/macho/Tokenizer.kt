package org.fors.wwms.macho

data class Token(val type: TokenType, val value: String, val start: Int, val end: Int, val lineNumber: Int)

enum class TokenType {
    SQL, METHOD, PIPE
}

object Tokenizer {

    // Define regex patterns for SQL, methods, and pipes
// Define regex patterns for SQL, methods, and pipes
    private val SQL_REGEX = "\\{([^}]*)\\}".toRegex()     // Anything within { }
    private val PIPE_REGEX = "\\|".toRegex()         // Pipe symbol "|"
    private val METHOD_REGEX = "[a-zA-Z_][a-zA-Z0-9_]*\\([^)]*\\)".toRegex()   // Java method syntax, e.g. logInfo(:description)


    fun tokenize(input: String): List<Token> {
        val tokens = mutableListOf<Token>()
        var remainder = input
        var currentPosition = 0
        var currentLineNumber = 1

        while (remainder.isNotEmpty()) {
            when {
                remainder.startsWith("\n") -> {
                    remainder = remainder.substring(1)
                    currentPosition += 1
                    currentLineNumber += 1
                }
                remainder.startsWith("|") -> {
                    tokens.add(Token(TokenType.PIPE, "|", currentPosition, currentPosition + 1, currentLineNumber))
                    remainder = remainder.substring(1)
                    currentPosition += 1
                }
                SQL_REGEX.containsMatchIn(remainder) -> {
                    val sqlMatch = SQL_REGEX.find(remainder)
                    if (sqlMatch != null && sqlMatch.range.first == 0) {
                        val sqlValue = sqlMatch.groupValues[1]
                        val start = currentPosition
                        val end = currentPosition + sqlMatch.value.length
                        tokens.add(Token(TokenType.SQL, sqlValue, start, end, currentLineNumber))
                        remainder = remainder.substring(sqlMatch.value.length)
                        currentPosition += sqlMatch.value.length
                    } else {
                        remainder = remainder.substring(1)
                        currentPosition += 1
                    }
                }
                METHOD_REGEX.containsMatchIn(remainder) -> {
                    val methodMatch = METHOD_REGEX.find(remainder)
                    if (methodMatch != null && methodMatch.range.first == 0) {
                        val methodValue = methodMatch.value
                        val start = currentPosition
                        val end = currentPosition + methodMatch.value.length
                        tokens.add(Token(TokenType.METHOD, methodValue, start, end, currentLineNumber))
                        remainder = remainder.substring(methodMatch.value.length)
                        currentPosition += methodMatch.value.length
                    } else {
                        remainder = remainder.substring(1)
                        currentPosition += 1
                    }
                }
                else -> {
                    remainder = remainder.substring(1)
                    currentPosition += 1
                }
            }
        }

        return tokens
    }
}