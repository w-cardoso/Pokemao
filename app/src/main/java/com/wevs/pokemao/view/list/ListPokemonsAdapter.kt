package com.wevs.pokemao.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wevs.pokemao.R
import com.wevs.pokemao.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class ListPokemonsAdapter(val pokemons: List<Pokemon>) : RecyclerView.Adapter<ListPokemonsAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bindView(pokemon)
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(pokemon: Pokemon) = with(itemView) {
            tvPokemonName.text = pokemon.name
            tvPokemonNumber.text = pokemon.number
        }
    }
}