package com.devmasterteam.custoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devmasterteam.custoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    // Função responsável por fazer a criação da Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Faz com que o ViewBinding identifique os elementos e mapeie para 'binding'
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Faz a atribuição do layout
        setContentView(binding.root)

        // Acesso aos elementos de interface via 'binding'
        binding.buttonCalculate.setOnClickListener(this)

        // Diferente maneira de responder ao click
        /*binding.buttonCalculate.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }
        })*/
    }

    // Função responsável por tratar qualquer evento de click nos elementos
    override fun onClick(view: View) {
        // Obtém o Id do elemento clicado
        val id: Int = view.id

        // Verifica se o elemento é o que nos interessa
        if (id == R.id.button_calculate) {
            calculate()
        }
    }

    // Função responsável por realizar o cálculo dos gastos com a viagem
    // Baseado na distância percorrida * preço médio do combustível / pela autonomia do veículo
    private fun calculate() {
        if (isValidationOk()) {

            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            // Realiza o cálculo ((distancia * preço) / autonomia)
            val total = (distance * price) / autonomy

            // Seta o valor calculado na tela - Formatado com duas casas
            binding.textTotalValue.text = "R$ ${"%.2f".format(total)}"


        } else {
            // Caso não tenha preenchido todos os campos, solicita o preenchimento
            Toast.makeText(this, getString(R.string.validation_fill_all_fields), Toast.LENGTH_SHORT)
                .show()
        }
    }

    /**
     * Verifica se todos os campos foram preenchidos
     */
    private fun isValidationOk(): Boolean = (
            binding.editDistance.text.toString() != "" &&
                    binding.editPrice.text.toString() != "" &&
                    binding.editAutonomy.text.toString() != "" &&
                    binding.editAutonomy.text.toString() != "0"
            )
}