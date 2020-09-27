package com.yogasolo.test.core

import android.app.Application
import com.yogasolo.test.BuildConfig
import com.yogasolo.test.core.di.dataSourceModule
import com.yogasolo.test.core.di.networkModule
import com.yogasolo.test.core.di.repositoryModule
import com.yogasolo.test.core.di.serviceModule
import com.yogasolo.test.postures.di.posturesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            if (BuildConfig.DEBUG) androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    serviceModule,
                    dataSourceModule,
                    posturesModule,
                    repositoryModule
                )
            )
        }
    }
}