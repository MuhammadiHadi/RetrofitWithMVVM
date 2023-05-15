package com.example.retrofitwithmvvm.Model

data class PropertiesList(
    val current_timestamp: String,
    val data: ArrayList<Data>,
    val errors: List<Any>,
    val message: Any,
    val status: Any,
    val success: Boolean
)