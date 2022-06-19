package com.example.gramoday.modal

import com.example.gramoday.remote.Retrofit

object Repository {

    suspend fun getuser()=Retrofit.api.getProfile()


}