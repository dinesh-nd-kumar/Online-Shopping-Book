package com.dineshdk.clickastro.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dineshdk.clickastro.models.ProductEntity
import com.dineshdk.clickastro.models.ApiResponse
import com.dineshdk.clickastro.others.toProductEntities
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopRepo {
    private var productLiveData = MutableLiveData<List<ProductEntity>>()
    var context:Context? = null

    suspend fun loadData(context: Context) {
        this.context = context
        productLiveData.postValue( getProductFromRoom())
        fetchProducts()
    }
    fun getData(): MutableLiveData<List<ProductEntity>> {
        return productLiveData
    }

     private suspend fun fetchProducts() {
        val call = Retrofit.api.getProducts()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    // Handle the successful response
                    val products = response.body()?.products
                    Log.d("MainActivity", "Products: $products")

                    productLiveData.postValue( response.body()?.toProductEntities())
                    GlobalScope.launch{
                    saveProductInRoom(response.body())

                    }



                    products?.forEach { (key, product) ->
                        Log.d("Product", "$key: ${product.name}, Price: ${product.price}")
                    }

                } else {
                    Log.e("MainActivity", "Failed: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("MainActivity", "Error: ${t.message}")
            }
        })
    }

    suspend fun saveProductInRoom(body: ApiResponse?) {

        DatabaseBuilder.run {
            getInstance(context!!).productDao().deleteAllProducts()
            getInstance(context!!).productDao().insertProducts(body?.toProductEntities()!!)
        }
    }
    private suspend fun getProductFromRoom():List<ProductEntity> {

        return DatabaseBuilder.run {
            getInstance(context!!).productDao().getAllProducts()
        }

    }

}