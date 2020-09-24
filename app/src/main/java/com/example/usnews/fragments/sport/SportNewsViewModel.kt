package com.example.usnews.fragments.sport

import com.example.usnews.R
import com.example.usnews.base.BaseFragmentViewModel
import com.example.usnews.repositories.NewsRepository
import com.example.usnews.utils.BaseScheduler
import com.example.usnews.utils.StringProvider
import javax.inject.Inject

class SportNewsViewModel @Inject constructor(private val baseScheduler: BaseScheduler,
                                             private val newsRepository: NewsRepository,
                                             private val stringProvider: StringProvider
) : BaseFragmentViewModel() {

    fun loadData() {
        val disposable = newsRepository.getSpecified(stringProvider.provideString(R.string.sport))
            .subscribeOn(baseScheduler.io())
            .observeOn(baseScheduler.main())
            .subscribe({handleResults(it)}, {error -> println(error.message)})
        compositeDisposable?.add(disposable)
    }
}