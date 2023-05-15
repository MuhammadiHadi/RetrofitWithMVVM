package com.example.retrofitwithmvvm.Interface

import com.example.retrofitwithmvvm.Model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface PropertiesListInterface {

    @GET(value = "/api/properties")
    suspend fun getList(): Response<PropertiesList>


    @GET(value="/photos")
   suspend fun getUserList():Response<photoDataClass>
    @PUT("/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body name: NewUserModle): Call<NewUserModle>

    @GET(value="api/users/{id}")
     fun getUsersList():Response<NewUserModle>
}