fun main() {

    // Kotlin não permite atribuir nulo a variável
    // var str: String = null

    // É necessário deixar explícito que a variável pode ser nula
    val str: String? = null

    // A partir desse momento, o uso da varíavel requer ? antes de acessar uma propriedade
    println(str?.length)

    // O bloco dentro do let só é executado se o valor é diferente de nulo
    // O bloco let cria algo chamado "scope function" que é basicamente um escopo específico
    // para o objeto referenciado, no caso "str".
    // Dentro do bloco let, a referência ao objeto passa a ser "it".
    str?.let {
        println("Scope function")
        it.uppercase()
        it.length
    }

    // !! quando existe a certeza que a variável não é nula
    //str!!.length

    print("Seu valor?: ")
    val abc = readLine()
    println("Tamanho da string lida: ${abc!!.length}")

}