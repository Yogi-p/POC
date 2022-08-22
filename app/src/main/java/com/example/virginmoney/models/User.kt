package com.example.virginmoney.models

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id") var id : String? = null,
    @SerializedName("createdAt") var createdAt : String? = null,
    @SerializedName("firstName") var firstName : String? = null,
    @SerializedName("avatar") var avatar : String? = null,
    @SerializedName("lastName") var lastName : String? = null,
    @SerializedName("email") var email : String? = null,
    @SerializedName("jobtitle") var jobtitle : String? = null,
    @SerializedName("favouriteColor") var favouriteColor : String? = null
){
    companion object{
        val empty = User("", "","","","","","","")
    }
}
