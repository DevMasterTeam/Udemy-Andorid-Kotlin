package com.devmasterteam.componentes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import com.devmasterteam.componentes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener,
    SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonToast.setOnClickListener(this)
        binding.buttonSnack.setOnClickListener(this)

        binding.buttonGetSpinner.setOnClickListener(this)
        binding.buttonSetSpinner.setOnClickListener(this)

        binding.spinnerDynamic.onItemSelectedListener = this

        binding.seekbar.setOnSeekBarChangeListener(this)
        binding.buttonGetSeekbar.setOnClickListener(this)
        binding.buttonSetSeekbar.setOnClickListener(this)

        binding.switchOnOff.setOnCheckedChangeListener(this)
        binding.checkboxOnOff.setOnCheckedChangeListener(this)
        binding.radioYes.setOnCheckedChangeListener(this)
        binding.radioNo.setOnCheckedChangeListener(this)

        // Carrega valores para spinner
        loadSpinner()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_toast -> {

                // A partir da API 31, Toast Notification possui ícone da aplicação
                val toast = Toast.makeText(this, "TOAST", Toast.LENGTH_SHORT)

                // É possível manipular a view da toast, porém já está deprecated
                // Como alternativa caso precise de customização, recomenda-se snack bar.
                // toast.view

                // Posicionamento - Funciona somente até API 29
                toast.setGravity(Gravity.TOP, 15, 50)
                toast.show()
            }
            R.id.button_snack -> {
                val snackbar = Snackbar.make(binding.linearRoot, "Snack", Snackbar.LENGTH_LONG)

                // Mudando a cor do texto
                snackbar.setTextColor(Color.MAGENTA)

                // Caso possua uma mensagem muito grande, quantidade de linhas é customizável
                snackbar.setTextMaxLines(5);

                // Ação dentro da snackbar
                snackbar.setAction("Desfazer", View.OnClickListener {
                    Snackbar.make(binding.linearRoot, "Desfeito!", Snackbar.LENGTH_SHORT).show()
                })

                // Customizar a cor do texto de ação
                snackbar.setActionTextColor(Color.BLUE)

                // Mudando a cor do plano de fundo
                snackbar.setBackgroundTint(Color.GREEN)

                snackbar.show()
            }
            R.id.button_get_spinner -> {
                // String
                val selectedItem = binding.spinnerStatic.selectedItem
                // Valores
                val selectedItemId = binding.spinnerStatic.selectedItemId
                val selectedItemPosition = binding.spinnerStatic.selectedItemPosition
            }
            R.id.button_set_spinner -> {
                binding.spinnerStatic.setSelection(1)
            }
            R.id.button_get_seekbar -> {
                toast(binding.seekbar.progress.toString())
            }
            R.id.button_set_seekbar -> {
                binding.seekbar.progress = 10
            }
        }
    }

    /**
     * Spinner - Evento de item selecionado
     **/
    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        // parent: AdapterView - Adapter onde a seleção ocorreu
        // view: View - Layout do elemento clicado
        // position: Int - Posição do elemento selecionado na lista
        // id: Long - Posição da linha selecionada

        val value = parent.getItemAtPosition(position).toString()
        toast(value)
    }

    /**
     * Spinner - Evento que pode ser disparado quando o adapter se torna vazio
     **/
    override fun onNothingSelected(parent: AdapterView<*>) {
        toast("NOTHING")
    }

    /**
     * Seekbar - Valor alterado
     **/
    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        // fromUser é true quando a alteração é feita pelo toque no elemento
        // Se a atribuição é feita por código, fromUser é false
        binding.textSeekbarValue.text = progress.toString()
    }

    /**
     * Seekbar - Quando o componente começa a ser arastado
     **/
    override fun onStartTrackingTouch(seekBar: SeekBar) {
        toast("Start seekbar")
    }

    /**
     * Seekbar - Trata evento de toque final no Seekbar
     **/
    override fun onStopTrackingTouch(seekBar: SeekBar) {
        toast("End seekbar")
    }

    /**
     * Switch, CheckBox e RadioButton
     **/
    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.switch_on_off -> {
                toast("Switch: ${if (isChecked) "On" else "Off"}")

                // Obter checked
                // switch_on_off.isChecked

                // Atribuit checked
                // switch_on_off.isChecked = true / false
            }
            R.id.checkbox_on_off -> {
                toast("Checkbox: ${if (isChecked) "On" else "Off"}")

                // Obter checked
                // checkbox_on_off.isChecked

                // Atribuit checked
                // checkbox_on_off.isChecked = true / false
            }
            R.id.radio_yes -> {
                toast("Radio yes: ${if (isChecked) "On" else "Off"}")

                // Obter radio
                // radio_yes.isChecked

                // Atribuit radio
                // radio_yes.isChecked = true / false
            }
            R.id.radio_no -> {
                toast("Radio no: ${if (isChecked) "On" else "Off"}")
            }
        }
    }

    /**
     * Carrega valores dinâmicos spinner
     */
    private fun loadSpinner() {
        val list = listOf("Gramas", "Kg", "Arroba", "Tonelada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)

        // Layout atua da mesma maneira, porém tem menos espaço entre os elementos
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        binding.spinnerDynamic.adapter = adapter
    }

    /**
     * Facilita uso da Toast notification
     */
    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

}