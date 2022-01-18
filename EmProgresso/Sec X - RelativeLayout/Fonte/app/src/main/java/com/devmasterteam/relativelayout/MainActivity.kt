package com.devmasterteam.relativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Sem lógica, somente layout
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}