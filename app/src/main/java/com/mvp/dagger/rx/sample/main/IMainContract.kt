package com.mvp.dagger.rx.sample.main

import com.mvp.dagger.rx.sample.base.IBaseView
import com.mvp.dagger.rx.sample.data.User

interface IMainContract {

    interface View: IBaseView

    interface Presenter {
        fun getUser(): User?
        fun logout()
    }

}