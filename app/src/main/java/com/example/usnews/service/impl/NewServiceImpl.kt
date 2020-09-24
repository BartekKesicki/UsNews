package com.example.usnews.service.impl

import com.example.usnews.data.model.NewsModelResponse
import com.example.usnews.data.rest.NewsAPIService
import com.example.usnews.service.NewsService
import io.reactivex.Single
import javax.inject.Inject

class NewServiceImpl @Inject constructor(private val newsAPIService: NewsAPIService) : NewsService {

    override fun fetchNews(country : String, category: String, apiKey: String): Single<NewsModelResponse> {
        return newsAPIService.getNews(country, category, apiKey)
    }

}