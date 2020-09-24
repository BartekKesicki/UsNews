package com.example.usnews.utils

import io.reactivex.Scheduler

interface BaseScheduler {
    fun io() : Scheduler
    fun main() : Scheduler
}