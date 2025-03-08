package data

import entity.Ship
import entity.Travel
import utils.ShipType

class DataStorage private constructor() {
    companion object {
        private val blackPearl = Ship("Black Pearl", 1000.0, ShipType.PIRATE, 5000.0)
        private val highCommander = Ship("High Commander", 5000.0, ShipType.BATTLESHIP, 20000.0)
        private val queenMary = Ship("Queen Mary", 8000.0, ShipType.CARGO, 15000.0)
        private val titanicII = Ship("Titanic II", 7000.0, ShipType.CARGO, 12000.0)
        private val longBeard = Ship("Long Beard", 1200.0, ShipType.PIRATE, 6000.0)

        fun generateShips(): List<Ship> {
            return listOf(
                blackPearl,
                highCommander,
                queenMary,
                titanicII,
                longBeard
            )
        }

        fun generateTravels(): List<Travel> {
            return listOf(
                Travel(blackPearl, 1200.0, 10000.0, 5),
                Travel(highCommander, 3000.0, 25000.0, 10),
                Travel(queenMary, 4500.0, 40000.0, 15),
                Travel(titanicII, 3200.0, 35000.0, 12),
                Travel(longBeard, 1500.0, 12000.0, 6),
                Travel(blackPearl, 800.0, 7000.0, 3),
                Travel(blackPearl, 4000.0, 30000.0, 14),
                Travel(queenMary, 2500.0, 20000.0, 9)
            )
        }
    }
}