package com.mvp.dagger.rx.sample.di

import android.app.Application
import com.mvp.dagger.rx.sample.application.SampleApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            RepositoriesModule::class,
            ViewsModule::class,
            AndroidSupportInjectionModule::class
        ]
)
interface AppComponent: AndroidInjector<SampleApp> {

    fun inject(app: Application)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent

    }
}