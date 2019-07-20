package com.wevs.pokemao.view.list

import androidx.lifecycle.ViewModel
import com.wevs.pokemao.repository.PokemonRepository

class ListPokemonsViewModel(val pokemonRepository: PokemonRepository) : ViewModel() {

    fun getPokemons() {
        pokemonRepository.getPokemon(
            "number,asc", 150,
            onComplete = {},
            onError = {}
        )
    }
}