package com.devmasterteam.mybooks.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.devmasterteam.mybooks.R
import com.devmasterteam.mybooks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Barra superior
        supportActionBar?.hide()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura bottom navigation
        setupNavigation()
    }

    /**
     * Configura a navegação com o `BottomNavigationView` e a `ActionBar`.
     *
     * Este método realiza a configuração da navegação entre os diferentes fragmentos utilizando o `BottomNavigationView`.
     * Ele associa o `BottomNavigationView` ao controlador de navegação (`NavController`) e define a `AppBarConfiguration`
     * para que a `ActionBar` possa se comportar de acordo com a navegação.
     * Além disso, o método faz a configuração do `NavController` para que ele controle a navegação entre os fragmentos definidos,
     * como `navigation_home` e `navigation_favorite`.
     */
    private fun setupNavigation() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_favorite)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}