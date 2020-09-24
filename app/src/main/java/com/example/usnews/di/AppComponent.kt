package com.example.usnews.di

import com.example.usnews.base.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    ContextModule::class,
    ApplicationModule::class,
    ViewModelModule::class,
    UseCaseModule::class,
    RepositoryModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): AppComponent

    }

    fun inject(application: BaseApplication)
}