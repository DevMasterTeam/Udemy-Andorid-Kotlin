fun main() {

    // Atenção a ordem que os operadores são avaliados
    var result = 2 + 3 * 4
    println(result)

    result = (2 + 3) * 4
    println(result)

    // Ordem de prioridade
    // Quando um parênteses é definido, é a primeira prioridade a ser tratada
    // () 
    // * / %
    // + -
}