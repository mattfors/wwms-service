package org.fors.wwms.macho

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TokenizerTest {

    @Test
    fun testTokenize() {
        val input = """
            {select * from materials where material_id=:material_id}
            | logInfo(:description)
            | {select * from orders where description=:description}
        """.trimIndent()

        val expectedTokens = listOf(
            Token(TokenType.SQL, "select * from materials where material_id=:material_id", 0, 49, 1),
            Token(TokenType.PIPE, "|", 50, 51, 2),
            Token(TokenType.METHOD, "logInfo(:description)", 52, 72, 2),
            Token(TokenType.PIPE, "|", 73, 74, 3),
            Token(TokenType.SQL, "select * from orders where description=:description", 75, 123, 3)
        )

        val actualTokens = Tokenizer.tokenize(input)
        println(actualTokens);

    }
}