package com.devmasterteam.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.devmasterteam.motivation.R
import com.devmasterteam.motivation.databinding.ActivityMainBinding
import com.devmasterteam.motivation.infra.MotivationConstants
import com.devmasterteam.motivation.infra.SecurityPreferences
import com.devmasterteam.motivation.repository.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences

    private var filter: Int = MotivationConstants.PHRASEFILTER.ALL
    private val mMock: Mock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Remove a supportActionBar
        supportActionBar?.let {
            it.hide()
        }

        // Inicializa variáveis
        mSecurityPreferences = SecurityPreferences(this)

        // Adiciona eventos
        setListeners()

        // Inicializa
        handleFilter(R.id.imageAll)
        refreshPhrase()
        showUserName()
    }

    /**
     * Trata eventos de click
     * */
    override fun onClick(view: View) {
        val id: Int = view.id

        val listId = listOf(
            R.id.imageAll,
            R.id.imageHappy,
            R.id.imageMorning
        )
        if (id in listId) {
            handleFilter(id)
        } else if (id == R.id.buttonRefresh) {
            refreshPhrase()
        }
    }

    /**
     * Atribui eventos aos elementos
     * */
    private fun setListeners() {
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageMorning.setOnClickListener(this)
        binding.buttonRefresh.setOnClickListener(this)
    }

    /**
     * Atualiza frase de motivação
     * */
    private fun refreshPhrase() {
        binding.textPhrase.text = mMock.getPhrase(filter)
    }

    /**
     * Busca o nome do usuário
     * */
    private fun showUserName() {
        val name = mSecurityPreferences.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        binding.textUserName.text = "Olá, $name!"
    }

    /**
     * Trata o filtro aplicado para as frases
     * */
    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.imageAll -> {
                filter = MotivationConstants.PHRASEFILTER.ALL
                binding.imageAll.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }
            R.id.imageHappy -> {
                filter = MotivationConstants.PHRASEFILTER.HAPPY

                // Possível de trocar a fonte da imagem e atribuir ao elemento de layout
                // binding.imageHappy.setImageResource(R.drawable.ic_all)

                // Possível de trocar a cor do ícone
                binding.imageHappy.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }
            else -> {
                filter = MotivationConstants.PHRASEFILTER.MORNING
                binding.imageMorning.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }
        }

    }
}