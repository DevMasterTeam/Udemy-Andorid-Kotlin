import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.NullPointerException

/**
 * Exceção é um comportamente não esperado no código.
 * Caso uma exceção não tratada ocorra, ocasiona o fechamento da aplicação.
 * --
 * try-catch é uma maneira de tratar problemas esperados e principalmente não esperados.
 * finally é uma instrução opcional, pode existir try-catch sem finally.
 * finally, diferente do catch, é SEMPRE executado. Catch só é executado quando existe exceção.
 */
fun main() {

    /**
     * Quando existe mais de um tipo de exceção sendo capturada,
     * a Exception mais genérica deve sempre vir por último.
     * No caso, trata-se a exceção de formato de número para depois tratar a exceção genérica.
     */
    try {
        val str: String? = null
        println(str!!.length) // NullPointerException
        println(12 / 0) // ArithmeticException
    } catch (e: ArithmeticException) {
        println("Divisão por zero!")
    } catch (e: NullPointerException) {
        println("NullPointer!!")
    } catch (e: Exception) {
        println("Tivemos um problema.")
    } finally {
        println("Finalmente!")
    }

}