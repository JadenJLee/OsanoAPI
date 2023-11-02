package response_data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRatesResponse(
    @SerialName("data")
    val data: CurrencyData
)

@Serializable
data class CurrencyData(
    val currency: String,
    val rates: Map<String, String>
)