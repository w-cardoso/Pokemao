package com.wevs.pokemao.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wevs.pokemao.R
import com.wevs.pokemao.view.list.ListPokemonsActivity
import com.wevs.pokemao.view.scan.ScanActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPokedex.setOnClickListener {
            startActivity<ScanActivity>()
        }

        btPokemonList.setOnClickListener {
            startActivity<ListPokemonsActivity>()
        }

        btClose.setOnClickListener {
            finish()
        }
    }
}
