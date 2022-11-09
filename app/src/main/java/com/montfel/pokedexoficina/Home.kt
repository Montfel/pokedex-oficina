package com.montfel.pokedexoficina

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    val viewModel = viewModel<HomeViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn {
        item {
            Text(
                text = "Pokédex",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        itemsIndexed(uiState.pokemonList) { index, pokemon ->
            PokemonCard(
                id = index,
                pokemon = pokemon,
                onClick = { dominantColor ->
                    navController.navigate("details/${index + 1}/${dominantColor.toArgb()}")
                },
                viewModel = viewModel
            )
        }
    }
}
