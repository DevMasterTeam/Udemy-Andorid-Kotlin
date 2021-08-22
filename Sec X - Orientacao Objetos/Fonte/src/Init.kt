import java.util.*

fun main() {
    val nina = Animal("Cachorro")
}

class Animal(val tipo: String) {
    var fala: String = ""

    init {
        fala = if (tipo.lowercase() == "cachorro") {
            "au"
        } else if (tipo.lowercase() == "gato") {
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