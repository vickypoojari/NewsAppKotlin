package com.news.android.ui.splash

import android.os.Bundle
import com.news.android.Launcher
import com.news.android.R
import com.news.android.databinding.ActivitySplashBinding
import com.news.android.ui.base.BaseActivity
import com.news.android.ui.main.MainViewModel
import dagger.android.AndroidInjection
import org.androidannotations.annotations.AfterInject
import org.androidannotations.annotations.EActivity
import javax.inject.Inject

@EActivity
open class SplashActivity : BaseActivity<ActivitySplashBinding, MainViewModel>() {

    @Inject lateinit var launcher : Launcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launcher.with(this).home()
        finish()
    }

    @AfterInject
    override fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }
}