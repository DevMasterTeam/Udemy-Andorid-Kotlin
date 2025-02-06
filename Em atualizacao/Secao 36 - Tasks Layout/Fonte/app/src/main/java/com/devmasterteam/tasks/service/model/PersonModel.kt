package com.devmasterteam.tasks.service.model

import com.google.gson.annotations.SerializedName

class PersonModel {

    @SerializedName("token")
    lateinit var token: String

    @SerializedName("personKey")
    lateinit var personKey: String

    @SerializedName("name")
    lateinit var name: String

}