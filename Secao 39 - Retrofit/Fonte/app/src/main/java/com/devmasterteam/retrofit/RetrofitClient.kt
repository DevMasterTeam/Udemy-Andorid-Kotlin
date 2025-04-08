package com.devmasterteam.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    companion object {

        // Instância privada - Implementação singleton
        private lateinit var retrofit: Retrofit

        // URL deve sempre terminar com "/" ou Retrofit acusa erro ao iniciar
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        // Retorna instância para conexão remota
        private fun getRetrofitInstance(): Retrofit {
            val httpClient = OkHttpClient.Builder()
            if (!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        // Retorna instância do serviço associado ao Retrofit
        fun <S> createService(serviceClass: Class<S>): S {
            return getRetrofitInstance().create(serviceClass)
        }
    }
}