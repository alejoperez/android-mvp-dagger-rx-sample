package com.mvp.dagger.rx.sample.data.user

import android.content.Context
import com.mvp.dagger.rx.sample.data.IBaseSourceListener
import com.mvp.dagger.rx.sample.data.User
import com.mvp.dagger.rx.sample.storage.PreferenceManager
import com.mvp.dagger.rx.sample.webservice.LoginRequest
import com.mvp.dagger.rx.sample.webservice.LoginResponse
import com.mvp.dagger.rx.sample.webservice.RegisterRequest
import com.mvp.dagger.rx.sample.webservice.RegisterResponse
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class UserRepository
@Inject constructor(@Named(IBaseSourceListener.LOCAL) private val localDataSource: IUserDataSource,
                    @Named(IBaseSourceListener.REMOTE) private val remoteDataSource: IUserDataSource) : IUserDataSource {

    override fun saveUser(user: User) = localDataSource.saveUser(user)

    override fun getUser(): User? = localDataSource.getUser()

    override fun login(context: Context, request: LoginRequest): Single<LoginResponse> =
            remoteDataSource.login(context, request)
                    .doOnSuccess {
                        PreferenceManager<String>(context).putPreference(PreferenceManager.ACCESS_TOKEN, it.accessToken)
                        localDataSource.saveUser(it.toUser())
                    }

    override fun register(context: Context, request: RegisterRequest): Single<RegisterResponse> =
            remoteDataSource.register(context, request)
                    .doOnSuccess {
                        PreferenceManager<String>(context).putPreference(PreferenceManager.ACCESS_TOKEN, it.accessToken)
                        localDataSource.saveUser(it.toUser())
                    }

    override fun isLoggedIn(context: Context): Single<Boolean> = localDataSource.isLoggedIn(context)

    override fun logout(context: Context): Completable = localDataSource.logout(context)

}
