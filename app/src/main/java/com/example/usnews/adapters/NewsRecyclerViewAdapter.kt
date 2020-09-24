package com.example.usnews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.usnews.R
import com.example.usnews.interfaces.OnNewsItemClickListener
import com.example.usnews.room.model.News
import kotlinx.android.synthetic.main.news_item_layout.view.*


class NewsRecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val list = ArrayList<News>()

    lateinit var onNewsItemClickListener : OnNewsItemClickListener

    fun setData(list: List<News>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(
            R.layout.news_item_layout,
            parent,
            false
        )
        return RecyclerViewViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val news = list.get(position)
        val viewHolder = holder as RecyclerViewViewHolder
        Glide.with(context).load(news.urlToImage).into(viewHolder.photo)
        viewHolder.title.text = news.title
        viewHolder.publishedAt.text = news.publishedAt
        viewHolder.description.text = news.description
        viewHolder.itemView.setOnClickListener {
            onNewsItemClickListener.onClickItem(news)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

internal class RecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var photo: ImageView = itemView.photo_thumbnail
    var title : TextView = itemView.title_textview
    var publishedAt : TextView = itemView.published_at_textview
    var description : TextView = itemView.description_textview
}