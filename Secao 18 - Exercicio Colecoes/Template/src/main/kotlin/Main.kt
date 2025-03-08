import business.TravelAnalysis
import data.DataStorage

fun main() {

    // Obtém a massa de dados
    val ships = DataStorage.generateShips()
    val travels = DataStorage.generateTravels()

    println("Quantos navios do tipo Pirata a frota possui?")
    println("Possui ${TravelAnalysis.countPirateShips(ships)} navios. \n")

    println("Qual o valor da viagem mais cara?")
    println("A viagem mais cara custou ${TravelAnalysis.getMostExpensiveTravel(travels)} moedas de ouro. \n")

    println("Qual foi o custo médio das viagens para o Black Pearl?")
    println("Custo médio das viagens do Black Pearl foi ${TravelAnalysis.getAverageCostForBlackPearl(ships, travels)}. \n")

    println("Qual o nome do navio com a maior capacidade de carga?")
    println("Navio com a maior carga se chama ${TravelAnalysis.getShipWithBiggestCargoCapacity(ships)}. \n")

    println("Qual navio fez a viagem mais longa? E qual a duração?")
    val firstEntry = TravelAnalysis.getShipNameForLongestTravelAndDuration(travels).entries.first()
    println("A viagem mais longa foi de ${firstEntry.value} dias e pertence ao navio ${firstEntry.key}. \n")

}