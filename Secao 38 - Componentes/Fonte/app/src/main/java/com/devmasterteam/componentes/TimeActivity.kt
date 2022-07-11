package com.devmasterteam.componentes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.devmasterteam.componentes.databinding.ActivityTimeBinding
import java.text.SimpleDateFormat
import java.util.*

class TimeActivity : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener,
    TimePicker.OnTimeChangedListener {

    private lateinit var binding: ActivityTimeBinding

    private var mBrazilLocale = Locale("pt", "BR")
    private val mSimpleDateFormat = SimpleDateFormat("dd/MM/yyyy", mBrazilLocale)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDate.setOnClickListener(this)
        binding.buttonGetTime.setOnClickListener(this)
        binding.buttonSetTime.setOnClickListener(this)

        binding.timepicker.setOnTimeChangedListener(this)

        // Poderia ser útil mostrar a progressbar enquanto uma chamada assíncrona é feita
        // Uma vez que a resposta é recebida, é possível remover o elemento.
        // progressbar.visibility = View.GONE

        // Da mesma maneira, é possível torná-lo visível
        // progressbar.visibility = View.VISIBLE
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_date -> {

                // Obtém a instância do calendário
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                // Mostra o Datepicker utilizando os dados de hoje
                DatePickerDialog(this, this, year, month, day).show()
            }
            R.id.button_get_time -> {
                if (Build.VERSION.SDK_INT >= 23) {
                    val hour = binding.timepicker.hour.toString()
                    val minute = binding.timepicker.minute.toString()
                    toast("$hour : $minute")
                } else {
                    val hour = binding.timepicker.currentHour
                    val minute = binding.timepicker.currentMinute
                    toast("$hour : $minute")
                }
            }
            R.id.button_set_time -> {
                if (Build.VERSION.SDK_INT >= 23) {
                    binding.timepicker.hour = 20
                    binding.timepicker.minute = 15
                } else {
                    binding.timepicker.currentHour = 20
                    binding.timepicker.currentMinute = 15
                }
            }
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        // Cria um calendário e atribui a data selecionada
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        // Converte a data selecionada para o formato imposto pelo SimpleDateFormat
        val date = mSimpleDateFormat.format(calendar.time)
        binding.buttonDate.text = date
    }

    override fun onTimeChanged(view: TimePicker?, hourOfDay: Int, minute: Int) {
        toast("$hourOfDay:$minute")
    }

    /**
     * Facilita uso da Toast notification
     */
    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}