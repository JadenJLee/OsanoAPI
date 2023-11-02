import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class UserInputValidationTest {

    @Test
    fun `valid ISO input test`() {
        val inputStream = "USD".byteInputStream()
        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val expectedOutput = "Please enter a ISO-4217 currency code, i.e. USD, EUR\r\nYou entered: USD\r\n"

        val userInput = validateUserInput(inputStream, outputStream)

        assertEquals("USD", userInput)
        assertEquals(expectedOutput.trim(), outputStream.toString().trim())
    }
}