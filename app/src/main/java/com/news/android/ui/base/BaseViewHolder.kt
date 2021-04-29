package com.news.android.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

/**
 * Created by Vicky Poojari on 27/4/21.
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)

}