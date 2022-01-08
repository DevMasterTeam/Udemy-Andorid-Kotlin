package control

class Console {
    companion object {
        fun readInt(msg: String): Int {
            var retorno: Int? = null
            do {
                print(msg)
                val info = readLine()
                if (info != null && info != "") {
                    retorno = info.toIntOrNull()

                    if (retorno == null) {
                        println("Valor inválido.")
                    }

                }
            } while (retorno == null)

            return retorno
        }

        fun readString(msg: String): String {
            print(msg)
            val info = readLine()
            if (info != null && info != "") {
                return info.lowercase()
            }
            return ""
        }
    }
}