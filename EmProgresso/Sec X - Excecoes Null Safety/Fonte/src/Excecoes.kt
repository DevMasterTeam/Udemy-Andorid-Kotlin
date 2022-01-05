import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.NullPointerException

fun main() {
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