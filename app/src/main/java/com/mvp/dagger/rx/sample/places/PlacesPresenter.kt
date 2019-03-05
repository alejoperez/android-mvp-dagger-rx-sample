package com.mvp.dagger.rx.sample.places

import com.mvp.dagger.rx.sample.base.BasePresenter
import com.mvp.dagger.rx.sample.data.Place
import com.mvp.dagger.rx.sample.data.places.IPlacesDataSource
import com.mvp.dagger.rx.sample.extensions.addTo
import com.mvp.dagger.rx.sample.extensions.applyIoAndMainThreads
import javax.inject.Inject

class PlacesPresenter @Inject constructor(private val view: IPlacesContract.View,
                                          private val placesRepository: IPlacesDataSource) : BasePresenter(), IPlacesContract.Presenter {


    override fun getPlaces() {
        placesRepository.getPlaces(view.getViewContext())
                .applyIoAndMainThreads()
                .subscribe(
                        {
                            onPlacesSuccess(it)
                        },
                        {
                            onPlacesFailure()
                        }
                )
                .addTo(compositeDisposable)
    }

    private fun onPlacesSuccess(places: List<Place>) {
        if (view.isActive()) {
            view.onPlacesSuccess(places)
        }
    }

    private fun onPlacesFailure() {
        if (view.isActive()) {
            view.onPlacesFailure()
        }
    }
}