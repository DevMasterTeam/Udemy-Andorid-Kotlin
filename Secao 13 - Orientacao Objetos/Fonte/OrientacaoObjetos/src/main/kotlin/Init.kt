class Animal(val especie: String) {
    var fala: String = ""

    init {
        fala = when (especie.lowercase()) {
            "cachorro" -> "au"
            "gato" -> "miau"
            else -> ""
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

fun main() {
    val nina = Animal("")
}
