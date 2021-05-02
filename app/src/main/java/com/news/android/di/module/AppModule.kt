package com.news.android.di.module;

import android.app.Application
import android.content.res.Resources
import com.news.android.NewsLauncher
import com.news.android.Launcher
import com.news.android.NewsApp
import com.news.android.di.common.CommonViewModule
import com.news.android.di.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by Vicky Poojari on 29/3/21.
 */

@Module(includes = [CommonViewModule::class])
class AppModule {

    @AppScope
    @Provides
    fun providesApplication(app: NewsApp) : Application {
        return app
    }

    @AppScope
    @Provides
    fun providesResources(app : Application) : Resources {
        return app.resources
    }

    @AppScope
    @Provides
    fun providesLauncher() : Launcher {
        return NewsLauncher()
    }

}
