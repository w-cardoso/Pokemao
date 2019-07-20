package com.wevs.pokemao.repository

import com.wevs.pokemao.api.PokemonService
import com.wevs.pokemao.model.HealthResponse
import com.wevs.pokemao.model.Pokemon
import com.wevs.pokemao.model.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl(private val pokemonService: PokemonService) : PokemonRepository {

    override fun getPokemon(
        sort: String,
        size: Int,
        onComplete: (List<Pokemon>) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        pokemonService
            .getPokemons(sort, size)
            .enqueue(object : Callback<PokemonResponse> {
                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                    if (response.isSuccessful) {
                        onComplete(response.body()?.pokemons ?: listOf())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }

                }
            })

    }

    override fun checkHealth(onComplete: () -> Unit, onError: (t: Throwable) -> Unit) {
        pokemonService
            .checkHealth()
            .enqueue(object : Callback<HealthResponse> {
                override fun onFailure(call: Call<HealthResponse>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<HealthResponse>, response: Response<HealthResponse>) {
                    if (response.isSuccessful) {
                        onComplete()
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }
}