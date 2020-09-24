package com.example.usnews.utils.impl

import android.content.Context
import com.example.usnews.utils.StringProvider
import javax.inject.Inject

class StringProviderImpl @Inject constructor(private val context : Context) : StringProvider {

    override fun provideString(id: Int): String {
        return context.getString(id)
    }
}