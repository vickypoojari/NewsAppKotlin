package com.news.android.di.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.news.android.di.scope.ViewModelKey
import com.news.android.ui.main.MainViewModel
import com.news.android.utils.NewsViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CommonViewModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    fun bindViewModelFactory(factory: NewsViewModelFactory): ViewModelProvider.Factory
}