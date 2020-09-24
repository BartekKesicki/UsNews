package com.example.usnews.base

import androidx.lifecycle.MutableLiveData
import com.example.usnews.room.model.News
import javax.inject.Inject

open class BaseFragmentViewModel @Inject constructor(): BaseViewModel() {

    var newsLiveData = MutableLiveData<ArrayList<News>>()
    var newsArrayList = ArrayList<News>()

    init {
        newsLiveData.value = newsArrayList
    }

    protected fun handleResults(news: List<News>) {
        newsLiveData.value = ArrayList(news)
    }
}