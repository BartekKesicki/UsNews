package com.example.usnews.fragments.business

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.usnews.R
import com.example.usnews.base.BaseFragment
import com.example.usnews.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_business_news.*
import javax.inject.Inject

class BusinessNewsFragment : BaseFragment() {

    companion object {
        fun newInstance() : BusinessNewsFragment {
            return BusinessNewsFragment()
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: BusinessNewsViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_business_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(BusinessNewsViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        attachAdapterToRecyclerView(business_news_recycler_view)
        viewModel.newsLiveData.observe(requireActivity(), newsListUpdateObserver)
        viewModel.loadData()
    }
}