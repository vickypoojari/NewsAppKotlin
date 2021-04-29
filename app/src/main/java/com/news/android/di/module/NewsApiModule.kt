package com.news.android.di.module

import com.news.android.di.scope.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Vicky Poojari on 28/4/21.
 */

@Module
class NewsApiModule {

    @Provides
    @AppScope
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}