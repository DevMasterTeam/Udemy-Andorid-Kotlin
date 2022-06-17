package com.devmasterteam.retrofit

import retrofit2.Call
import retrofit2.http.GET

/**
 * Service mapeia os endpoints, verbos e parâmetros passados
 * */
interface PostService {
    @GET("posts")
    fun list(): Call<List<PostModel>>
}