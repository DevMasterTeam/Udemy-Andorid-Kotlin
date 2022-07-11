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

    // Lista de valores - Spinner dinâmico
    private val mList = listOf("Gramas", "Kg", "Arroba", "Tonelada")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener(this)
        binding.buttonSnack.setOnClickListener(this)
        binding.buttonGetSpinner.setOnClickListener(this)
        binding.buttonSetSpinner.setOnClickListener(this)

        binding.spinnerDynamic.onItemSelectedListener = this

        binding.seekbar.setOnSeekBarChangeListener(this)

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
                val toast = Toast.makeText(this, "TOAST", Toast.LENGTH_SHORT)

                // Posicionamento
                toast.setGravity(Gravity.BOTTOM, 0, 100)

                // Cor do texto - Layout original
                // val textView = toast.view.findViewById<TextView>(android.R.id.message)
                // textView.text = "Custom!"
                // textView.setTextColor(Color.RED)

                // Inflamos um layout criado especificamente para a toast
                val toastLayout = layoutInflater.inflate(R.layout.toast_layout, null)
                toast.view = toastLayout

                toast.show()
            }
            R.id.button_snack -> {
                val snackbar = Snackbar.make(binding.linearRoot, "Snack", Snackbar.LENGTH_LONG)

                // Mudando a cor do texto
                snackbar.setTextColor(Color.MAGENTA)

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
                loadSpinner()
                binding.spinnerStatic.setSelection(1)
                binding.spinnerDynamic.adapter = null
            }
            R.id.button_get_seekbar -> {
                toast(binding.seekbar.progress.toString())
            }
            R.id.button_set_seekbar -> {
                binding.seekbar.progress = 10
            }
        }
    }

    // Eventos Spinner
    override fun onNothingSelected(parent: AdapterView<*>?) {
        toast("NOTHING")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val value = parent?.getItemAtPosition(position).toString()
        toast(value)
    }

    // Eventos Seekbar
    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        binding.textSeekbarValue.text = progress.toString()
    }

    /**
     * Trata evento de toque inicial no Seekbar - Quando o componente começa a ser arastado
     * */
    override fun onStartTrackingTouch(seekBar: SeekBar) {
        toast("Start seekbar")
    }

    /**
     * Trata evento de toque final no Seekbar
     * */
    override fun onStopTrackingTouch(seekBar: SeekBar) {
        toast("End seekbar")
    }

    // Switch E checkbox
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
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDynamic.adapter = adapter
    }

    /**
     * Facilita uso da Toast notification
     */
    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

}