fun main() {

}

class Planeta {
    var nome: String = ""
        get() {
            // Acesso a propriedade diretamente causa recursão
            // println("Meu valor é $nome")
            // return nome

            // Maneira correta
            println("Meu valor é $field")
            return field
        }
        set(value) {
            if (value == "") {
                println("Todo planeta deve ter um nome.")
            } else {

                // Acesso a propriedade diretamente causa recursão
                // nome = value

                // Maneira correta
                field = value
            }
        }
}