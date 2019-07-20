package com.wevs.pokemao.repository

import com.wevs.pokemao.api.PokemonService
import com.wevs.pokemao.model.HealthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl(val pokemonService: PokemonService) : PokemonRepository {

    override fun checkHealth(onComplete: () -> Unit, onError: (t: Throwable) -> Unit) {
        pokemonService
            .checkHealth()
            .enqueue(object  : Callback<HealthResponse>{
                override fun onFailure(call: Call<HealthResponse>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<HealthResponse>, response: Response<HealthResponse>) {
                    if (response.isSuccessful){
                        onComplete()
                    }else{
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }
}