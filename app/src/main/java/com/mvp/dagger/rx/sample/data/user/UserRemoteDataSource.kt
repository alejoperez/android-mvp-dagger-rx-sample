package com.mvp.dagger.rx.sample.data.user

import android.content.Context
import com.mvp.dagger.rx.sample.data.User
import com.mvp.dagger.rx.sample.webservice.*
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(): IUserDataSource {

    override fun login(context: Context, request: LoginRequest): Single<LoginResponse> = WebService.createService(context, IApi::class.java).login(request)

    override fun register(context: Context, request: RegisterRequest): Single<RegisterResponse> = WebService.createService(context, IApi::class.java).register(request)

    override fun logout(context: Context): Completable = throw UnsupportedOperationException()

    override fun getUser(): User? = throw UnsupportedOperationException()

    override fun saveUser(user: User) = throw UnsupportedOperationException()

    override fun isLoggedIn(context: Context): Single<Boolean> = throw UnsupportedOperationException()
}