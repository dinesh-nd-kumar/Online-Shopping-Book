package com.dineshdk.clickastro.repo

import com.dineshdk.clickastro.models.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductApis {
    @GET("test/products.php")
    fun getProducts(): Call<ApiResponse>
}