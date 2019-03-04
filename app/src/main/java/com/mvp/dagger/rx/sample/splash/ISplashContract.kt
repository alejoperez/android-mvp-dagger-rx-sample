package com.mvp.dagger.rx.sample.splash

import com.mvp.dagger.rx.sample.base.IBaseView

interface ISplashContract {

    interface View: IBaseView {
        fun goToNextScreen()
    }

    interface Presenter {
        fun isLoggedIn(): Boolean
    }

}