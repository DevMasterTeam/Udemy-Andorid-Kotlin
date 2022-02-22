package com.devmasterteam.tasks.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.*
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.databinding.ActivityMainBinding
import com.devmasterteam.tasks.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.appBarMain.fab.setOnClickListener {
            startActivity(Intent(this, TaskFormActivity::class.java))
        }

        // Navegação
        setupNavigation()

        // Observadores
        observe()
    }

    override fun onResume() {
        mViewModel.loadUserName()
        super.onResume()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setupNavigation() {
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_all_tasks, R.id.nav_next_tasks, R.id.nav_expired), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Escuta ação de click para logout
        navView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.nav_logout) {
                mViewModel.logout()
            } else {
                NavigationUI.onNavDestinationSelected(it, navController);
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            true
        }
    }

    private fun observe() {
        mViewModel.logout.observe(this, Observer {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        })

        mViewModel.userName.observe(this, Observer {
            val navView = findViewById<NavigationView>(R.id.nav_view)
            val header = navView.getHeaderView(0)

            header.findViewById<TextView>(R.id.text_name).text = it
        })
    }
}