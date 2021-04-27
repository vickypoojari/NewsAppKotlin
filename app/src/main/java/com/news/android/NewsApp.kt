package com.news.android

import android.app.Activity
import android.app.Application
import com.news.android.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import java.util.*
import javax.inject.Inject

/**
 * Created by Vicky Poojari on 25/4/21.
 *
 * This class is generally used as a launcher to start any activity
 * by just injecting Launcher interface
 */
class NewsApp : Application(), HasActivityInjector {

    @Inject lateinit var hasActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this)
            .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return hasActivityInjector
    }

}