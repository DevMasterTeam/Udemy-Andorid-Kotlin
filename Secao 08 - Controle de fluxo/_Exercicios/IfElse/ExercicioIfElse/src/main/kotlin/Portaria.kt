/**
 * Fazendo a resolução priorizando controle de fluxo aninhado.
 */
fun portaria(): String {
    print("Informe a idade: ")
    val idade = readLine().toString()

    if (idade.toInt() < 18) {
        return "Negado. Menores de idade não são permitidos."
    } else {
        print("Informe o tipo de convite: ")
        val tipo = readLine().toString().lowercase()

        if (tipo == "comum" || tipo == "premium" || tipo == "luxo") {
            print("Informe o código: ")
            val codigo = readLine().toString().lowercase()

            if (tipo == "comum" && codigo.startsWith("xt")) {
                return "Welcome :)"
            } else if (codigo.startsWith("xl")) {
                return "Welcome :)"
            } else {
                return "Negado. Convite inválido."
            }
        } else {
            return "Negado. Convite inválido."
        }
    }
}

/**
 * Fazendo o uso do conceito "early return", traduzindo "retorno antecipado" ou "retorno cedo".
 * Consiste em retornar assim que é possível uma vez que já se tenha o resultado.
 * Nesse caso, esse padrão ajudou na escrita sem controle de fluxo aninhado.
 */
fun portaria2(): String {
    print("Informe a idade: ")
    val idade = readLine().toString()

    if (idade.toInt() < 18) {
        return "Negado. Menores de idade não são permitidos."
    }

    print("Informe o tipo de convite: ")
    val tipo = readLine().toString().lowercase()

    if (tipo != "comum" && tipo != "premium" && tipo != "luxo") {
        return "Negado. Convite inválido."
    }

    print("Informe o código: ")
    val codigo = readLine().toString().lowercase()

    return if (tipo == "comum" && codigo.startsWith("xt")) {
        "Welcome :)"
    } else if (codigo.startsWith("xl")) {
        "Welcome :)"
    } else {
        "Negado. Convite inválido."
    }
}

fun main() {
    println(portaria2())
}