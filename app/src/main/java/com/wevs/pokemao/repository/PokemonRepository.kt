package com.wevs.pokemao.repository

import com.wevs.pokemao.model.Pokemon


interface PokemonRepository{

    fun checkHealth(
        onComplete : () -> Unit,
        onError:(t: Throwable) -> Unit
    )

    fun getPokemon(
        sort: String,
        size: Int,
        onComplete : (List<Pokemon>) -> Unit,
        onError:(t: Throwable) -> Unit
    )
}