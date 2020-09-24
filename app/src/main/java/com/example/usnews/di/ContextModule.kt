package com.example.usnews.di

import android.content.Context
import com.example.usnews.base.BaseApplication
import dagger.Module
import dagger.Provides


@Module
class ContextModule {

    @Provides
    fun provideContext(baseApplication: BaseApplication): Context {
        return baseApplication.applicationContext
    }
}