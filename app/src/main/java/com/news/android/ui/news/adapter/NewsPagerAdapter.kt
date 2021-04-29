package com.news.android.ui.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.news.android.databinding.MainBinding

/**
 * Created by Vicky Poojari on 28/4/21.
 */
class NewsPagerAdapter : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun getCount(): Int {
        return 10
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding : MainBinding = MainBinding.inflate(LayoutInflater.from(container.context), container, false)
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }


}