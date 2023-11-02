import java.io.*

fun validateUserInput(inputStream: InputStream, outputStream: OutputStream): String {
    var input: String

    do {
        println("Please enter a ISO-4217 currency code, i.e. USD, EUR")
        input = BufferedReader(InputStreamReader(inputStream)).readLine().uppercase()
        if (!validateIso(input))
            println("Please enter a valid ISO-4217 currency code.")
        else
            PrintStream(outputStream).println("You entered: $input")
    } while (!validateIso(input))

    return input
}

fun validateIso(iso: String): Boolean {
    return iso in validIsos
}