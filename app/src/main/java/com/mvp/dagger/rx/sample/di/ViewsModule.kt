package com.mvp.dagger.rx.sample.di

import com.mvp.dagger.rx.sample.login.LoginModule
import com.mvp.dagger.rx.sample.main.MainModule
import com.mvp.dagger.rx.sample.photos.PhotosModule
import com.mvp.dagger.rx.sample.photos.detail.PhotoDetailModule
import com.mvp.dagger.rx.sample.places.PlacesModule
import com.mvp.dagger.rx.sample.register.RegisterModule
import com.mvp.dagger.rx.sample.splash.SplashModule
import dagger.Module

@Module(
        includes = [
            SplashModule::class,
            RegisterModule::class,
            LoginModule::class,
            MainModule::class,
            PlacesModule::class,
            PhotosModule::class,
            PhotoDetailModule::class
        ]
)
abstract class ViewsModule