fun main() {
    val gerente: Funcionario = Gerente()
    val analista: Funcionario = Analista()

    calculo(gerente)
    calculo(analista)
}

interface Funcionario {
    fun bonus()
}

class Gerente : Funcionario {
    override fun bonus() {
        println("Bônus do gerente.")
    }
}

class Analista : Funcionario {
    override fun bonus() {
        println("Bônus do analista.")
    }
}

fun calculo(f: Funcionario) {
    f.bonus()
}