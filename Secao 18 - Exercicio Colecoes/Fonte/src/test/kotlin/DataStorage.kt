import entity.Ship
import entity.Travel
import utils.ShipType

class DataStorage private constructor() {
    companion object {
        private val blackPearl = Ship("Black Pearl", 1000.0, ShipType.PIRATE, 5000.0)
        private val queenMary = Ship("Master Ship", 5000.0, ShipType.CARGO, 15000.0)

        fun generateShips(): List<Ship> {
            return listOf(blackPearl, queenMary)
        }

        fun generateTravels(): List<Travel> {
            return listOf(
                Travel(blackPearl, 1000.0, 10000.0, 5),
                Travel(queenMary, 2000.0, 20000.0, 10),
                Travel(blackPearl, 3000.0, 30000.0, 15)
            )
        }
    }
}