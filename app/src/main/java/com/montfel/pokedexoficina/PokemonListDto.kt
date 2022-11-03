package com.montfel.pokedexoficina

import com.google.gson.annotations.SerializedName

data class PokemonListDto(
    @SerializedName("results")
    val results: List<PokemonDto>
)

data class PokemonDto(
    @SerializedName("name")
    val name: String
)
