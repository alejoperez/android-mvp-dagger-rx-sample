package com.mvp.dagger.rx.sample.data.places

import android.content.Context
import com.mvp.dagger.rx.sample.data.Place
import io.reactivex.Completable
import io.reactivex.Single

interface IPlacesDataSource {

    fun getPlaces(context: Context): Single<List<Place>>

    fun savePlaces(places: List<Place>): Completable
}