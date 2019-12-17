package com.hs.opendata

abstract class BaseViewState<T> {

    fun setViewData(data: T) {
        this.data = data
    }

    var data: T? = null
        protected set
    var error: Throwable? = null
    var currentState = 0

    enum class State(var value: Int) {
        LOADING(0), SUCCESS(1), FAILED(-1);
    }
}