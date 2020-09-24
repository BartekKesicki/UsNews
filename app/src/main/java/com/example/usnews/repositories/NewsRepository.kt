package com.example.usnews.repositories

import com.example.usnews.room.model.News
import io.reactivex.Completable
import io.reactivex.Single

interface NewsRepository {
    fun insertAll(news : List<News>) : Completable
    fun getSpecified(category : String) : Single<List<News>>
    fun getAll() : Single<List<News>>
    fun clearAll() : Completable
}