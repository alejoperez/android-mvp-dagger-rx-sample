package com.mvp.dagger.rx.sample.splash

import android.os.Bundle
import android.os.Handler
import com.mvp.dagger.rx.sample.R
import com.mvp.dagger.rx.sample.base.BaseActivity
import com.mvp.dagger.rx.sample.main.MainActivity
import com.mvp.dagger.rx.sample.register.RegisterActivity
import org.jetbrains.anko.startActivity
import javax.inject.Inject

private const val SPLASH_DELAY = 2000L

class SplashActivity : BaseActivity(), ISplashContract.View {

    @Inject
    lateinit var presenter: ISplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({ goToNextScreen() }, SPLASH_DELAY)
    }

    override fun goToNextScreen() {
        if (presenter.isLoggedIn()) {
            startActivity<MainActivity>()
        } else {
            startActivity<RegisterActivity>()
        }
        finish()
    }
}
