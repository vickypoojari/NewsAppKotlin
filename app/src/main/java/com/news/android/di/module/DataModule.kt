package com.news.android.di.module

import android.app.Application
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.TIMEOUT
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.news.android.BuildConfig
import com.news.android.di.scope.AppScope
import com.news.android.utils.RxSingleSchedulers
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.androidannotations.annotations.App
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Vicky Poojari on 28/4/21.
 */

@Module
class DataModule {

   companion object {
       private val DISK_CACHE_SIZE = 50 * 1024 * 1024 // 50MB
       private val TIMEOUT = 30
   }

    private fun createOkHttpClient(app: Application): OkHttpClient? {
        val cacheDir = File(app.cacheDir, "http")
        val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())
        val client = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            .cache(cache)
            .build()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            client.newBuilder().addInterceptor(httpLoggingInterceptor)
        }
        return client
    }

    @AppScope
    @Provides
    fun providesOkHttpClient(app: Application) : OkHttpClient? {
        return createOkHttpClient(app)
    }

    @AppScope
    @Provides
    fun providesGson() : Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @AppScope
    @Provides
    fun providesScheduler() : RxSingleSchedulers {
        return RxSingleSchedulers.DEFAULT
    }

}