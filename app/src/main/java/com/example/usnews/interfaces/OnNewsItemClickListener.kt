package com.example.usnews.interfaces

import com.example.usnews.room.model.News

interface OnNewsItemClickListener {
    fun onClickItem(news : News)
}