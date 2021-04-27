package com.news.android

import android.content.Context
import com.news.android.ui.main.MainActivity

/**
 * Created by Vicky Poojari on 25/4/21.
 */

interface Launcher {

    fun home()

    fun with(context: Context) : Launcher
}