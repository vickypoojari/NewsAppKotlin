package com.news.android.ui.news

import android.content.Context
import android.os.Bundle
import com.news.android.R
import com.news.android.databinding.ActivityNewsBinding
import com.news.android.ui.base.BaseActivity
import com.news.android.ui.news.adapter.NewsPagerAdapter
import dagger.android.AndroidInjection
import org.androidannotations.annotations.AfterInject
import org.androidannotations.annotations.EActivity

/**
 * Created by Vicky Poojari on 28/4/21.
 */

@EActivity
open class NewsActivity : BaseActivity<ActivityNewsBinding>() {

    companion object {
        fun start(context : Context) {
            NewsActivity_.intent(context).start()
        }
    }

    @AfterInject
    override fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_news
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.viewPager.adapter = NewsPagerAdapter()
    }

}