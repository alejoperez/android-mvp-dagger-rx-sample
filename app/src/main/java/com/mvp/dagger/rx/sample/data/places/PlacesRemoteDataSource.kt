package com.mvp.dagger.rx.sample.data.places

import android.content.Context
import com.mvp.dagger.rx.sample.data.Place
import com.mvp.dagger.rx.sample.webservice.IApi
import com.mvp.dagger.rx.sample.webservice.WebService
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class PlacesRemoteDataSource @Inject constructor() : IPlacesDataSource {

    override fun savePlaces(places: List<Place>): Completable = throw UnsupportedOperationException()

    override fun getPlaces(context: Context): Single<List<Place>> = WebService.createService(context, IApi::class.java).getPlaces()

}