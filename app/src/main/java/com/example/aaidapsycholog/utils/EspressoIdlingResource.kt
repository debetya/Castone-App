package com.example.aaidapsycholog.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private const val SOURCE = "GLOBAL"
    val idlingResource = CountingIdlingResource(SOURCE)

    fun increment(){
        idlingResource.increment()
    }
    fun decrement(){
        idlingResource.decrement()
    }
}