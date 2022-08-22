package com.example.virginmoney.models

import com.google.gson.annotations.SerializedName

data class Rooms (
    @SerializedName("id") val id: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("isOccupied") val isOccupied: Boolean,
    @SerializedName("maxOccupancy") val maxOccupancy: Long
) {
    companion object{
        val empty = Rooms("", "",false,0)
    }
}