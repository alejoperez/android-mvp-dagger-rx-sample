package com.mvp.dagger.rx.sample.data.places

import android.content.Context
import com.mvp.dagger.rx.sample.data.IBaseSourceListener
import com.mvp.dagger.rx.sample.data.Place
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class PlacesRepository
@Inject
constructor(@Named(IBaseSourceListener.LOCAL) private val localDataSource: IPlacesDataSource,
            @Named(IBaseSourceListener.REMOTE) private val remoteDataSource: IPlacesDataSource) : IPlacesDataSource {


    private var hasCache = false

    override fun getPlaces(context: Context): Single<List<Place>> {
        return if (hasCache) {
            localDataSource.getPlaces(context)
        } else {
            remoteDataSource.getPlaces(context).doOnSuccess {
                savePlaces(it)
            }
        }
    }

    override fun savePlaces(places: List<Place>): Completable = localDataSource.savePlaces(places)

    fun invalidateCache() {
        hasCache = false
    }
}