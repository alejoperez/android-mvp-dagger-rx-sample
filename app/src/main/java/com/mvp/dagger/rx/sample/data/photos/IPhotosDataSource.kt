package com.mvp.dagger.rx.sample.data.photos

import android.content.Context
import com.mvp.dagger.rx.sample.data.Photo
import io.reactivex.Completable
import io.reactivex.Single

interface IPhotosDataSource {

    fun getPhotos(context: Context): Single<List<Photo>>

    fun savePhotos(photos: List<Photo>): Completable

}