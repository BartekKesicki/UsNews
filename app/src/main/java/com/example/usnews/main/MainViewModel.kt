package com.example.usnews.main

import com.example.usnews.R
import com.example.usnews.base.BaseViewModel
import com.example.usnews.data.model.NewsModelResponse
import com.example.usnews.enums.NewsType
import com.example.usnews.repositories.NewsRepository
import com.example.usnews.room.model.News
import com.example.usnews.service.NewsService
import com.example.usnews.utils.BaseScheduler
import com.example.usnews.utils.NewsApiConverter
import com.example.usnews.utils.StringProvider
import javax.inject.Inject

interface MainView {
    fun showListContainer()
    fun showErrorMessage()
}

class MainViewModel @Inject constructor(private val baseScheduler: BaseScheduler,
                                        private val newsService: NewsService,
                                        private val stringProvider: StringProvider,
                                        private val newsRepository: NewsRepository,
                                        private val newsApiConverter: NewsApiConverter): BaseViewModel() {

    private var view: MainView? = null

    var isSportNewsDownloaded = false
    var isBusinessNewsDownloaded = false

    fun attach(view: MainView) {
        this.view = view
    }

    fun fetchAndSaveData() {
        val disposable = newsRepository.clearAll()
            .subscribeOn(baseScheduler.io())
            .observeOn(baseScheduler.main())
            .subscribe({
                fetchAndSaveNews(NewsType.SPORT)
                fetchAndSaveNews(NewsType.BUSINESS)
            }, { showErrorMessage() })
        compositeDisposable?.add(disposable)
    }

    private fun fetchAndSaveNews(type: NewsType) {
        val disposable = newsService.fetchNews(stringProvider.provideString(R.string.default_country), chooseCorrectStringForNewsType(type), stringProvider.provideString(R.string.apiKEY))
            .subscribeOn(baseScheduler.io())
            .observeOn(baseScheduler.main())
            .subscribe({result -> convertAndSaveResult(result, type)
            }, { error -> showErrorMessage()})
        compositeDisposable?.add(disposable)
    }

    private fun showErrorMessage() {
        view?.showErrorMessage()
    }

    private fun convertAndSaveResult(result : NewsModelResponse, type : NewsType) {
        val convertedNews = newsApiConverter.convertResponsePropertyToRoomModel(result, chooseCorrectStringForNewsType(type))
        saveNews(convertedNews, type)
    }

    private fun chooseCorrectStringForNewsType(type: NewsType) : String {
        return stringProvider.provideString(if (type == NewsType.BUSINESS) R.string.business else R.string.sport)
    }

    private fun saveNews(news : List<News>, type : NewsType) {
        val disposable = newsRepository.insertAll(news)
            .subscribeOn(baseScheduler.io())
            .observeOn(baseScheduler.main())
            .subscribe({
                if (type == NewsType.SPORT) {
                    isSportNewsDownloaded = true
                } else {
                    isBusinessNewsDownloaded = true
                }
                if (isSportNewsDownloaded && isBusinessNewsDownloaded) {
                    showListContainer()
                }
            },{
                error -> showErrorMessage()
            })

        compositeDisposable?.add(disposable)
    }

    private fun showListContainer() {
        view?.showListContainer()
    }

    fun detach() {
        view = null
    }
}