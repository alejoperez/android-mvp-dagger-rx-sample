package com.mvp.dagger.rx.sample.data.photos

import android.content.Context
import com.mvp.dagger.rx.sample.data.Photo
import com.mvp.dagger.rx.sample.webservice.IApi
import com.mvp.dagger.rx.sample.webservice.WebService
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class PhotosRemoteDataSource @Inject constructor() : IPhotosDataSource {

    override fun savePhotos(photos: List<Photo>): Completable = throw UnsupportedOperationException()

    override fun getPhotos(context: Context): Single<List<Photo>> = WebService.createService(context, IApi::class.java).getPhotos()

}