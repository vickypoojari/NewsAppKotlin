package com.news.android.api

import okhttp3.ResponseBody

/**
 * Created by Vicky Poojari on 1/5/21.
 */
interface NewsApi {

    /**
     * Callback to get client details
     */
    suspend fun getClientDetails() : ResponseBody
}