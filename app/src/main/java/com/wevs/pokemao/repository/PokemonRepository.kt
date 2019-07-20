package com.wevs.pokemao.repository


interface PokemonRepository{

    fun checkHealth(
        onComplete : () -> Unit,
        onError:(t: Throwable) -> Unit
    )
}