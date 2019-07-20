package com.wevs.pokemao.view.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wevs.pokemao.R
import org.koin.android.viewmodel.ext.android.viewModel

class ListPokemonsActivity : AppCompatActivity() {

    val listPokemonsViewModel: ListPokemonsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokemons)

        listPokemonsViewModel.getPokemons()
    }
}

