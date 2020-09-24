package com.example.usnews.fragments.business

import com.example.usnews.R
import com.example.usnews.base.BaseFragmentViewModel
import com.example.usnews.repositories.NewsRepository
import com.example.usnews.utils.BaseScheduler
import com.example.usnews.utils.StringProvider
import javax.inject.Inject

class BusinessNewsViewModel @Inject constructor(private val baseScheduler: BaseScheduler,
                                                private val newsRepository: NewsRepository,
                                                private val stringProvider: StringProvider
) : BaseFragmentViewModel() {

    fun loadData() {
        val disposable = newsRepository.getSpecified(stringProvider.provideString(R.string.business))
            .subscribeOn(baseScheduler.io())
            .observeOn(baseScheduler.main())
            .subscribe({handleResults(it)}, {error -> println(error.message)})
        compositeDisposable?.add(disposable)
    }
}