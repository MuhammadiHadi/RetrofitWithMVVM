package com.example.retrofitwithmvvm.Model

data class User(
    val about: String,
    val created_at: String,
    val created_by: Int,
    val email: String,
    val id: Int,
    val image: String,
    val is_active: Int,
    val logo: String,
    val name: String,
    val role: Role,
    val role_id: Int,
    val roles: List<Role>,
    val updated_at: String,
    val username: String
)