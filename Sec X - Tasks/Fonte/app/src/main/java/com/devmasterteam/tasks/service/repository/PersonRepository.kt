package com.devmasterteam.tasks.service.repository

import android.content.Context
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.model.HeaderModel
import com.devmasterteam.tasks.service.repository.remote.PersonService
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(context: Context) : BaseRepository(context) {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    fun login(email: String, password: String, listener: APIListener<HeaderModel>) {

        // Verificação de internet
        if (!isConnectionAvailable(mContext)) {
            listener.onFailure(mContext.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        val call: Call<HeaderModel> = mRemote.login(email, password)
        call.enqueue(object : Callback<HeaderModel> {
            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFailure(mContext.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                val code = response.code()
                if (fail(code)) {
                    listener.onFailure(failRespose(response.errorBody()!!.string()))
                } else {
                    response.body()?.let { listener.onSuccess(it, response.code()) }
                }
            }
        })
    }

    fun create(name: String, email: String, password: String, listener: APIListener<HeaderModel>) {

        // Verificação de internet
        if (!isConnectionAvailable(mContext)) {
            listener.onFailure(mContext.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }

        val call: Call<HeaderModel> = mRemote.create(name, email, password)
        call.enqueue(object : Callback<HeaderModel> {
            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFailure(mContext.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                val code = response.code()
                if (fail(code)) {
                    listener.onFailure(failRespose(response.errorBody()!!.string()))
                } else {
                    response.body()?.let { listener.onSuccess(it, response.code()) }
                }
            }
        })
    }

}