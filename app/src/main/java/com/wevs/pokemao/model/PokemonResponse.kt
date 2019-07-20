package com.wevs.pokemao.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    @SerializedName("content")
    val pokemons: List<Pokemon>
)
