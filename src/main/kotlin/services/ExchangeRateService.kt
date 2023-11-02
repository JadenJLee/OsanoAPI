package services

import response_data.ExchangeRatesResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import validIsos

class ExchangeRateService {
    fun fetchExchangeRates(currencyCode: String): List<Pair<String, String>> {
        val client = OkHttpClient()
        val apiUrl = "https://api.coinbase.com/v2/exchange-rates?currency=$currencyCode"
        val request = Request.Builder().url(apiUrl).build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("Failed to get data: ${response.code}")
            }
            val responseBody = response.body?.string()
            val ratesResponse = responseBody?.let {
                Json.decodeFromString<ExchangeRatesResponse>(it)
            }

            // Filtering out everything that isn't crypto
            val cryptoExchangeRates = ratesResponse?.data?.rates?.filterKeys {
                it !in validIsos
            }

            cryptoExchangeRates?.let {
                println("Exchange rates for $currencyCode: $it")
            } ?: println("Failed to parse response.")

            if (cryptoExchangeRates != null) {
                return cryptoExchangeRates.toList()
            } else {
                throw Exception("Something went wrong line34 Services.ExchangeRateService.kt")
            }
        }
    }

}

