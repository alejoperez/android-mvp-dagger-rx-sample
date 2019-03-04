package com.mvp.dagger.rx.sample.splash

import com.mvp.dagger.rx.sample.base.IBasePresenter
import com.mvp.dagger.rx.sample.base.IBaseView

interface ISplashContract {

    interface View: IBaseView {
        fun onLoggedInEventSuccess(isLoggedIn: Boolean)
        fun onLoggedInEventFailure()
    }

    interface Presenter: IBasePresenter {
        fun isLoggedIn()
    }

}