package com.example.usnews.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.usnews.room.model.News
import io.reactivex.Single

@Dao
interface NewsDao {

    @Insert
    fun insertAll(news : List<News>)

    @Query("SELECT * FROM News WHERE category=:category")
    fun getSpecified(category : String) : Single<List<News>>

    @Query("SELECT * FROM News")
    fun getAll() : Single<List<News>>

    @Query("DELETE FROM News")
    fun clearAll()
}