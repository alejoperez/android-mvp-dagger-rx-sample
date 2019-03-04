package com.mvp.dagger.rx.sample.places

import com.mvp.dagger.rx.sample.base.IBasePresenter
import com.mvp.dagger.rx.sample.base.IBaseView
import com.mvp.dagger.rx.sample.data.Place

interface IPlacesContract {

    interface View: IBaseView {
        fun onPlacesSuccess(places: List<Place>?)
        fun onPlacesFailure()
    }

    interface Presenter: IBasePresenter {
        fun getPlaces()
    }
}