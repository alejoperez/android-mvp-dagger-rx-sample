package com.mvp.dagger.rx.sample.webservice

import com.mvp.dagger.rx.sample.data.User


class RegisterResponse(val id: Long,
                       val name: String,
                       val email: String,
                       val accessToken: String) {

    fun toUser(): User = User(id,name,email)
}

class LoginResponse(val success: Boolean,
                    val id: Long,
                    val name: String,
                    val email: String,
                    val accessToken: String) {

    fun toUser(): User = User(id,name,email)
}