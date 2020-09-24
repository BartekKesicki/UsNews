package com.example.usnews.utils

import com.example.usnews.data.model.NewsModelResponse
import com.example.usnews.room.model.News

interface NewsApiConverter {
    fun convertResponsePropertyToRoomModel(newsModelResponse: NewsModelResponse, category : String) : List<News>
}