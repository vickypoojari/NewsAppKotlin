package com.news.android.di.module

import com.news.android.api.NewsApi
import com.news.android.api.NewsApiClient
import com.news.android.api.NewsApiRetrofit
import com.news.android.di.scope.AppScope
import com.news.android.utils.RxSingleSchedulers
import dagger.Module
import dagger.Provides
import org.androidannotations.annotations.App
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Vicky Poojari on 28/4/21.
 */

@Module
class ApiModule {

    @Provides
    @AppScope
    fun provideNewsApiClient(api : NewsApiRetrofit, schedulers : RxSingleSchedulers) : NewsApi {
        return NewsApiClient(api, schedulers)
    }

    @Provides
    @AppScope
    fun providesNewsRetrofitApi(retrofit: Retrofit) : NewsApiRetrofit {
        return retrofit.create(NewsApiRetrofit::class.java)
    }


    @Provides
    @AppScope
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/vickypoojari/media/main/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}