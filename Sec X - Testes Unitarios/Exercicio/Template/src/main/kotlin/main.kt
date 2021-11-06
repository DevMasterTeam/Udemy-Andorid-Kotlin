fun portaria(idade: Int, tpConvite: String, cod: String): String {
    if (idade < 18) {
        return "Negado."
    }

    if (tpConvite != "") {
        val tipoConvite = tpConvite.lowercase()

        if (tipoConvite != "comum" && tipoConvite != "premium" && tipoConvite != "luxo") {
            return "Negado."
        }

        if (cod != "") {
            val codigo = cod.lowercase()
            return if (tipoConvite == "comum" && codigo.startsWith("xt")) {
                "Welcome."
            } else if ((tipoConvite == "premium" || tipoConvite == "luxo") && codigo.startsWith("xl")) {
                "Welcome."
            } else {
                "Negado."
            }
        }
    }
    return "Negado."
}