package com.news.android.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.news.android.api.NewsApi
import javax.inject.Inject

/**
 * Created by Vicky Poojari on 26/4/21.
 */

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : AppCompatActivity() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    @Inject lateinit var viewModel: V

    protected lateinit var mBinding : T

    /**
     * Initialize and inject your graph. If needed
     */
    protected abstract fun performDependencyInjection()

    /**
     * Get activity layout resource id which will be inflated as activity view
     * @return layout resource id
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performBinding()
    }

    private fun performBinding() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

}