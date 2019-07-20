package com.wevs.pokemao

import android.app.Application
import com.facebook.stetho.Stetho
import com.wevs.pokemao.di.netWorkModule
import com.wevs.pokemao.di.repositoryModule
import com.wevs.pokemao.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    netWorkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}