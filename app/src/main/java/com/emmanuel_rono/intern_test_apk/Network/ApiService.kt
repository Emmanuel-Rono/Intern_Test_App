package com.emmanuel_rono.intern_test_apk

import retrofit2.http.GET


interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
