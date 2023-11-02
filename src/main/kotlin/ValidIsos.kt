import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

val validIsos: Set<String> = readIsoCsv("currencies.csv")


fun readIsoCsv(filepath: String): Set<String> {
    val inputStream = object {}.javaClass.classLoader.getResourceAsStream(filepath)
    val csv = csvReader().readAll(inputStream)
    return csv.drop(1).map { it[0] }.toSet() // weird way of putting: take the first column from csv
}

