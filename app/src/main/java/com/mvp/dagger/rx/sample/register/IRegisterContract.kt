package com.mvp.dagger.rx.sample.register

import com.mvp.dagger.rx.sample.base.IBasePresenter
import com.mvp.dagger.rx.sample.base.IBaseView

interface IRegisterContract {

    interface IRegisterView: IBaseView {
        fun getName(): String
        fun getEmail(): String
        fun getPassword(): String
        fun showProgress()
        fun hideProgress()
        fun onRegisterSuccess()
        fun onRegisterFailure()
    }

    interface IRegisterPresenter: IBasePresenter {
        fun isValidName(name: String): Boolean
        fun isValidEmail(email: String): Boolean
        fun isValidPassword(password: String): Boolean
        fun isValidForm(name: String, email: String, password: String): Boolean
        fun register(name: String, email:String, password: String)
    }
}