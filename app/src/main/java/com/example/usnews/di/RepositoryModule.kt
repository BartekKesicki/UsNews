package com.example.usnews.di

import android.content.Context
import androidx.room.Room
import com.example.usnews.repositories.NewsRepository
import com.example.usnews.repositories.impl.NewsRepositoryImpl
import com.example.usnews.room.dao.NewsDao
import com.example.usnews.room.db.NewsDB
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNewsDataBase(context : Context) : NewsDB {
        return Room.databaseBuilder(context.applicationContext, NewsDB::class.java, NewsDB.DB_NAME).build()
    }

    @Provides
    fun provideNewsDao(newsDB: NewsDB) : NewsDao {
        return newsDB.newsDao()
    }

    @Provides
    fun provideNewsRepository(newsDao: NewsDao) : NewsRepository {
        return NewsRepositoryImpl(newsDao)
    }
}