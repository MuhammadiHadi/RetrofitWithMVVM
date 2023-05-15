package com.example.retrofitwithmvvm.Interface

import com.example.retrofitwithmvvm.Model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface loginInterface {


    @POST(value = "/api/login")
     fun login(@Body request:LoginUer): Call<LoginModel>


}