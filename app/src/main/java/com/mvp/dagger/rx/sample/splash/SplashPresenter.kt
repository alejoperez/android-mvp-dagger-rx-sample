package com.mvp.dagger.rx.sample.splash

import com.mvp.dagger.rx.sample.base.BasePresenter
import com.mvp.dagger.rx.sample.data.user.IUserDataSource
import com.mvp.dagger.rx.sample.extensions.addTo
import com.mvp.dagger.rx.sample.extensions.applyIoAndMainThreads
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val view: ISplashContract.View,
                                          private val userRepository: IUserDataSource): BasePresenter(), ISplashContract.Presenter {

    override fun isLoggedIn() {
        userRepository.isLoggedIn(view.getViewContext())
                .applyIoAndMainThreads()
                .subscribe(
                        {
                            onLoggedInEventSuccess(it)
                        },
                        {
                            onLoggedInEventFailure()
                        }
                )
                .addTo(compositeDisposable)
    }

    private fun onLoggedInEventSuccess(isLoggedIn: Boolean) {
        if (view.isActive()) {
            view.onLoggedInEventSuccess(isLoggedIn)
        }
    }

    private fun onLoggedInEventFailure() {
        if (view.isActive()) {
            view.onLoggedInEventFailure()
        }
    }

}