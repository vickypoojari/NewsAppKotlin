package com.news.android.di.component;

import android.app.Application
import com.news.android.NewsApp
import com.news.android.di.module.AppModule
import com.news.android.di.common.CommonActivityModule
import com.news.android.di.module.DataModule
import com.news.android.di.module.ApiModule
import com.news.android.di.scope.AppScope
import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Vicky Poojari on 29/3/21.
 */
@AppScope
@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        ApiModule::class,
        CommonActivityModule::class
    ]
)
interface AppComponent {

    fun inject(newsApp: NewsApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app : Application) : Builder

        fun build() : AppComponent
    }
}
