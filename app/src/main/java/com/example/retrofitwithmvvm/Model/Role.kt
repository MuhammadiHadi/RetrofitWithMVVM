package com.example.retrofitwithmvvm.Model

data class Role(
    val created_at: Any,
    val created_by: Any,
    val guard_name: String,
    val id: Int,
    val name: String,
    val pivot: Pivot,
    val slug: String,
    val updated_at: Any
)