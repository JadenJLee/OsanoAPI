import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ValidIsosTest {

    @Test
    fun `valid Isos Don't Change Test`() {
        Assertions.assertEquals(
            validIsos, setOf(
                "AED", "AMD", "ANG", "ARS", "AUD", "BAM", "BDT", "BGN", "BHD", "BND", "BOB", "BRL", "BWP", "BYN", "CAD", "CHF",
                "CLP", "CNY", "COP", "CRC", "CZK", "DKK", "DOP", "DZD", "EGP", "EUR", "FJD", "GBP", "GEL", "GHS", "HKD", "HRK",
                "HUF", "IDR", "ILS", "INR", "IQD", "ISK", "JMD", "JOD", "JPY", "KES", "KRW", "KWD", "KZT", "LAK", "LBP", "LKR",
                "LTL", "MAD", "MMK", "MOP", "MUR", "MXN", "MYR", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN",
                "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "SAR", "SEK", "SGD", "SVC", "THB", "TND", "TRY", "TWD",
                "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VES", "VND", "XCD", "XOF", "XPF", "ZAR"
            )
        )

    }
}