package com.news.android.ui.main

import android.content.Context
import android.os.Bundle
import com.news.android.R
import com.news.android.databinding.ActivityMainBinding
import com.news.android.ui.base.BaseActivity
import com.news.android.ui.base.BaseAdapter
import dagger.android.AndroidInjection
import org.androidannotations.annotations.AfterInject
import org.androidannotations.annotations.EActivity

@EActivity
open class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var list : ArrayList<String>

    //Companion object is used for accessing static functions
    companion object {
        fun start(context: Context) {
            MainActivity_.intent(context).start()
        }
    }

    @AfterInject
    override fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = ArrayList()
        list.add("Sadiq")
        list.add("Rehan")
        list.add("Sohail")
        mBinding.model = list
        mBinding.recyclerView.adapter = BaseAdapter(R.layout.item_news)
        mBinding.categoryRV.adapter = BaseAdapter(R.layout.item_categories)
    }
}