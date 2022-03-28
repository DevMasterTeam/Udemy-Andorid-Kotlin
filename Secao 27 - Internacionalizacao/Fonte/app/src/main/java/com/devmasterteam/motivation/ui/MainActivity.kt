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
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var securityPreferences: SecurityPreferences

    private var filter: Int = MotivationConstants.PHRASEFILTER.ALL
    private val mock: Mock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Remove a supportActionBar
        supportActionBar?.hide()

        // Inicializa variáveis
        securityPreferences = SecurityPreferences(this)

        // Adiciona eventos
        setListeners()

        // Inicializa
        handleFilter(R.id.image_all)
        refreshPhrase()
        showUserName()
    }

    /**
     * Trata eventos de click
     * */
    override fun onClick(view: View) {
        val id: Int = view.id

        val listId = listOf(
            R.id.image_all,
            R.id.image_happy,
            R.id.image_sunny
        )
        if (id in listId) {
            handleFilter(id)
        } else if (id == R.id.button_new_phrase) {
            refreshPhrase()
        }
    }

    /**
     * Atribui eventos aos elementos
     * */
    private fun setListeners() {
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    /**
     * Atualiza frase de motivação
     * */
    private fun refreshPhrase() {
        // Obtém a língua do dispositivo
        binding.textPhrase.text = mock.getPhrase(filter, Locale.getDefault().language)
    }

    /**
     * Busca o nome do usuário
     * */
    private fun showUserName() {
        val name = securityPreferences.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        val hello = getString(R.string.hello)
        binding.textUserName.text = "$hello, $name!"
    }

    /**
     * Trata o filtro aplicado para as frases
     * */
    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                filter = MotivationConstants.PHRASEFILTER.ALL
                binding.imageAll.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }
            R.id.image_happy -> {
                filter = MotivationConstants.PHRASEFILTER.HAPPY

                // Possível de trocar a fonte da imagem e atribuir ao elemento de layout
                // binding.imageHappy.setImageResource(R.drawable.ic_all)

                // Possível de trocar a cor do ícone
                binding.imageHappy.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }
            else -> {
                filter = MotivationConstants.PHRASEFILTER.SUNNY
                binding.imageSunny.setColorFilter(
                    ContextCompat.getColor(this, R.color.white)
                )
            }
        }

    }
}