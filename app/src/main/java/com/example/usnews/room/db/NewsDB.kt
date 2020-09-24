package com.example.usnews.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.usnews.room.dao.NewsDao
import com.example.usnews.room.model.News

@Database(entities = [News::class], version = 1)
abstract class NewsDB : RoomDatabase() {

    companion object {
        val DB_NAME = "news_db.db"
    }

    abstract fun newsDao() : NewsDao
}