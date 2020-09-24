package com.example.usnews.di

import com.example.usnews.main.MainActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}