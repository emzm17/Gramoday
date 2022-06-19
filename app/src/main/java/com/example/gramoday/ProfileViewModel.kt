package com.example.gramoday

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gramoday.modal.Post
import com.example.gramoday.modal.Profile
import com.example.gramoday.modal.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProfileViewModel(): ViewModel() {
   val user=MutableLiveData<Profile>()


    fun getProfile()
    {
           viewModelScope.launch {
               val response = withContext(Dispatchers.IO) { Repository.getuser() }
               if (response.isSuccessful) {
                   user.postValue(response.body())
                  Log.i("ViewModel",response.message())
               }
               else{
                   Log.i("ViewModel",response.errorBody().toString())
               }
           }

      }
}