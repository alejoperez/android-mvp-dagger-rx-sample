package com.mvp.dagger.rx.sample.data.photos

import android.content.Context
import com.mvp.dagger.rx.sample.data.IBaseSourceListener
import com.mvp.dagger.rx.sample.data.Photo
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class PhotosRepository
@Inject
constructor(@Named(IBaseSourceListener.LOCAL) private val localDataSource: IPhotosDataSource,
            @Named(IBaseSourceListener.REMOTE) private val  remoteDataSource: IPhotosDataSource) : IPhotosDataSource {

    private var hasCache = false

    override fun getPhotos(context: Context): Single<List<Photo>> {
        return if (hasCache) {
            localDataSource.getPhotos(context)
        } else {
            remoteDataSource.getPhotos(context)
                    .doOnSuccess {
                        savePhotos(it)
                    }
        }
    }

    override fun savePhotos(photos: List<Photo>): Completable = localDataSource.savePhotos(photos)

    fun invalidateCache() {
        hasCache = false
    }
}