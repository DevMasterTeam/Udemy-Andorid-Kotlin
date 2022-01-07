fun main() {
    saudacao(true)
    saudacao(false)

    maiorDeIdade(15)
    maiorDeIdade(21)
}

fun saudacao(manha: Boolean) {
    if (manha) {
        println("Acorde!")
    }
}

fun maiorDeIdade(idade: Int) {
    if (idade >= 18) {
        println("Maior de idade")
    }
}