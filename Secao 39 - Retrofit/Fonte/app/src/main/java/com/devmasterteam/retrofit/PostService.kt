package com.devmasterteam.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * Service mapeia os endpoints, verbos e parâmetros passados
 * */
interface PostService {
    @GET("posts")
    fun listCall(): Call<List<PostEntity>>

    @GET("posts")
    suspend fun list(): Response<List<PostEntity>>
}