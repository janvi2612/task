package com.example.exoplayerdemo.repository

import com.example.exoplayerdemo.model.Category
import com.example.exoplayerdemo.api.ApiService
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api : ApiService
) {

    suspend fun getVideo():Response<Category>{
        return api.getVideo()
    }

}