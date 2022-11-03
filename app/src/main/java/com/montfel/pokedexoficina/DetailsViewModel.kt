package com.montfel.pokedexoficina

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.pokedexoficina.Retrofit.retrofit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DetailsUiState(
    val pokemon: PokemonDetailsDto? = null
)

class DetailsViewModel : ViewModel() {

    private val dataSource: DataSource = retrofit.create(DataSource::class.java)

    private val _uiState = MutableStateFlow(DetailsUiState())
    val uiState: StateFlow<DetailsUiState> = _uiState

    fun fetchPokemonDetails(pokemonId: String) {
        viewModelScope.launch {
            val pokemon = dataSource.getPokemonDetails(pokemonId = pokemonId)
            _uiState.update { it.copy(pokemon = pokemon) }
        }
    }
}
