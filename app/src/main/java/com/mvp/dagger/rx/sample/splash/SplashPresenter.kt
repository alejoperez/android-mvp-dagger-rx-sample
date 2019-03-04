package com.mvp.dagger.rx.sample.splash

import com.mvp.dagger.rx.sample.data.user.IUserDataSource
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val view: ISplashContract.View,
                                          private val userRepository: IUserDataSource): ISplashContract.Presenter {

    override fun isLoggedIn(): Boolean = userRepository.isLoggedIn(view.getViewContext())

}