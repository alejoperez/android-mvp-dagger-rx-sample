package com.mvp.dagger.rx.sample.di

import com.mvp.dagger.rx.sample.data.photos.PhotosRepositoryModule
import com.mvp.dagger.rx.sample.data.places.PlacesRepositoryModule
import com.mvp.dagger.rx.sample.data.user.UserRepositoryModule
import dagger.Module

@Module(
        includes = [
            UserRepositoryModule::class,
            PlacesRepositoryModule::class,
            PhotosRepositoryModule::class
        ]
)
abstract class RepositoriesModule