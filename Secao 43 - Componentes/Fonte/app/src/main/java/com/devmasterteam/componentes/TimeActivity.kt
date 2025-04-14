package com.devmasterteam.componentes

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devmasterteam.componentes.databinding.ActivityTimeBinding

class TimeActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private val binding: ActivityTimeBinding by lazy { ActivityTimeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonTimePicker.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_time_picker -> {
                TimePickerDialog(this, this, 17, 35, true).show()
            }
        }
    }

    /**
     * TimePickerDialog - Resposta
     **/
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        binding.textTimePicker.text = getString(R.string.time_format, hourOfDay, minute)
    }
}