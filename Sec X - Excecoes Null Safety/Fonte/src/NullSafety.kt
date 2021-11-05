fun main() {

    // Kotlin não permite atribuir nulo a variável
    // var str: String = null

    // É necessário deixar explícito que a variável pode ser nula
    val str: String? = null

    // A partir desse momento, o uso da varíavel requer ? antes de acessar uma propriedade
    println(str?.length)

    // !! quando existe a certeza que a variável não é nula
    //str!!.length

    print("Seu valor?: ")
    val abc = readLine()
    println("Tamanho da string lida: ${abc!!.length}")

}