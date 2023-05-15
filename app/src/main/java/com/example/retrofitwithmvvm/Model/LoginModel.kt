package com.example.retrofitwithmvvm.Model

data class LoginModel(
    val current_timestamp: String,
    val `data`: DataX,
    val errors: List<Any>,
    val message: Any,
    val status: Any,
    val success: Boolean
)