package com.montfel.pokedexoficina

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.montfel.pokedexoficina.Retrofit.retrofit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeUiState(
    val pokemonList: List<PokemonDto> = emptyList()
)

class HomeViewModel : ViewModel() {

    private val dataSource: DataSource = retrofit.create(DataSource::class.java)

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            val pokemons = dataSource.getPokemons()
            _uiState.update { it.copy(pokemonList = pokemons.results) }
        }
    }
}
