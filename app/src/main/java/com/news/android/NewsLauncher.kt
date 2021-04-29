package com.news.android

import android.content.Context
import com.news.android.Launcher
import com.news.android.ui.main.MainActivity
import com.news.android.ui.news.NewsActivity

/**
 * Created by Vicky Poojari on 25/4/21.
 */

class NewsLauncher : Launcher {

    private lateinit var context : Context

    override fun home() {
        NewsActivity.start(context)
    }

    override fun with(context: Context): Launcher {
        this.context = context
        return this
    }
}
