import services.fetchBTCCompList
import response_data.OutputData
import services.ExchangeRateService



fun main() {
    val out: MutableList<OutputData> = mutableListOf()

    val input = validateUserInput(System.`in`, System.out)
    val exchangeRateService = ExchangeRateService()
    val cryptoList = exchangeRateService.fetchExchangeRates(input)
    val mapOfBTCPairs = fetchBTCCompList()

    calculateOutputData(cryptoList, mapOfBTCPairs, out)

    out.forEach { outputData ->
        println("Code: ${outputData.code}")
        println("Current Value: ${outputData.currValue} coin(s) is worth 1 $input")
        println("Percent Change from BTC: ${outputData.percentChangeFromBTC}%")
        println("Total Money ${outputData.moneyChange} $input")
        println("======================================")
    }
}
