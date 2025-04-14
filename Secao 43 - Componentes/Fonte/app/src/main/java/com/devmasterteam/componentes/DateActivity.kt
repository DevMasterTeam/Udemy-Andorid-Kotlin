package com.devmasterteam.componentes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devmasterteam.componentes.databinding.ActivityDateBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateActivity : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private val binding: ActivityDateBinding by lazy { ActivityDateBinding.inflate(layoutInflater) }

    private var brazilLocale = Locale("pt", "BR")
    private val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", brazilLocale)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonDate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_date -> {
                // Obtém a instância do calendário
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                // Mostra o Datepicker utilizando a data atual do dispositivo
                DatePickerDialog(this, this, year, month, day).show()
            }
        }
    }

    /**
     * DatePickerDialog - Resposta
     **/
    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        // Cria um calendário e atribui a data selecionada
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        // Converte a data selecionada para o formato imposto pelo SimpleDateFormat
        binding.textDatePicker.text = simpleDateFormat.format(calendar.time)
    }
}