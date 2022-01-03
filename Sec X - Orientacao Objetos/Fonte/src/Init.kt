import java.util.*

fun main() {
    val nina = Animal("Cachorro")
}

class Animal(val especie: String) {
    var fala: String = ""

    init {
        fala = if (especie.lowercase() == "cachorro") {
            "au"
        } else if (especie.lowercase() == "gato") {
            "miau"
        } else {
            ""
        }
    }

    init {
        println(fala)
    }

}

class Funcionario(val nome: String) {
    var tipoContrato: String = ""

    init {
        tipoContrato = "CLT"
    }
}