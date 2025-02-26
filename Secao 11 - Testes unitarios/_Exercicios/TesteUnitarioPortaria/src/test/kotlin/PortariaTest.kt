import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PortariaTest {

    val negadoMenoresDeIdade = "Negado. Menores de idade não são permitidos."
    val conviteInvalido = "Negado. Convite inválido."
    val welcome = "Welcome :)"

    @Test
    @DisplayName("Negar entrada para menores de idade.")
    fun validaMenoresDeIdade() {
        val str = portaria(15, "", "")
        Assertions.assertEquals(negadoMenoresDeIdade, str)
    }

    @Test
    @DisplayName("Negar entrada para tipo de convite inválido.")
    fun validaTipoDeConvite() {
        val str = portaria(25, "aksjdbgakjsdbg", "")
        Assertions.assertEquals(conviteInvalido, str)
    }

    @Test
    @DisplayName("Negar entrada para convite comum com código inválido.")
    fun validaConviteValidoCodigoInvalidoComum() {
        val str = portaria(25, "comum", "xx541518")
        Assertions.assertEquals(conviteInvalido, str)
    }

    @Test
    @DisplayName("Negar entrada para convite luxo com código inválido.")
    fun validaConviteValidoCodigoInvalidoLuxo() {
        val str = portaria(25, "luxo", "xx541518")
        Assertions.assertEquals(conviteInvalido, str)
    }

    @Test
    @DisplayName("Negar entrada para convite premium com código inválido.")
    fun validaConviteValidoCodigoInvalidoPremium() {
        val str = portaria(25, "premium", "xx541518")
        Assertions.assertEquals(conviteInvalido, str)
    }

    @Test
    @DisplayName("Permitir entrada para convite comum com código válido.")
    fun validaConviteValidoCodigoValidoComum() {
        val str = portaria(25, "comum", "xt1854258")
        Assertions.assertEquals(welcome, str)
    }

    @Test
    @DisplayName("Permitir entrada para convite premium com código válido.")
    fun validaConviteValidoCodigoValidoPremium() {
        val str = portaria(25, "premium", "xl1854258")
        Assertions.assertEquals(welcome, str)
    }

    @Test
    @DisplayName("Permitir entrada para convite luxo com código válido.")
    fun validaConviteValidoCodigoValidoLuxo() {
        val str = portaria(25, "luxo", "xl1854258")
        Assertions.assertEquals(welcome, str)
    }

    @Test
    @DisplayName("Negar entrada para convite comum sem código.")
    fun validaConviteValidoSemCodigoComum() {
        val str = portaria(50, "comum", "")
        Assertions.assertEquals(conviteInvalido, str)
    }
}