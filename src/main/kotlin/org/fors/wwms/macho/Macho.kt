package org.fors.wwms.macho

/**
 * MACHO (Method And Command Handling Operations) Language
 *
 * MACHO is a simple, lightweight domain-specific language (DSL) designed to execute SQL queries and
 * Java methods in a pipeline-based format. The language allows you to compose SQL queries, Java method calls,
 * and control flow logic in a flexible and dynamic manner. It supports parameterized SQL, Java method invocations,
 * and piping results between operations.
 *
 * The key concept behind MACHO is the **pipe** (`|`) which connects multiple commands, allowing the output
 * of one operation to serve as the input for the next. This structure facilitates a high degree of composability
 * between SQL queries, Java methods, and their interactions.
 *
 * The MACHO language can be used in scenarios where:
 * - SQL queries need to be dynamically constructed and executed.
 * - Java methods need to be invoked with dynamic parameters.
 * - A seamless integration between SQL and Java is required for data processing.
 *
 * Example Syntax:
 * <pre>
 * {select * from materials where material_id=:material_id} | logInfo(:description) | {select * from orders where description=:description}
 * </pre>
 * The above statement can be interpreted as:
 * 1. A SQL query is executed to retrieve data from the "materials" table with a dynamic `material_id`.
 * 2. The result of the SQL query is passed to the `logInfo` method, logging the `description` value.
 * 3. Finally, the logged `description` is used in a second SQL query to fetch data from the "orders" table.
 *
 * In MACHO:
 * - Anything inside `{}` is a SQL query.
 * - Anything outside of `{}` is considered a Java method invocation.
 * - Parameters inside methods are prefixed with `:` (e.g., `:material_id`).
 * - Pipe (`|`) is used to chain operations together, passing the results of one operation as input to the next.
 *
 * Key Features:
 * - **SQL Execution**: The language allows for executing parameterized SQL queries within a flexible pipeline.
 * - **Java Method Invocations**: Methods can be invoked dynamically as part of the pipeline, providing rich data manipulation and processing capabilities.
 * - **Pipelining**: Results from SQL queries or Java methods can be passed through pipes, enabling complex data transformations and actions to be performed in sequence.
 * - **Dynamic Parameter Replacement**: Parameters in SQL queries and method invocations can be dynamically replaced, allowing for custom data filtering and processing.
 * - **Integration with Java**: Easily integrate Java methods and functions into the pipeline, allowing for custom logic, logging, and error handling.
 *
 * How It Works:
 * - **Tokenization**: The input string is tokenized into SQL commands, Java method invocations, and pipes.
 * - **Execution**: The appropriate SQL is executed using a database connection (e.g., via Hibernate or MyBatis). Java methods are invoked using reflection or predefined registries.
 * - **Parameter Handling**: Parameters like `:material_id` are replaced with actual values, either from the execution context or the previous command’s output.
 *
 * Example Workflow:
 * 1. **SQL Command**: `{select * from materials where material_id=:material_id}`
 *    - A parameterized SQL query is executed, retrieving data from the "materials" table where `material_id` matches the provided value.
 * 2. **Method Invocation**: `logInfo(:partfam)`
 *    - The result of the previous SQL query is passed to the `logInfo` method, logging the `partfam` value.
 * 3. **Chaining**: The results from the `logInfo` call are used as input for another SQL query: `{select * from orders where partfam=:partfam}`.
 *
 * Example Use Cases:
 * - **Database Querying**: Perform complex SQL queries with dynamic filtering and conditions based on user input or system state.
 * - **Method Chaining**: Sequentially process data through multiple Java methods and SQL queries, transforming and logging results at each step.
 * - **Data Processing Pipelines**: Use MACHO as part of an ETL pipeline where raw data is retrieved, processed, logged, and transformed across multiple operations.
 *
 * Syntax Rules:
 * - SQL statements are enclosed in `{}` and can include parameter placeholders, such as `:parameter_name`.
 * - Java method invocations are written directly, and can reference previously executed commands using parameter placeholders.
 * - Use the pipe (`|`) operator to chain operations.
 * - The system can pass values from one operation to the next using parameter substitution.
 *
 * Example of MACHO language execution:
 *
 * <pre>
 * {select * from materials where material_id=:material_id} | logInfo(:partfam) | {select * from orders where partfam=:partfam}
 * </pre>
 *
 * MACHO Language can be extended or customized by adding new Java methods to the registry, enabling it to grow to
 * meet specific requirements.
 *
 * Registering Java methods allows for great flexibility, such as logging, complex transformations, or custom actions,
 * all while keeping the language simple and easy to extend.
 *
 * Concepts:
 * - **SQL Commands**: The execution of SQL commands allows interaction with your database (using your chosen ORM).
 * - **Java Methods**: Methods registered in your application are invoked with parameters defined in the MACHO syntax.
 * - **Pipes (`|`)**: Allow you to chain multiple commands together and pass values between them.
 *
 * Notes:
 * - Ensure that parameters passed between SQL commands and Java methods are properly handled and passed as input/output.
 * - Methods can be registered dynamically, allowing for extensibility based on application requirements.
 * - MACHO does not maintain state beyond the scope of its current execution, which means it is suitable for stateless applications.
 *
 * The MACHO language is ideal for use in scenarios where a simple, high-level DSL can automate complex sequences
 * of operations while providing flexibility and extensibility.
 */

object Macho {

    @JvmStatic
    fun logInfo(msg: String): String {
        println("Logging: $msg")
        return "Logged: $msg" // This is returned to be used in the next step
    }

    @JvmStatic
    fun main(args: Array<String>) {
        // Register methods beforehand (you could do this dynamically, too)
        MethodRegistry.registerMethod("logInfo", Macho::class.java.getMethod("logInfo", String::class.java))

        // Sample input with SQL, method, and pipe
        val input = "{select description from material where material_id=:material_id} | logInfo(:description) | {select * from order where description=:description}"

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