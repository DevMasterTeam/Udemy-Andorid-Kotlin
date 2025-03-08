import business.TravelAnalysis
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TravelAnalysisTest {

    // Obtém a massa de dados
    private val ships = DataStorage.generateShips()
    private val travels = DataStorage.generateTravels()

    @Test
    @DisplayName("Valida quantidade de navios Pirata a frota possui.")
    fun testHowManyPirateShipsTheFleetHas() {
        assertEquals(1, TravelAnalysis.countPirateShips(ships))
    }

    @Test
    @DisplayName("Valida o valor da viagem mais cara.")
    fun testMostExpensiveTravel() {
        assertEquals(30000.0, TravelAnalysis.getMostExpensiveTravel(travels))
    }

    @Test
    @DisplayName("Valida o custo médio das viagens para o Black Pearl.")
    fun testAverageCostForBlackPearl() {
        assertEquals(20000.0, TravelAnalysis.getAverageCostForBlackPearl(ships, travels))
    }

    @Test
    @DisplayName("Valida o navio com a maior capacidade de carga.")
    fun testShipWithBiggestCargoCapacity() {
        assertEquals("Master Ship", TravelAnalysis.getShipWithBiggestCargoCapacity(ships))
    }

    @Test
    @DisplayName("Valida o nome do navio que fez a viagem mais longa e sua duração.")
    fun testShipNameForLongestTravelAndDuration() {
        val result = TravelAnalysis.getShipNameForLongestTravelAndDuration(travels)
        assertTrue(result["Black Pearl"] == 15)
    }
}