package com.example.usnews.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News")
class News {
    @PrimaryKey(autoGenerate = true) var id : Long? = null
    @ColumnInfo(name = "sourceId") var articleId : String = ""
    @ColumnInfo(name = "sourceName") var sourceName : String = ""
    @ColumnInfo(name = "author") var author : String = ""
    @ColumnInfo(name = "title") var title : String = ""
    @ColumnInfo(name = "description") var description : String = ""
    @ColumnInfo(name = "url") var url : String = ""
    @ColumnInfo(name = "urlToImage") var urlToImage : String = ""
    @ColumnInfo(name = "publishedAt") var publishedAt : String = ""
    @ColumnInfo(name = "content") var content : String = ""
    @ColumnInfo(name = "category") var category : String = ""
}