package com.example.makeupapi.data.network

import com.example.makeupapi.model.response.MakeupItem
import com.example.makeupapi.model.response.ProductColor
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Dashboardapi {
    @GET("api/v1/products.json?")
    suspend fun getdatafromApimakeup(@Query("brand") query: String): Response<List<MakeupItem>>

    @GET("api/v1/products.json?")
    suspend fun showAPImakeup(): Response<List<MakeupItem>>

    @GET("api/v1/products.json?")
    suspend fun showAPImakeups(): Response<List<ProductColor>>
}