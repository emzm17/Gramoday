package com.example.gramoday.remote

import com.example.gramoday.utils.Constant.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    private val retrofit=Retrofit.Builder()
        .baseUrl(API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api= retrofit.create(Services::class.java)

}