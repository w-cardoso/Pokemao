package com.wevs.pokemao.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val number: String,
    val name: String,
    var ps: Int,
    var attack: Int,
    var defense: Int,
    var velocity: Int,
    val generation: Int,
    val imageURL: String
) : Parcelable
