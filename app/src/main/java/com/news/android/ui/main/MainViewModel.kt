package com.news.android.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.android.api.NewsApi
import com.news.android.utils.Resource
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import java.lang.Exception
import javax.inject.Inject

class MainViewModel
@Inject constructor(private val api: NewsApi) : ViewModel() {

    private val clients = MutableLiveData<Resource<ResponseBody>>()

    fun fetchClients() {
        clients.postValue(Resource.loading(null))
        viewModelScope.launch {
            try {
                val post = api.getClientDetails()
                clients.postValue(Resource.success(post))
            } catch (e : Exception) {
                clients.postValue(Resource.error(e.message,null))
            }
        }

    }

    fun getUsers(): LiveData<Resource<ResponseBody>> {
        return clients
    }
}