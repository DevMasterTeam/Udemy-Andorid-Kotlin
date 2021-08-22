package objectCompanionObject

/**
 * companion object - Sempre somente 1 por classe. Pode ou não ser nomeado.
 * object - Quantos desejar por classe. Deve ter nome.
 * --
 * É comparável ao static do Java. Porém, caso seja preciso chamar a partir do Java,
 * deve ser feito a annotation @JvmStatic.
 * --
 * Ambos companion object e object são inicializados a primeira vez que são acessados.
 * Nas demais vezes, o valor já está disponível na execução do programa.
 */
fun main() {
    // Init disparado
    Empresa.Inscricao.numero

    // Init não é mais chamado
    Empresa.Inscricao.numero
    Empresa.Inscricao.numero
}

class Empresa {
    object Inscricao {
        val numero = "1447EYFN"
        fun abc() {}

        init {
            print("Init disparado!")
        }
    }

    companion object NOME {
        val setor = "Agropecuario"

        init {
            print("Init disparado!")
        }
    }
}