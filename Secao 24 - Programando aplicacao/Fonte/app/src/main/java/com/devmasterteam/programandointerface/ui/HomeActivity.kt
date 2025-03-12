package com.devmasterteam.programandointerface.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devmasterteam.programandointerface.R
import com.devmasterteam.programandointerface.constants.AppConstants
import com.devmasterteam.programandointerface.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getUserInformation()
    }

    /**
     * Busca informação recebida pela Intent
     */
    private fun getUserInformation() {
        intent.extras?.let {
            binding.textEmail.text = it.getString(AppConstants.EMAIL_KEY)
        }

        /*
        // Outra maneira de escrever a lógica
        val bundle = intent.extras
        if (bundle != null) {
            binding.textEmail.text = bundle.getString(AppConstants.EMAIL_KEY)
        }
        * */
    }
}