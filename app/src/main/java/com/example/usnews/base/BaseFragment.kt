package com.example.usnews.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.usnews.R
import com.example.usnews.adapters.NewsRecyclerViewAdapter
import com.example.usnews.interfaces.OnNewsItemClickListener
import com.example.usnews.room.model.News
import kotlinx.android.synthetic.main.news_info_dialog_container.view.*

open class BaseFragment : Fragment(), OnNewsItemClickListener {

    lateinit var newsRecyclerViewAdapter: NewsRecyclerViewAdapter

    var newsListUpdateObserver: Observer<ArrayList<News>> =
        Observer<ArrayList<News>> { newsList -> newsRecyclerViewAdapter.setData(newsList) }

    protected fun attachAdapterToRecyclerView(recyclerView: RecyclerView) {
        newsRecyclerViewAdapter = NewsRecyclerViewAdapter(requireContext())
        newsRecyclerViewAdapter.onNewsItemClickListener = this
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = newsRecyclerViewAdapter
    }

    override fun onClickItem(news: News) {
        val dialog = createDialog(news)
        dialog.show()
    }

    private fun createDialog(news: News) : AlertDialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(ContextThemeWrapper(requireActivity(), R.style.myDialog))
        builder.setView(inflateView(news))
        return builder.create()
    }

    private fun inflateView(news: News) : View {
        val inflater = requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.news_info_dialog_container, null)
        Glide.with(requireActivity()).load(news.urlToImage).into(view.image_view)
        view.title.text = news.title
        view.published_at.text = news.publishedAt
        view.description.text = news.description
        return view
    }
}