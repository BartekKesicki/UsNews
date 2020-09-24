package com.example.usnews.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.usnews.R
import com.example.usnews.adapters.NewsListsSectionsAdapter
import com.example.usnews.di.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var viewModelFactory : ViewModelFactory

    lateinit var viewModel : MainViewModel

    lateinit var newsListsSectionsAdapter: NewsListsSectionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.attach(this)
        viewModel.fetchAndSaveData()
    }

    private fun initViewPager() {
        newsListsSectionsAdapter = NewsListsSectionsAdapter(this, supportFragmentManager)
        newsListsSectionsAdapter.initializeFragments()
        pager.adapter = newsListsSectionsAdapter
        pager.currentItem = newsListsSectionsAdapter.SPORT_NEWS_TAB_INDEX
        tabs_layout.setupWithViewPager(pager)
        pager.requestLayout()
    }

    override fun onStart() {
        super.onStart()
        initViewPager()
    }

    override fun showListContainer() {
        loading_container.visibility = View.GONE
        error_textview.visibility = View.GONE
        view_pager_container.visibility = View.VISIBLE
    }

    override fun showErrorMessage() {
        loading_container.visibility = View.GONE
        error_textview.visibility = View.VISIBLE
        view_pager_container.visibility = View.GONE
    }

    override fun onDestroy() {
        viewModel.detach()
        super.onDestroy()
    }
}