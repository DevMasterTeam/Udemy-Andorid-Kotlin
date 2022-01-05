package com.devmasterteam.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devmasterteam.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Variáveis
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Eventos
        binding.buttonLogin.setOnClickListener(this)

        // Observadores
        createObservers()
    }

    override fun onClick(v: View?) {
        val name = binding.editName.text.toString()
        mViewModel.doLogin(name)
    }

    private fun createObservers() {
        mViewModel.welcome().observe(this, Observer {
            binding.textWelcome.text = it
        })
        mViewModel.login().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}