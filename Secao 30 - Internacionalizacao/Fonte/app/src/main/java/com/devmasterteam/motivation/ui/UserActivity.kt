package com.devmasterteam.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devmasterteam.motivation.R
import com.devmasterteam.motivation.databinding.ActivityUserBinding
import com.devmasterteam.motivation.helper.MotivationConstants
import com.devmasterteam.motivation.repository.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa variáveis da classe
        securityPreferences = SecurityPreferences(this)

        // Acesso aos elementos de interface)
        binding.buttonSave.setOnClickListener(this)
        verifyUserName()
    }

    /**
     * Lida com os eventos de click
     * */
    override fun onClick(view: View) {
        val id: Int = view.id
        if (id == R.id.button_save) {
            handleSave()
        }
    }

    /**
     * Verifica se usuário já preencheu o nome
     * */
    private fun verifyUserName() {
        val name = securityPreferences.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        if (name.isNotEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    /**
     * Salva o nome do usuário para utilizações futuras
     * */
    private fun handleSave() {

        // Obtém o nome
        val name: String = binding.editName.text.toString()

        // Verifica se usuário preencheu o nome
        if (name.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_mandatory_name), Toast.LENGTH_LONG).show()
        } else {
            // Salva os dados do usuário e redireciona para as frases
            securityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))

            // Impede que seja possível voltar a Activity
            finish()
        }
    }
}