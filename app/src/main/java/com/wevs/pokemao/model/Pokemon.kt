package com.wevs.pokemao.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("number")
    @Expose
    val number: String,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("ps")
    @Expose
    val ps: Int,

    @SerializedName("attack")
    @Expose
    val attack: Int,

    @SerializedName("defense")
    @Expose
    val defense: Int,

    @SerializedName("velocity")
    @Expose
    val velocity: Int,

    @SerializedName("generation")
    @Expose
    val generation: Int,

    @SerializedName("imageURL")
    @Expose
    val imageURL: String
)
