package com.devmasterteam.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val remote = RetrofitClient.createService(PostService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call: Call<List<PostModel>> = remote.list()
        val lst = call.enqueue(object : Callback<List<PostModel>> {
            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val falha = t.message
            }

            override fun onResponse(
                call: Call<List<PostModel>>, response: Response<List<PostModel>>
            ) {
                val count = response.body()?.count()
            }

        })

    }
}