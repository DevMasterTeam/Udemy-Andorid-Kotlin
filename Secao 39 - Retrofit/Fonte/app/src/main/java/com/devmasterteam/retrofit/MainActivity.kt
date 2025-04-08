package com.devmasterteam.retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // PostService::class.java
    // PostService::class -> É a referência Kotlin para a classe PostService.
    // .java -> Realiza a conversão para o tipo `Class<PostService>`, que é o que o Retrofit espera.
    // Retrofit precisa de informações sobre a classe, não sobre uma instância dela.
    // PostService::class.java representa uma "planta" da classe — ou seja, diz ao Retrofit quais métodos e anotações ela possui,
    // permitindo que ele crie dinamicamente a implementação necessária da interface.
    private val remote = RetrofitClient.createService(PostService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        coroutines()
        callBacks()
    }

    /**
     * Chamad feita usando Coroutines
     * */
    private fun coroutines() {
        lifecycleScope.launch {
            val response = remote.list()
            if (response.isSuccessful) {
                val str = "size: ${response.body()?.size}"
            }
        }
    }

    /**
     * Chamada feita usando callbacks - Classes Retrofit
     * */
    private fun callBacks() {
        val call: Call<List<PostEntity>> = remote.listCall()
        call.enqueue(object : Callback<List<PostEntity>> {
            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                val fail = t.message
            }

            override fun onResponse(call: Call<List<PostEntity>>, rsp: Response<List<PostEntity>>) {
                val list = rsp.body()
            }
        })
    }
}