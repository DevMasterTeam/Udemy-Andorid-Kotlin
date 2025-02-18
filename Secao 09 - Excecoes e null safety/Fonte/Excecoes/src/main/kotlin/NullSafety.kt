fun main() {
    // Em Kotlin, por padrão, as variáveis não podem conter valores nulos.
    // Se tentarmos atribuir `null` a uma variável do tipo `String` sem tratá-lo explicitamente,
    // teremos um erro de compilação.
    // var str: String = null // Erro de compilação

    // Para permitir que uma variável possa armazenar `null`,
    // devemos usar o operador `?`, tornando-a um tipo que aceita nulo.
    val str: String? = null

    // Ao acessar propriedades de uma variável que aceita nulo, usamos o operador `?.` (chamada segura).
    // Ele garante que, se a variável for `null`, o resultado da expressão também será `null`,
    // evitando exceções.
    println(str?.length) // Retorna null, pois `str` é null

    // O operador `!!` força o acesso ao valor da variável, assumindo que ela não é nula.
    // Se a variável for `null`, uma NullPointerException será lançada.

    // Descomentar a linha abaixo causará um erro de execução (NullPointerException)
    // println(str!!.length)
}