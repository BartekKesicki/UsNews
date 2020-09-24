package com.example.usnews.utils.impl

import com.example.usnews.utils.BaseScheduler
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BaseSchedulerImpl @Inject constructor() : BaseScheduler {

    override fun io(): Scheduler = Schedulers.io()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

}