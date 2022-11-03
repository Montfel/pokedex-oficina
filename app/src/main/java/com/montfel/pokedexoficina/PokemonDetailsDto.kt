package com.montfel.pokedexoficina

import com.google.gson.annotations.SerializedName

data class PokemonDetailsDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("types")
    val types: List<TypesDto>
)

data class TypesDto(
    @SerializedName("slot")
    val slot: Int,

    @SerializedName("type")
    val type: TypeDto
)

data class TypeDto(
    @SerializedName("name")
    val name: String
)
