package com.example.usnews.fragments.all

import com.example.usnews.base.BaseFragmentViewModel
import com.example.usnews.repositories.NewsRepository
import com.example.usnews.utils.BaseScheduler
import javax.inject.Inject


class AllNewsViewModel @Inject constructor(private val baseScheduler: BaseScheduler, private val newsRepository: NewsRepository) : BaseFragmentViewModel() {

    fun loadData() {
        val disposable = newsRepository.getAll()
            .subscribeOn(baseScheduler.io())
            .observeOn(baseScheduler.main())
            .subscribe({ handleResults(it) }, { error -> println(error.message)})
        compositeDisposable?.add(disposable)
    }
}