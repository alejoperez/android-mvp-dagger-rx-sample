package com.mvp.dagger.rx.sample.main

import com.mvp.dagger.rx.sample.base.BasePresenter
import com.mvp.dagger.rx.sample.data.User
import com.mvp.dagger.rx.sample.data.user.IUserDataSource
import com.mvp.dagger.rx.sample.extensions.addTo
import com.mvp.dagger.rx.sample.extensions.applyIoAndMainThreads
import javax.inject.Inject

class MainPresenter @Inject constructor(private val view: IMainContract.View,
                                        private val userRepository: IUserDataSource): BasePresenter(), IMainContract.Presenter {

    override fun getUser(): User? = userRepository.getUser()

    override fun logout() {
        userRepository.logout(view.getViewContext())
                .applyIoAndMainThreads()
                .subscribe(
                        {view.onLogOutSuccess()},
                        {view.onLogOutFailure()}
                )
                .addTo(compositeDisposable)
    }

}