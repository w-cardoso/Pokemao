package com.wevs.pokemao.view.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
import com.wevs.pokemao.R
import com.wevs.pokemao.view.form.FormPokemonActivity
import kotlinx.android.synthetic.main.activity_list_pokemons.*
import kotlinx.android.synthetic.main.include_loading.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListPokemonsActivity : AppCompatActivity() {

    private val listPokemonsViewModel: ListPokemonsViewModel by viewModel()
    private val picasso: Picasso by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokemons)


        listPokemonsViewModel.isLoading.observe(this, Observer {
            if (it == true) {
                containerLoading.visibility = View.VISIBLE
            } else {
                containerLoading.visibility = View.GONE
            }
        })

        listPokemonsViewModel.messageError.observe(this, Observer {
            if (it != "") {
                toast(it)
            }
        })

        listPokemonsViewModel.pokemons.observe(this, Observer {
            rvPokemons.adapter = ListPokemonsAdapter(it, picasso) {
                val intent = Intent(this, FormPokemonActivity::class.java)
                intent.putExtra("POKEMON", it)
                startActivity(intent)
            }
            rvPokemons.layoutManager = GridLayoutManager(this, 3)
        })
    }

    override fun onResume() {
        super.onResume()
        listPokemonsViewModel.getPokemons()
    }
}

