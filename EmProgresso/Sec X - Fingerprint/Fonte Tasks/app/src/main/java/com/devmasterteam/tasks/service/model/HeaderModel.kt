package com.devmasterteam.tasks.service.model

import com.google.gson.annotations.SerializedName

class HeaderModel {

    @SerializedName("token")
    lateinit var token: String

    @SerializedName("personKey")
    lateinit var personKey: String

    @SerializedName("name")
    lateinit var name: String

}