package com.example.usnews.service

import com.example.usnews.data.model.NewsModelResponse
import io.reactivex.Single

interface NewsService {
    fun fetchNews(country : String, category : String, apiKey : String) : Single<NewsModelResponse>
}