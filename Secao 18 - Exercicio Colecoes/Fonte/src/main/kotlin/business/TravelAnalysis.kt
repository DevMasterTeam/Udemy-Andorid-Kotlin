package business

import entity.Ship
import entity.Travel
import utils.ShipType

class TravelAnalysis private constructor() {

    companion object {

        // Quantos navios do tipo Pirata a frota possui?
        fun countPirateShips(ships: List<Ship>): Int {
            return ships.filter { it.type == ShipType.PIRATE }.size
        }

        // Qual o valor da viagem mais cara?
        fun getMostExpensiveTravel(travels: List<Travel>): Double {
            return travels.maxByOrNull { it.cost }?.cost ?: 0.0
        }

        // Qual foi o custo médio das viagens para o Black Pearl?
        fun getAverageCostForBlackPearl(ships: List<Ship>, travels: List<Travel>): Double {
            val blackPearl = ships.find { it.name == "Black Pearl" }
            return travels.filter { it.ship == blackPearl }
                .map { it.cost }
                .average()
        }

        // Qual o nome do navio com a maior capacidade de carga?
        fun getShipWithBiggestCargoCapacity(ships: List<Ship>): String {
            return ships.maxByOrNull { it.cargoCapacity }?.name ?: ""
        }

        // Qual o nome do que navio fez a viagem mais longa? E qual a duração?
        fun getShipNameForLongestTravelAndDuration(travels: List<Travel>): Map<String, Int> {
            val longestTravel = travels.maxByOrNull { it.durationDays }
            return mapOf(Pair(longestTravel?.ship?.name ?: "", longestTravel?.durationDays ?: 0))
        }

    }

}