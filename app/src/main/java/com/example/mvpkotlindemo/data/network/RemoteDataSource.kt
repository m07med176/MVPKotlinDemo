package com.example.mvpkotlindemo.data.network

import com.example.mvpkotlindemo.data.model.ProductsResponse
import retrofit2.*

class RemoteDataSource:RemoteInterface {
    val retrofit:Retrofit = RetrofiteBulider.retrofitInstance
    val apiCall = retrofit.create<ApiCall>(ApiCall::class.java)
    override fun getProudects(networkCallBack: NetworkCallBack) {
        apiCall.getProudects().enqueue(object :Callback<ProductsResponse>{
            override fun onResponse(
                call: Call<ProductsResponse>,
                response: Response<ProductsResponse>
            ) {
                if (response.isSuccessful){
                    networkCallBack.onSuccessResult(response.body()?.products?: emptyList())
                }
            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
               networkCallBack.onFailureResult(t.message.toString())
            }
        })
    }
}