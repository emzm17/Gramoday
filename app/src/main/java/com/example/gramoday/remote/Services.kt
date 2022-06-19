package com.example.gramoday.remote

import androidx.lifecycle.LiveData
import com.example.gramoday.modal.Product
import com.example.gramoday.modal.Profile
import retrofit2.Response
import retrofit2.http.GET

interface Services {

    @GET("v1/user/bySlug?profileSlug=mmtradingco")
    suspend fun getProfile():Response<Profile>


}