package com.devmasterteam.tasks.service.repository.remote

import com.devmasterteam.tasks.service.model.TaskModel
import retrofit2.Call
import retrofit2.http.*

interface TaskService {

    @GET("Task")
    fun all(): Call<List<TaskModel>>

    @GET("Task/Overdue")
    fun expired(): Call<List<TaskModel>>

    @GET("Task/Next7Days")
    fun nextWeek(): Call<List<TaskModel>>

    @GET("Task/{id}")
    fun load(@Path(value = "id", encoded = true) id: Int): Call<TaskModel>

    @HTTP(method = "PUT", path = "Task/Complete", hasBody = true)
    @FormUrlEncoded
    fun complete(@Field("id") id: Int): Call<Boolean>

    @HTTP(method = "PUT", path = "Task/Uncomplete", hasBody = true)
    @FormUrlEncoded
    fun undo(@Field("id") id: Int): Call<Boolean>

    @HTTP(method = "DELETE", path = "Task", hasBody = true)
    @FormUrlEncoded
    fun delete(@Field("id") id: Int): Call<Boolean>

    @POST("Task")
    @FormUrlEncoded
    fun create(
        @Field("PriorityId") priorityId: Int,
        @Field("Description") description: String,
        @Field("DueDate") dueDate: String,
        @Field("Complete") complete: Boolean
    ): Call<Boolean>

    @HTTP(method = "PUT", path = "Task", hasBody = true)
    @FormUrlEncoded
    fun update(
        @Field("Id") Id: Int,
        @Field("PriorityId") priorityId: Int,
        @Field("Description") description: String,
        @Field("DueDate") dueDate: String,
        @Field("Complete") complete: Boolean
    ): Call<Boolean>

}