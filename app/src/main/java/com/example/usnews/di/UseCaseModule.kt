package com.example.usnews.di

import android.content.Context
import com.example.usnews.data.rest.NewsAPIService
import com.example.usnews.service.NewsService
import com.example.usnews.service.impl.NewServiceImpl
import com.example.usnews.utils.BaseScheduler
import com.example.usnews.utils.NewsApiConverter
import com.example.usnews.utils.StringProvider
import com.example.usnews.utils.impl.BaseSchedulerImpl
import com.example.usnews.utils.impl.NewsApiConverterImpl
import com.example.usnews.utils.impl.StringProviderImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideStringProvider(context : Context) : StringProvider {
        return StringProviderImpl(context)
    }

    @Provides
    fun provideBaseScheduler() : BaseScheduler {
        return BaseSchedulerImpl()
    }

    @Provides
    fun provideNewsService(newsAPIService: NewsAPIService) : NewsService {
        return NewServiceImpl(newsAPIService)
    }

    @Provides
    fun provideNewsApiConverter() : NewsApiConverter {
        return NewsApiConverterImpl()
    }
}