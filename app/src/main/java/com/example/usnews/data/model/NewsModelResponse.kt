package com.example.usnews.data.model

import com.google.gson.annotations.SerializedName

class NewsModelResponse {

    @SerializedName("status")
    var status : String = ""

    @SerializedName("totalResults")
    var totalResults : Int = 0

    @SerializedName("articles")
    var list : ArrayList<NewsModelResponseProperty>? = null
}

class NewsModelResponseProperty {
    @SerializedName("source")
    var source : Source? = null

    @SerializedName("author")
    var author : String = ""

    @SerializedName("title")
    var title : String = ""

    @SerializedName("description")
    var description : String = ""

    @SerializedName("url")
    var url : String = ""

    @SerializedName("urlToImage")
    var urlToImage : String = ""

    @SerializedName("publishedAt")
    var publishedAt : String = ""

    @SerializedName("content")
    var content : String = ""
}

class Source {

    @SerializedName("id")
    var id : String = ""

    @SerializedName("name")
    var name : String = ""
}