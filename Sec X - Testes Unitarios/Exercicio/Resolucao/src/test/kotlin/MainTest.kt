import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainTest {

    @Test
    @DisplayName("Faz o teste dos cenarios da portaria")
    fun testPortaria() {
        Assertions.assertAll(
            { Assertions.assertEquals(portaria(15, "comum", cod = "xt51"), "Negado.") },
            { Assertions.assertEquals(portaria(19, "comum", cod = "xt51"), "Welcome.") },
            { Assertions.assertEquals(portaria(15, "mega", cod = "xt51"), "Negado.") },
            { Assertions.assertEquals(portaria(19, "mega", cod = "xt51"), "Negado.") },
            { Assertions.assertEquals(portaria(50, "premium", cod = "xl98451"), "Welcome.") },
            { Assertions.assertEquals(portaria(40, "luxo", cod = "LX51"), "Negado.") },
            { Assertions.assertEquals(portaria(40, "", cod = "LX51"), "Negado.") },
            { Assertions.assertEquals(portaria(40, "luxo", cod = ""), "Negado.") },
        )
    }

}