package com.mvp.dagger.rx.sample.photos

import com.mvp.dagger.rx.sample.base.IBasePresenter
import com.mvp.dagger.rx.sample.base.IBaseView
import com.mvp.dagger.rx.sample.data.Photo

interface IPhotosContract {

    interface View: IBaseView {
        fun onPhotosSuccess(photos: List<Photo>?)
        fun onPhotosFailure()
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter: IBasePresenter {
        fun getPhotos()
    }
}