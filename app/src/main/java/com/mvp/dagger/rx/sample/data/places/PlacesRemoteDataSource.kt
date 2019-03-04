package com.mvp.dagger.rx.sample.data.places

import android.content.Context
import com.mvp.dagger.rx.sample.data.Place
import com.mvp.dagger.rx.sample.webservice.IApi
import com.mvp.dagger.rx.sample.extensions.enqueue
import com.mvp.dagger.rx.sample.webservice.WebService
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class PlacesRemoteDataSource @Inject constructor() : IPlacesDataSource {

    override fun savePlaces(places: List<Place>) = throw UnsupportedOperationException()

    override fun getPlaces(context: Context, listener: PlacesRepository.IPlacesListener) {
        val service = WebService.createService(context, IApi::class.java)
        val call = service.getPlaces()
        call.enqueue(
                { response ->
                    if (response.isSuccessful) {
                        listener.onPlacesSuccess(response.body())

                    } else {
                        listener.onPlacesFailure()
                    }
                },
                {
                    listener.onNetworkError()
                }
        )
    }

}