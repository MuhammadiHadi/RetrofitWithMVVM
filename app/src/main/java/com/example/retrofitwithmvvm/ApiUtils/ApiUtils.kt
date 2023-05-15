package com.example.retrofitwithmvvm.ApiUtils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {

     val baseUrl="https://propasolutions.co.uk"
    val fakeUrl="https://jsonplaceholder.typicode.com"
    val User="https://reqres.in"


     fun getPropertiesInstance():Retrofit{
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun userLogin():Retrofit{
      return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun userGet():Retrofit{
        return  Retrofit.Builder()
            .baseUrl(fakeUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun userget():Retrofit{
        return  Retrofit.Builder()
            .baseUrl(User)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}