package com.mvp.dagger.rx.sample.places

import com.mvp.dagger.rx.sample.R
import com.mvp.dagger.rx.sample.data.Place
import com.mvp.dagger.rx.sample.data.places.IPlacesDataSource
import com.mvp.dagger.rx.sample.data.places.PlacesRepository
import javax.inject.Inject

class PlacesPresenter @Inject constructor(private val view: IPlacesContract.View,
                                          private val placesRepository: IPlacesDataSource): IPlacesContract.Presenter, PlacesRepository.IPlacesListener {


    override fun getPlaces() {
        placesRepository.getPlaces(view.getViewContext(), this)
    }

    override fun onPlacesSuccess(places: List<Place>?) {
        if (view.isActive()) {
            view.onPlacesSuccess(places)
        }
    }

    override fun onPlacesFailure() {
        if (view.isActive()) {
            view.onPlacesFailure()
        }
    }

    override fun onNetworkError() {
        if (view.isActive()) {
            view.showAlert(R.string.error_network)
        }
    }
}