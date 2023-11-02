import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.fetchBTCCompList


class BinanceServiceTest {


    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun testFetchBTCCompList() {
        val result = fetchBTCCompList()
        // Check that the response contains BTC symbols
        assert(result.isNotEmpty())
        assert(result.keys.all { it.contains("BTC") })
    }
}