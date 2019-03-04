package com.mvp.dagger.rx.sample.data.photos

import android.content.Context
import android.content.res.Resources
import com.mvp.dagger.rx.sample.data.Photo
import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm
import javax.inject.Inject

class PhotosLocalDataSource @Inject constructor(): IPhotosDataSource {

    override fun savePhotos(photos: List<Photo>): Completable = Completable.create {
        Realm.getDefaultInstance().executeTransactionAsync(
                { it.insertOrUpdate(photos) },
                { it.onComplete() },
                { error -> it.onError(error) }
        )
    }


    override fun getPhotos(context: Context): Single<List<Photo>> = Single.create<List<Photo>> {
        val photos = Realm.getDefaultInstance().where(Photo::class.java).findAll()
        if (photos != null) {
            it.onSuccess(photos)
        } else {
            it.onError(Resources.NotFoundException("Photos not found"))
        }

    }

}