package response_data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BinanceResponse(
    @SerialName("symbol")
    val symbol: String,
    @SerialName("openPrice")
    val openPrice: String,
    @SerialName("priceChangePercent")
    val priceChangePercent: String,
)
