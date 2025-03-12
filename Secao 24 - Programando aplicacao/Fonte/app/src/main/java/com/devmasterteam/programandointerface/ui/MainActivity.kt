package com.devmasterteam.programandointerface.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devmasterteam.programandointerface.R
import com.devmasterteam.programandointerface.business.UserBusiness
import com.devmasterteam.programandointerface.constants.AppConstants
import com.devmasterteam.programandointerface.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val userBusiness = UserBusiness()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Diferente maneira de responder ao click
        // binding.buttonLogin.setOnClickListener { /*Implementação*/ }

        // Eventos
        setEvents()
    }

    override fun onClick(v: View) {

        // Responde ao click
        if (v.id == R.id.button_login) {
            val email = binding.edittextEmail.text.toString()
            val password = binding.edittextPassword.text.toString()

            // Login com sucesso
            if (userBusiness.checkCredentials(email, password)) {
                // Cria a informação no Bundle
                val bundle = Bundle()
                bundle.putString(AppConstants.EMAIL_KEY, email)

                // Redireciona para tela Home
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(this, R.string.error_preencha_os_dados, Toast.LENGTH_SHORT).show();
            }
        } else if (v.id == R.id.button_register) {
        }
    }

    /**
     * Eventos dos elementos de interface
     * */
    private fun setEvents() {
        binding.buttonLogin.setOnClickListener(this)
    }


}