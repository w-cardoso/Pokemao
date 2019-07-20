package com.wevs.pokemao.di

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.picasso.Downloader
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.wevs.pokemao.api.PokemonService
import com.wevs.pokemao.api.interceptor.AuthInterceptor
import com.wevs.pokemao.repository.PokemonRepository
import com.wevs.pokemao.repository.PokemonRepositoryImpl
import com.wevs.pokemao.view.form.FormPokemonViewModel
import com.wevs.pokemao.view.list.ListPokemonsViewModel
import com.wevs.pokemao.view.splash.SplashViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netWorkModule = module {
    single<Interceptor> { AuthInterceptor() }
    single { createOkhttpClientAuth(get()) }
    single { createNetworkClient(get()).create(PokemonService::class.java) }
    single { createPicassoAuth(get(), get()) }
}

val repositoryModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { ListPokemonsViewModel(get()) }
    viewModel { FormPokemonViewModel(get()) }

}

private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://pokedexdx.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun createOkhttpClientAuth(authInterceptor: Interceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addNetworkInterceptor(StethoInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
    return builder.build()
}

private fun createPicassoAuth(context: Context, okHttpClient: OkHttpClient): Picasso {
    return Picasso
        .Builder(context)
        .downloader(OkHttp3Downloader(okHttpClient) as Downloader)
        .build()
}