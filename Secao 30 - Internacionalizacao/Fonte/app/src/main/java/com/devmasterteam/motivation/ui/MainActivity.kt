package com.devmasterteam.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devmasterteam.motivation.R
import com.devmasterteam.motivation.databinding.ActivityMainBinding
import com.devmasterteam.motivation.helper.MotivationConstants
import com.devmasterteam.motivation.repository.PhraseRepository
import com.devmasterteam.motivation.repository.SecurityPreferences
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var securityPreferences: SecurityPreferences

    private var filter: Int = MotivationConstants.PHRASEFILTER.ALL
    private val phraseRepository = PhraseRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa variáveis
        securityPreferences = SecurityPreferences(this)

        // Adiciona eventos
        setListeners()

        // Mostra o nome do usuário
        showUserName()

        // Inicializa
        handleFilter(R.id.image_all)
        refreshPhrase()
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
        binding.textPhrase.text = phraseRepository.getPhrase(filter, Locale.getDefault().language)

        /*
        // Variações que podem ser feitas para obtenção da localização do dispotivo
        Locale.getDefault().language // en
        Locale.getDefault().isO3Language // eng
        Locale.getDefault().country // US
        Locale.getDefault().isO3Country // USA
        Locale.getDefault().displayCountry // United States
        Locale.getDefault().displayName // English (United States)
        Locale.getDefault() // en_US
        Locale.getDefault().displayLanguage // English
        Locale.getDefault().toLanguageTag() // en-US
        */
    }

    /**
     * Busca o nome do usuário
     * */
    private fun showUserName() {
        val name = securityPreferences.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        binding.textUserName.text = getString(R.string.label_greeting_user, name)
    }

    /**
     * Trata o filtro aplicado para as frases
     * */
    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        // Outra maneira de obter o resultado das três linhas acima
        /*listOf(binding.imageAll, binding.imageHappy, binding.imageSunny).forEach {
            it.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        }*/

        when (id) {
            R.id.image_all -> {
                filter = MotivationConstants.PHRASEFILTER.ALL
                highlightFilter(binding.imageAll)
            }

            R.id.image_happy -> {
                filter = MotivationConstants.PHRASEFILTER.HAPPY
                highlightFilter(binding.imageHappy)

                // Possível de trocar a fonte da imagem e atribuir ao elemento de layout
                // binding.imageHappy.setImageResource(R.drawable.ic_all)
            }

            else -> {
                filter = MotivationConstants.PHRASEFILTER.SUNNY
                highlightFilter(binding.imageSunny)
            }
        }
    }

    /**
     * Highlights the selected filter button.
     */
    private fun highlightFilter(view: ImageView) {
        view.setColorFilter(ContextCompat.getColor(this, R.color.white))
    }
}