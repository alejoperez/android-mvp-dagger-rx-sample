package com.mvp.dagger.rx.sample.data.places

import android.content.Context
import com.mvp.dagger.rx.sample.data.Place
import io.realm.Realm
import javax.inject.Inject

class PlacesLocalDataSource @Inject constructor(): IPlacesDataSource {

    override fun savePlaces(places: List<Place>) {
        Realm.getDefaultInstance().executeTransactionAsync {
            realm -> realm.insertOrUpdate(places)
        }
    }

    override fun getPlaces(context: Context, listener: PlacesRepository.IPlacesListener) {
        listener.onPlacesSuccess(Realm.getDefaultInstance().where(Place::class.java).findAll())
    }

}