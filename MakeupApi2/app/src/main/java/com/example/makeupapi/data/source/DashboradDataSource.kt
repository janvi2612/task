package com.example.makeupapi.data.source

import com.example.makeupapi.data.network.Dashboardapi
import com.example.makeupapi.model.response.MakeupItem
import com.example.makeupapi.model.response.ProductColor
import retrofit2.Response
import javax.inject.Inject

class DashboradDataSource  @Inject constructor(
    private val api : Dashboardapi
)
{
    suspend fun getdatafromApimakeup(query: String): Response<List<MakeupItem>> {
        return api.getdatafromApimakeup(query)
    }

    suspend fun showAPImakeup(): Response<List<MakeupItem>> {
        return api.showAPImakeup()
    }

    suspend fun showAPImakeups(): Response<List<ProductColor>> {
        return api.showAPImakeups()
    }


}