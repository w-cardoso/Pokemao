package com.wevs.pokemao.api

import com.wevs.pokemao.model.HealthResponse
import com.wevs.pokemao.model.Pokemon
import com.wevs.pokemao.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface PokemonService {
    @GET("/api/pokemon/health")
    fun checkHealth(): Call<HealthResponse>

    @GET("/api/pokemon")
    fun getPokemons(
        @Query("sort") sort: String,
        @Query("size") size: Int
    ): Call<PokemonResponse>

    @PUT("/api/pokemon")
    fun updatePokemon(
        @Body pokemon: Pokemon
    ): Call<Pokemon>



}