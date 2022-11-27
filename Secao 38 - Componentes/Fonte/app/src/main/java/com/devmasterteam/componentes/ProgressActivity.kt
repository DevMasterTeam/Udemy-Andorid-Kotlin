package com.devmasterteam.componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devmasterteam.componentes.databinding.ActivityProgressBinding

class ProgressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Atribuição via código
        binding.progressValue.progress = 55
    }
}