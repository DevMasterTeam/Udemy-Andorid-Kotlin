package com.devmasterteam.mvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.devmasterteam.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Anteriormente, inicialização era feita da maneira abaixo, até surgir delegate
        // "delegate by lazy" é o conceito "delegar com incialização tardia"
        // Ou seja, esperar até o momento da variável ser usada para então alocar memória
        // val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Eventos
        binding.buttonLogin.setOnClickListener(this)

        // Observadores
        createObservers()
    }

    /**
     * Eventos de click
     * */
    override fun onClick(v: View?) {
        val name = binding.edittextName.text.toString()
        viewModel.doLogin(name)
    }

    /**
     * Inicializa os observadores
     * */
    private fun createObservers() {
        viewModel.welcome().observe(this) {
            binding.textviewWelcome.text = it
        }

        viewModel.login().observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}