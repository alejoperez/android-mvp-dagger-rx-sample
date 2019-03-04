package com.mvp.dagger.rx.sample.main

import com.mvp.dagger.rx.sample.base.IBasePresenter
import com.mvp.dagger.rx.sample.base.IBaseView
import com.mvp.dagger.rx.sample.data.User

interface IMainContract {

    interface View: IBaseView {
        fun onLogOutSuccess()
        fun onLogOutFailure()
    }

    interface Presenter: IBasePresenter {
        fun getUser(): User?
        fun logout()
    }

}