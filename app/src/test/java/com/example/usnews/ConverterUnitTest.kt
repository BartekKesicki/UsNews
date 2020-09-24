package com.example.usnews

import com.example.usnews.data.model.NewsModelResponse
import com.example.usnews.data.model.NewsModelResponseProperty
import com.example.usnews.data.model.Source
import com.example.usnews.room.model.News
import com.example.usnews.utils.NewsApiConverter
import com.example.usnews.utils.impl.NewsApiConverterImpl
import org.junit.Test

import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ConverterUnitTest {

    lateinit var newsApiConverter: NewsApiConverter

    private val NEWS_A_PROPERTY = "NEWS_A_PROPERTY"
    private val NEWS_A_CATEGORY_PROPERTY = "NEWS_A_CATEGORY_PROPERTY"
    private val NEWS_B_PROPERTY = "NEWS_B_PROPERTY"

    @Before
    fun init() {
        newsApiConverter = NewsApiConverterImpl()
    }

    @Test
    fun testNewsConversionShouldBeSuccessful() {
        val newsToCompare = createNews(NEWS_A_PROPERTY, NEWS_A_CATEGORY_PROPERTY)
        val modelResponse = createNewsModelResponse(NEWS_A_PROPERTY)
        val convertedNews = newsApiConverter.convertResponsePropertyToRoomModel(modelResponse, NEWS_A_CATEGORY_PROPERTY)
        var isEqual = true
        for (news in convertedNews) {
            if (!isNewsesEqual(news, newsToCompare)) {
                isEqual = false
                break
            }
        }
        assert(isEqual)
    }

    @Test
    fun testNewsConversionToOtherNewsShouldBeFailed() {
        val newsToCompare = createNews(NEWS_A_PROPERTY, NEWS_A_CATEGORY_PROPERTY)
        val modelResponse = createNewsModelResponse(NEWS_B_PROPERTY)
        val convertedNews = newsApiConverter.convertResponsePropertyToRoomModel(modelResponse, NEWS_A_CATEGORY_PROPERTY)
        var isNotEqual = true
        for (news in convertedNews) {
            if (isNewsesEqual(news, newsToCompare)) {
                isNotEqual = false
                break

            }
        }
        assert(isNotEqual)
    }

    private fun createNews(propertyForTest : String, categoryForTest : String) : News {
        val news = News()
        news.urlToImage = propertyForTest
        news.url = propertyForTest
        news.category = categoryForTest
        news.title = propertyForTest
        news.publishedAt = propertyForTest
        news.description = propertyForTest
        news.content = propertyForTest
        news.author = propertyForTest
        news.sourceName = propertyForTest
        news.articleId = propertyForTest
        return news
    }

    private fun createNewsModelResponse(propertyForTest: String) : NewsModelResponse {
        val newsModelResponse = NewsModelResponse()
        newsModelResponse.list = ArrayList<NewsModelResponseProperty>()
        newsModelResponse.list?.add(createNewsModelResponseProperty(propertyForTest))
        return newsModelResponse
    }

    private fun createNewsModelResponseProperty(propertyForTest: String): NewsModelResponseProperty {
        val newsModelResponseProperty = NewsModelResponseProperty()
        newsModelResponseProperty.source = Source()
        newsModelResponseProperty.source?.id = propertyForTest
        newsModelResponseProperty.source?.name = propertyForTest
        newsModelResponseProperty.author = propertyForTest
        newsModelResponseProperty.content = propertyForTest
        newsModelResponseProperty.description = propertyForTest
        newsModelResponseProperty.publishedAt = propertyForTest
        newsModelResponseProperty.title = propertyForTest
        newsModelResponseProperty.url = propertyForTest
        newsModelResponseProperty.urlToImage = propertyForTest
        return newsModelResponseProperty
    }

    private fun isNewsesEqual(newsToCompare : News, examinedNews : News) : Boolean {
        return newsToCompare.articleId == examinedNews.articleId &&
        newsToCompare.sourceName == examinedNews.sourceName &&
        newsToCompare.author == examinedNews.author &&
        newsToCompare.content == examinedNews.content &&
        newsToCompare.description == examinedNews.description &&
        newsToCompare.publishedAt == examinedNews.publishedAt &&
        newsToCompare.title == examinedNews.title &&
        newsToCompare.category == examinedNews.category &&
        newsToCompare.url == examinedNews.url &&
        newsToCompare.urlToImage == examinedNews.urlToImage &&
        newsToCompare.id == examinedNews.id
    }
}