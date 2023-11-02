import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.ExchangeRateService

class ExchangeRatesServiceTest {

    private lateinit var service: ExchangeRateService

    @BeforeEach
    fun setUp() {
        service = ExchangeRateService()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun `fetchExchangeRates success test`() {
        val rates = service.fetchExchangeRates("USD")
        assert(rates.isNotEmpty())
    }

    // There is no failure, it just returns a single pair with itself and 1.0 as the conversion.
//    @Test
//    fun `fetchExchangeRates failure test`() {
//        assertFailsWith<Exception> {
//            service.fetchExchangeRates("USD")
//        }
//    }

}