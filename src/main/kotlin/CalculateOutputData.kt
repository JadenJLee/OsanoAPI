import response_data.OutputData

fun calculateOutputData(cryptoList: List<Pair<String, String>>, mapOfBTCPairs: Map<String, Pair<String, String>>, out: MutableList<OutputData>) {
    // not all cryptocurrencies in the cryptoList is in the list of BTC pairs, so I omitted them.
    for ((symbol, price) in cryptoList) {
        val mapKey = symbol+"BTC"
        if (mapKey in mapOfBTCPairs) {
            val currValue = (1/price.toDouble())
            val percentChangeFromBTC = mapOfBTCPairs[mapKey]!!.second
            val openPrice = mapOfBTCPairs[mapKey]!!.first
            // so percentage change is ((lastPrice - OpenPrice) / OpenPrice) * 100
            // so we can take openPrice to find the value of 1 bitcoin to bnb 24 hours ago
            // We take that amount and then use the current price -> USD to convert how much money we have.
            var moneyChange = 0.0
            if (openPrice.toDouble() != 0.0) {
                // (initial bitcoin value in crypto * (1 + percentChange / 100)) * current rate to USD
                moneyChange = ((1/openPrice.toDouble()) * (1 + percentChangeFromBTC.toDouble() / 100)) * currValue
            }
            out += (
                    OutputData(
                        code = symbol,
                        currValue = currValue,
                        percentChangeFromBTC = percentChangeFromBTC, // double bang to assert not null because we check in if statement above
                        moneyChange = moneyChange
                    )
                    )
        }
    }
}