package com.devmasterteam.retrofit

import com.google.gson.annotations.SerializedName

/**
 * Classe de modelo - Mapeia o retorno do JSON para instância da classe.
 * GSON é a biblioteca responsável pela conversão.
 */
data class PostEntity(

    @SerializedName("id")
    val id: Int,

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String

)