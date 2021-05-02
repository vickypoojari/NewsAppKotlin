package com.news.android.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Vicky Poojari on 1/5/21.
 */
interface NewsApiRetrofit {

    @GET("clients.json")
    suspend fun getClientDetails() : ResponseBody

}