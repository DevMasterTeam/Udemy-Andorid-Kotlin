package com.devmasterteam.fingerprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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