package control

import business.ConvidadoBusiness
import entity.Convidado

class Portaria {

    private val convidadoBusiness = ConvidadoBusiness()

    init {
        println("Portaria inicializada.")
        println(controle())
    }

    private fun controle(): String {
        val idade = Console.readInt("Qual sua idade? ")
        if (!convidadoBusiness.maiorDeIdade(idade)) {
            return "Negado. Menores de idade não são permitidos."
        }

        val tipoConvite = Console.readString("Qual é o tipo de convite? ")
        if (!convidadoBusiness.tipoValido(tipoConvite)) {
            return "Negado. Convite inválido."
        }

        val codigoConvite = Console.readString("Qual o código do convite? ")
        val convidado = Convidado(idade, tipoConvite, codigoConvite)

        return if (convidadoBusiness.conviteValido(convidado)) {
            "Welcome :)"
        } else {
            "Negado. Convite inválido"
        }
    }
}