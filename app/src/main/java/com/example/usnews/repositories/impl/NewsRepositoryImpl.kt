package com.example.usnews.repositories.impl

import com.example.usnews.repositories.NewsRepository
import com.example.usnews.room.dao.NewsDao
import com.example.usnews.room.model.News
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsDao: NewsDao) : NewsRepository {
    override fun insertAll(news: List<News>): Completable {
        return Completable.fromAction { newsDao.insertAll(news) }
    }

    override fun getSpecified(category : String): Single<List<News>> {
        return newsDao.getSpecified(category)
    }

    override fun getAll(): Single<List<News>> {
        return newsDao.getAll()
    }

    override fun clearAll(): Completable {
        return Completable.fromAction { newsDao.clearAll() }
    }
}