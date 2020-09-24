package com.example.usnews.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usnews.base.BaseFragmentViewModel
import com.example.usnews.base.BaseViewModel
import com.example.usnews.fragments.all.AllNewsViewModel
import com.example.usnews.fragments.business.BusinessNewsViewModel
import com.example.usnews.fragments.sport.SportNewsViewModel
import com.example.usnews.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AllNewsViewModel::class)
    abstract fun bindAllNewsViewModel(viewModel: AllNewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BusinessNewsViewModel::class)
    abstract fun bindBusinessNewsViewModel(viewModel: BusinessNewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SportNewsViewModel::class)
    abstract fun bindSportNewsViewModel(viewModel: SportNewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    abstract fun bindBaseViewModel(viewModel : BaseViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BaseFragmentViewModel::class)
    abstract fun bindBaseFragmentViewModel(viewModel : BaseFragmentViewModel) : ViewModel
}