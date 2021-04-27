package com.news.android.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.news.android.Launcher
import com.news.android.R
import com.news.android.databinding.ActivitySplashBinding
import com.news.android.ui.BaseActivity
import com.news.android.ui.main.MainActivity
import com.news.android.ui.main.MainActivity_
import dagger.android.AndroidInjection
import org.androidannotations.annotations.AfterInject
import org.androidannotations.annotations.EActivity
import javax.inject.Inject

@EActivity
open class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    @Inject lateinit var launcher : Launcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding.main.setOnClickListener { launcher.with(this).home() }

    }

    @AfterInject
    override fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }
}