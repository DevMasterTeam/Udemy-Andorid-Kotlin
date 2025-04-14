package com.devmasterteam.fingerprint

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (BiometricHelper.isBiometricAvailable(this)) {

            // Executor - Funciona como um thread para a autenticação
            val executor: Executor = ContextCompat.getMainExecutor(this)

            // BiometricPrompt
            val biometricPrompt = BiometricPrompt(this, executor,
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        // Lógica de acordo com a aplicação
                        super.onAuthenticationSucceeded(result)
                    }

                    override fun onAuthenticationFailed() {
                        // Lógica de acordo com a aplicação
                        super.onAuthenticationFailed()
                    }

                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        // Lógica de acordo com a aplicação
                        super.onAuthenticationError(errorCode, errString)
                    }
                })

            // Informações apresentadas no momento da autenticação
            val info: BiometricPrompt.PromptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Titulo")
                .setSubtitle("Subtítulo")
                .setDescription("Descrição")
                .setNegativeButtonText("Cancelar")
                .build()

            // Exibe para o usuário
            biometricPrompt.authenticate(info)
        }
    }
}