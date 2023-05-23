package com.emmanuel_rono.intern_test_apkgit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
//Building Retrofit Instance
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //using Lazy to ensure that is called once
    val postApiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
