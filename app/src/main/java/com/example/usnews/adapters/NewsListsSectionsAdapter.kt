package com.example.usnews.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.usnews.R
import com.example.usnews.fragments.all.AllNewsFragment
import com.example.usnews.fragments.business.BusinessNewsFragment
import com.example.usnews.fragments.sport.SportNewsFragment

class NewsListsSectionsAdapter(private val context: Context, private val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val SPORT_NEWS_TAB_INDEX = 0
    val BUSINESS_NEWS_TAB_INDEX = 1
    val ALL_NEWS_TAB_INDEX = 2

    private lateinit var sportNewsFragment: SportNewsFragment
    private lateinit var businessNewsFragment: BusinessNewsFragment
    private lateinit var allNewsFragment: AllNewsFragment
    private var isFragmentsInitialized : Boolean = false

    private val TABS = intArrayOf(SPORT_NEWS_TAB_INDEX, BUSINESS_NEWS_TAB_INDEX, ALL_NEWS_TAB_INDEX)

    override fun getCount(): Int {
        return TABS.size
    }

    override fun getItem(position: Int): Fragment {
        return when {
            TABS[position] == SPORT_NEWS_TAB_INDEX -> {
                sportNewsFragment
            }
            TABS[position] == BUSINESS_NEWS_TAB_INDEX -> {
                businessNewsFragment
            }
            else -> allNewsFragment
        }
    }

    fun initializeFragments() {
        if (!isFragmentsInitialized) {
            sportNewsFragment = SportNewsFragment.newInstance()
            businessNewsFragment = BusinessNewsFragment.newInstance()
            allNewsFragment = AllNewsFragment.newInstance()
            isFragmentsInitialized = true
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when {
            TABS[position] == SPORT_NEWS_TAB_INDEX -> { context.getString(R.string.sport_tab)}
            TABS[position] == BUSINESS_NEWS_TAB_INDEX -> { context.getString(R.string.business_tab)}
            else -> {context.getString(R.string.all)}
        }
    }

}