package com.example.retrofitwithmvvm.Model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val success: Boolean,
    @SerializedName("token") val token: String,
    @SerializedName("user") val user: User
)

