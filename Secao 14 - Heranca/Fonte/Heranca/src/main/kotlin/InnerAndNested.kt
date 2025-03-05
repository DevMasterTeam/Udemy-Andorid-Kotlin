/**
 * Uma classe interna pode ser usada para especializar e agrupar comportamentos e atributos dentro de outra classe.
 * De certa forma, cria um comportamento mais específico que está restrito dentro da classe.
 */
class Visibilidade {
    var str: String = ""

    fun abc() { }

    // inner class - Possui acesso aos atributos e métodos externos
    private inner class Teste1() {
        var id: Int = 0
        fun teste() {
            println(str)
            abc()
        }
    }

    // Nested class - NÃO possui acesso aos atributos e métodos externos
    private class Teste2() {
        var id: Int = 0
        fun teste() {
            // println(str)
            // abc()    
        }
    }

}