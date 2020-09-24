package com.example.usnews.utils.impl

import com.example.usnews.data.model.NewsModelResponse
import com.example.usnews.data.model.NewsModelResponseProperty
import com.example.usnews.room.model.News
import com.example.usnews.utils.NewsApiConverter
import javax.inject.Inject

class NewsApiConverterImpl @Inject() constructor() : NewsApiConverter {
    override fun convertResponsePropertyToRoomModel(newsModelResponse: NewsModelResponse, category : String): List<News> {
        val convertedNews = ArrayList<News>()
        val newsToConvert = newsModelResponse.list
        if (newsToConvert != null) for (newsModelResponseProperty in newsToConvert) {
            val article = convertNewsModelResponsePropertyToRoomModel(newsModelResponseProperty, category)
            convertedNews.add(article)
        }
        return convertedNews
    }

    private fun convertNewsModelResponsePropertyToRoomModel(newsModelResponseProperty: NewsModelResponseProperty, category : String) : News {
        val news = News()
        news.articleId = newsModelResponseProperty.source?.id ?: ""
        news.sourceName = newsModelResponseProperty.source?.name ?: ""
        news.author = newsModelResponseProperty.author ?: ""
        news.content = newsModelResponseProperty.content ?: ""
        news.description = newsModelResponseProperty.description ?: ""
        news.publishedAt = newsModelResponseProperty.publishedAt ?: ""
        news.title = newsModelResponseProperty.title ?: ""
        news.url = newsModelResponseProperty.url ?: ""
        news.urlToImage = newsModelResponseProperty.urlToImage ?: ""
        news.category = category
        return news
    }

}