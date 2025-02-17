/**
 * Resolução usando funcionalidade de if/else if.
 */
fun ex1(cargo: String): Float {
    var bonus = 0f
    if (cargo == "Gerente") {
        bonus = 2000f
    } else if (cargo == "Coordenador") {
        bonus = 1500f
    } else if (cargo == "Engenheiro de software") {
        bonus = 1000f
    } else if (cargo == "Estagiário") {
        bonus = 500f
    }
    return bonus
}

/**
 * Controle de fluxos aninhados.
 */
fun ex2(cargo: String, anos: Int): Float {
    var bonus = 0f
    if (cargo == "Gerente") {
        if (anos < 2) {
            bonus = 2000f
        } else {
            bonus = 3000f
        }
    } else if (cargo == "Coordenador") {
        if (anos < 1) {
            bonus = 1500f
        } else {
            bonus = 1800f
        }
    } else if (cargo == "Engenheiro de software") {
        bonus = 1000f
    } else if (cargo == "Estagiário") {
        bonus = 500f
    }
    return bonus
}

/**
 * Usando a propriedade do if else de ser uma expressão.
 * Fazendo uso de variável auxiliar para armazenar valor.
 */
fun ex2Variacao1(cargo: String, anos: Int): Float {
    var bonus = 0f
    if (cargo == "Gerente") {
        bonus = if (anos < 2) 2000f else 3000f
    } else if (cargo == "Coordenador") {
        bonus = if (anos < 1) 1500f else 1800f
    } else if (cargo == "Engenheiro de software") {
        bonus = 1000f
    } else if (cargo == "Estagiário") {
        bonus = 500f
    }
    return bonus
}

/**
 * Usando a propriedade do if else de ser uma expressão.
 * Sem necessidade de variável auxiliar para armazenar valor.
 */
fun ex2Variacao2(cargo: String, anos: Int): Float {
    return if (cargo == "Gerente") {
        if (anos < 2) 2000f else 3000f
    } else if (cargo == "Coordenador") {
        if (anos < 1) 1500f else 1800f
    } else if (cargo == "Engenheiro de software") {
        1000f
    } else if (cargo == "Estagiário") {
        500f
    } else {
        0f
    }
}

/**
 * Prática de ordem de operadores e avaliação de conjunção, disjunção e negação.
 * */
fun ex3() {
    val a = false
    val b = false
    val c = true
    val d = true

    println(a && b && c && d)
    println(!a && !b && (c && d))
    println(a && ((b || c) || d))
    println(a || ((!b && c) || !d))
}