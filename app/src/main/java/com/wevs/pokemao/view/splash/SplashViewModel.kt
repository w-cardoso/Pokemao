package com.wevs.pokemao.view.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wevs.pokemao.repository.PokemonRepository

class SplashViewModel(val pokemonRepository: PokemonRepository) : ViewModel() {

    val messageError = MutableLiveData<String>()

    fun checkHealth() {
        pokemonRepository.checkHealth({
            messageError.value = ""
        }, {
            messageError.value = it.message
        })
    }
}