package com.wevs.pokemao.view.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wevs.pokemao.model.Pokemon
import com.wevs.pokemao.repository.PokemonRepository

class FormPokemonViewModel(val pokemonRepository: PokemonRepository) : ViewModel() {


    val isLoading = MutableLiveData<Boolean>()
    val messageResponse = MutableLiveData<String>()

    fun updatePokemon(pokemon: Pokemon) {
        pokemonRepository.updatePokemon(
            pokemon,
            {
                isLoading.value = false
                messageResponse.value = "Dados atualizados com sucesso"
            },
            {
                isLoading.value = false
                messageResponse.value = it.message
            }
        )
    }

}