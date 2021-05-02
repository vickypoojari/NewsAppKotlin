package com.news.android.api

import com.news.android.utils.RxSingleSchedulers
import io.reactivex.SingleTransformer
import okhttp3.ResponseBody

/**
 * Created by Vicky Poojari on 1/5/21.
 */

class NewsApiClient
    constructor(private val api: NewsApiRetrofit, private val schedulers : RxSingleSchedulers) : NewsApi, RxSingleSchedulers {

    override suspend fun getClientDetails(): ResponseBody {
        return api.getClientDetails()
    }

    override fun <T> applySchedulers(): SingleTransformer<T, T> {
        return schedulers.applySchedulers()
    }
}