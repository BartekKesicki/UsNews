package com.example.usnews.di

import com.example.usnews.fragments.all.AllNewsFragment
import com.example.usnews.fragments.business.BusinessNewsFragment
import com.example.usnews.fragments.sport.SportNewsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun provideBusinessNewsFragment(): BusinessNewsFragment

    @ContributesAndroidInjector
    abstract fun provideAllNewsFragment() : AllNewsFragment

    @ContributesAndroidInjector
    abstract fun provideSportNewsFragment() : SportNewsFragment
}