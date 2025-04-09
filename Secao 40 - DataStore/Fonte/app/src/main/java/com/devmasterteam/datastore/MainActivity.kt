package com.devmasterteam.datastore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.devmasterteam.datastore.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Uso da classe que gerencia o DataStore.
        val preferencesManager = PreferencesManager(this)

        lifecycleScope.launch {
            binding.textOne.text = "Inicializando Data Store."
            delay(2500)
            preferencesManager.save("Key", "valor armazenado / recuperado")
            binding.textOne.text = preferencesManager.read("Key")
            delay(2500)
            preferencesManager.remove("Key")
            binding.textOne.text = "Valor removido."
        }
    }
}