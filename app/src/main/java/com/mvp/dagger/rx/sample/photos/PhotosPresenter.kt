package com.mvp.dagger.rx.sample.photos

import com.mvp.dagger.rx.sample.base.BasePresenter
import com.mvp.dagger.rx.sample.data.Photo
import com.mvp.dagger.rx.sample.data.photos.IPhotosDataSource
import com.mvp.dagger.rx.sample.extensions.addTo
import com.mvp.dagger.rx.sample.extensions.applyIoAndMainThreads
import javax.inject.Inject

class PhotosPresenter @Inject constructor(private val view: IPhotosContract.View,
                                          private val photosRepository: IPhotosDataSource): BasePresenter(), IPhotosContract.Presenter {

    override fun getPhotos() {
        view.showProgress()
        photosRepository.getPhotos(view.getViewContext())
                .applyIoAndMainThreads()
                .subscribe(
                        {onPhotosSuccess(it)},
                        {onPhotosFailure()}
                )
                .addTo(compositeDisposable)
    }

    private fun onPhotosSuccess(photos: List<Photo>) {
        if (view.isActive()) {
            view.hideProgress()
            view.onPhotosSuccess(photos)
        }
    }

    private fun onPhotosFailure() {
        if (view.isActive()) {
            view.hideProgress()
            view.onPhotosFailure()
        }
    }
}