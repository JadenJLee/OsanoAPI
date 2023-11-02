package services

import response_data.BinanceResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

fun fetchBTCCompList(): Map<String, Pair<String, String>> {
    val client = OkHttpClient()
    val apiUrl = "https://api.binance.us/api/v3/ticker/24hr"
    val request = Request.Builder().url(apiUrl).build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            throw Exception("Failed to get from binance: ${response.code}")
        }
        val json = Json { ignoreUnknownKeys = true }
        val responseBody = response.body?.string()
        val ratesResponse = responseBody?.let { it ->
            json.decodeFromString<List<BinanceResponse>>(it)
                .associate { it.symbol to (it.openPrice to it.priceChangePercent) } // to change it to a map
        }


        // Here I'm filtering out the JSON response to have only the stuff containing BTC
        if (ratesResponse != null) {
            return ratesResponse.filterKeys { it.contains("BTC")}
        } else {
            throw Exception("ratesResponse from Binance was null!")
        }
    }
}