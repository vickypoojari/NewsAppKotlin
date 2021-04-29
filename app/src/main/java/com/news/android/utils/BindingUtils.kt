package com.news.android.utils
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.news.android.ui.base.BaseAdapter

/**
 * Created by Vicky Poojari on 27/4/21.
 */
class BindingUtils {
    companion object {

        @BindingAdapter("adapter")
        @JvmStatic
        fun recyclerViewAdapter(recyclerView: RecyclerView, url : ArrayList<String>) {
            val adapter : BaseAdapter = recyclerView.adapter as BaseAdapter
            if(adapter != null) {
                recyclerView.adapter = adapter
            }
        }

    }
}