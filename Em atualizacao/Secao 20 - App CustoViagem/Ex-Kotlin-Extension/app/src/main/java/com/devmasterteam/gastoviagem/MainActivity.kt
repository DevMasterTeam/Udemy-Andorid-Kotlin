package com.devmasterteam.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textKotlin: TextView

    /**
     * Função responsável por fazer a criação da Activity
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adiciona evento ao elemento de interface
        buttonCalculate.setOnClickListener(this)
    }

    /**
     * Função responsável por tratar qualquer evento de click nos elementos
     * */
    override fun onClick(view: View) {
        // Obtém o Id do elemento clicado
        val id: Int = view.id

        // Verifica se o elemento é o que nos interessa
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    /**
     * Função responsável por realizar o cálculo dos gastos com a viagem
     * Baseado na distância percorrida * preço médio do combustível / pela autonomia do veículo
     */
    private fun calculate() {
        if (isValidationOk()) {

            val distance = editDistance.text.toString().toFloat()
            val price = editPrice.text.toString().toFloat()
            val autonomy = editAutonomy.text.toString().toFloat()

            // Realiza o cálculo ((distancia * preço) / autonomia)
            val total = (distance * price) / autonomy

            // Seta o valor calculado na tela - Formatado com duas casas
            textResult.text = "R$ ${"%.2f".format(total)}"
        } else {
            // Caso não tenha preenchido todos os campos, solicita o preenchimento
            Toast.makeText(this, getString(R.string.validation_fill_all_fields), Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Verifica se todos os campos foram preenchidos
     */
    private fun isValidationOk(): Boolean = (
            editDistance.text.toString() != "" &&
                    editPrice.text.toString() != "" &&
                    editAutonomy.text.toString() != "" &&
                    editAutonomy.text.toString() != "0"
            )

}
