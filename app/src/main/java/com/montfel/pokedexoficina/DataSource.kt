package com.montfel.pokedexoficina

import retrofit2.http.GET
import retrofit2.http.Path

interface DataSource {
    @GET("pokemon?limit=151")
    suspend fun getPokemons(): PokemonListDto

    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonDetails(
        @Path(value = "pokemonId") pokemonId: String
    ): PokemonDetailsDto
}
