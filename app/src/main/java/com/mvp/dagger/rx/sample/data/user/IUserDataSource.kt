package com.mvp.dagger.rx.sample.data.user

import android.content.Context
import com.mvp.dagger.rx.sample.data.User
import com.mvp.dagger.rx.sample.webservice.LoginRequest
import com.mvp.dagger.rx.sample.webservice.LoginResponse
import com.mvp.dagger.rx.sample.webservice.RegisterRequest
import com.mvp.dagger.rx.sample.webservice.RegisterResponse
import io.reactivex.Completable
import io.reactivex.Single

interface IUserDataSource {
    fun getUser(): User?
    fun saveUser(user: User)
    fun login(context: Context, request: LoginRequest): Single<LoginResponse>
    fun register(context: Context, request: RegisterRequest): Single<RegisterResponse>
    fun isLoggedIn(context: Context): Single<Boolean>
    fun logout(context: Context): Completable
}