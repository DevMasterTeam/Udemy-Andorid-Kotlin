package com.devmasterteam.retrofit

import com.google.gson.annotations.SerializedName

/**
 * Classe de modelo - Mapeia o retorno do JSON para instância da classe.
 * GSON é a biblioteca responsável pela conversão.
 */
class PostModel {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""

}