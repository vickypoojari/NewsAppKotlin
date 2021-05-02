package com.news.android.ui.base

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.android.databinding.ItemNewsBinding
import java.util.ArrayList

/**
 * Created by Vicky Poojari on 27/4/21.
 */
 class BaseAdapter(private val layoutId : Int) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItem(url: ArrayList<String>) {
        Log.e(TAG, "addItem: $url")
    }

    class ViewHolder(binding: View) : BaseViewHolder(binding) {

        override fun onBind(position: Int) {
            Log.e("TAG", "onBind: ")
        }

    }

}