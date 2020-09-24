package com.example.usnews.fragments.all

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
import kotlinx.android.synthetic.main.fragment_all_news.*
import javax.inject.Inject


class AllNewsFragment : BaseFragment() {

    companion object {
        fun newInstance() : AllNewsFragment {
            return AllNewsFragment()
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: AllNewsViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AllNewsViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        attachAdapterToRecyclerView(all_news_recycler_view)
        viewModel.newsLiveData.observe(requireActivity(), newsListUpdateObserver)
        viewModel.loadData()
    }
}