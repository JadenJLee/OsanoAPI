package response_data

data class OutputData (
    val code: String,
    val currValue: Double,
    val percentChangeFromBTC: String,
    val moneyChange: Double,
)