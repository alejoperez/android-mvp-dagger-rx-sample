package com.mvp.dagger.rx.sample.data

interface IBaseSourceListener {

    companion object {
        const val LOCAL = "local"
        const val REMOTE = "remote"
    }

    fun onNetworkError()
}