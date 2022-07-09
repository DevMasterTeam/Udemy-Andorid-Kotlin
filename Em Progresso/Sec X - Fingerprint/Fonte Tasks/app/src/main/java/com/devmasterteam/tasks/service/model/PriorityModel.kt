package com.devmasterteam.tasks.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Priority")
class PriorityModel {

    @SerializedName("Id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int = 0

    @SerializedName("Description")
    @ColumnInfo(name = "description")
    var description: String = ""

}