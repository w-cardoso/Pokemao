package com.wevs.pokemao.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wevs.pokemao.model.Pokemon
import com.wevs.pokemao.repository.PokemonRepository

class ListPokemonsViewModel(val pokemonRepository: PokemonRepository) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val pokemons = MutableLiveData<List<Pokemon>>()
    val messageError = MutableLiveData<String>()

    fun getPokemons() {
        isLoading.value = true
        pokemonRepository.getPokemon(
            "number,asc", 150,
            onComplete = {
                isLoading.value = false
                pokemons.value = it
                messageError.value = ""

            },
            onError = {
                isLoading.value = false
                pokemons.value = listOf()
                messageError.value = it.message


            }
        )
    }
}