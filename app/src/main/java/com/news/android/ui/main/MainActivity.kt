package com.news.android.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.news.android.R
import com.news.android.databinding.ActivityMainBinding
import com.news.android.ui.BaseActivity
import dagger.android.AndroidInjection
import org.androidannotations.annotations.AfterInject
import org.androidannotations.annotations.EActivity

@EActivity
open class MainActivity : BaseActivity<ActivityMainBinding>() {

    //Companion object is used for accessing static functions
    companion object {
        fun start(context: Context) {
            MainActivity_.intent(context).start()
        }
    }

   /* @AfterInject*/
    override fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}