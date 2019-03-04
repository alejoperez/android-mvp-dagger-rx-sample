package com.mvp.dagger.rx.sample.data.photos

import android.content.Context
import com.mvp.dagger.rx.sample.data.Photo

interface IPhotosDataSource {

    fun getPhotos(context: Context, listener: PhotosRepository.IPhotosListener)

    fun savePhotos(photos: List<Photo>)

}