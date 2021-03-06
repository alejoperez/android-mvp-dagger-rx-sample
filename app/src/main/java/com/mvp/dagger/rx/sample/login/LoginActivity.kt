package com.mvp.dagger.rx.sample.login

import android.os.Bundle
import android.view.View
import com.mvp.dagger.rx.sample.R
import com.mvp.dagger.rx.sample.base.BaseActivity
import com.mvp.dagger.rx.sample.extensions.getWhiteSpaceFilters
import com.mvp.dagger.rx.sample.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), ILoginContract.View {

    @Inject
    lateinit var presenter: ILoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail.filters = getWhiteSpaceFilters()
        etPassword.filters = getWhiteSpaceFilters()

        btLogin.setOnClickListener {
            onLoginClicked()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    private fun onLoginClicked() {
        if (presenter.isValidForm(getEmail(), getPassword())) {
            presenter.login(getEmail(), getPassword())
        } else {
            if (!presenter.isValidEmail(getEmail())) {
                etEmail.error = getString(R.string.error_invalid_email)
            }
            if (!presenter.isValidPassword(getPassword())) {
                etPassword.error = getString(R.string.error_empty_password)
            }
        }
    }

    override fun getEmail(): String = etEmail.text.toString()

    override fun getPassword(): String = etPassword.text.toString()

    override fun onLoginSuccess() {
        startActivity<MainActivity>()
        finishAffinity()
    }

    override fun onLoginFailure() = showAlert(R.string.error_invalid_credentials)

    override fun showProgress() {
        btLogin.visibility = View.INVISIBLE
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        btLogin.visibility = View.VISIBLE
        progress.visibility = View.INVISIBLE
    }
}
