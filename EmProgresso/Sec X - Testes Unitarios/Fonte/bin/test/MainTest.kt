import org.junit.jupiter.api.*
import kotlin.IndexOutOfBoundsException

class MainTest {

    @Test
    @DisplayName("Funcionamento XO")
    fun testCountXO() {
        // Quando existem váris assertions, se uma falhar, as outras não são executadas.
        Assertions.assertTrue(countXO("xXoO"))
        Assertions.assertTrue(countXO("xxoo"))
        Assertions.assertFalse(countXO("ddddddddddddd"))

        // É possível fazer a verificação de todas as assertions mesmo que uma falhe
        Assertions.assertAll(
            { Assertions.assertTrue(countXO("xXoO")) },
            { Assertions.assertTrue(countXO("xxoo")) },
            { Assertions.assertFalse(countXO("ddddddddddddd")) }
        )
    }

    @Test
    @Disabled("Ainda não finalizado.")
    fun naoImplementado() {
    }

    @Test
    fun naoImplementadoMasInvalido() {
        // Vai falhar
        fail("Ainda não finalizado.")
    }

    @Test
    @Disabled("Roda baseado em condicao")
    fun rodaSomenteBaseadoEmCondicao() {
        // Suposição
        Assumptions.assumeTrue(countXO("xxoo"))
        // Assumptions.assumeFalse(countXO("xxoo"))

        // Resto do código só é executado se a suposição se mostrar como verdadeira
        Assertions.assertEquals(true, countXO("xxoo"))
    }

    @Test
    @DisplayName("Teste lancamento de excecao")
    fun lancaExcecao() {
        assertThrows<IndexOutOfBoundsException> {
            throw IndexOutOfBoundsException("Index fora do array.")
        }
    }

    @Test
    @DisplayName("Teste de não nulo.")
    fun testNotNull() {
        // Testa se o retorno da função é diferente de nulo.
        Assertions.assertNotNull(countXO("xo"))

        // Muito cuidado em cenários desse tipo, pois pode ser que a função
        // nunca tenha o retorno nulo. Nesse caso, esse teste nunca falha,
        // mesmo que a função esteja com comportamento incorreto.
    }

}