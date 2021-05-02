package com.news.android.di.common;

import com.news.android.di.scope.AppScope;
import com.news.android.ui.main.MainActivity;
import com.news.android.ui.main.MainActivity_
import com.news.android.ui.news.NewsActivity_
import com.news.android.ui.splash.SplashActivity
import com.news.android.ui.splash.SplashActivity_

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Vicky Poojari on 26/4/21.
 */

@Module
abstract class CommonActivityModule {

    @ContributesAndroidInjector
    abstract fun contributesSplashActivity() : SplashActivity_

    @ContributesAndroidInjector
    abstract fun contributesMainActivity() : MainActivity_

    @ContributesAndroidInjector
    abstract fun contributesNewsActivity() : NewsActivity_
}
