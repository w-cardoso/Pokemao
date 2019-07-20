package com.wevs.pokemao.api

import com.wevs.pokemao.model.HealthResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET("/api/pokemon/health")
    fun checkHealth(): Call<HealthResponse>
}