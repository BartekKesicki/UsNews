package com.example.usnews.data.rest

import com.example.usnews.data.model.NewsModelResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPIService {
    @GET("top-headlines")
    abstract fun getNews(@Query("country") country : String,
                @Query("category") category : String,
                @Query("apiKEY") apiKEY : String): Single<NewsModelResponse>

    companion object Factory {
        fun create(retrofit: Retrofit) : NewsAPIService {
            return retrofit.create(NewsAPIService::class.java)
        }
    }

}