package com.montfel.pokedexoficina

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Home(navController = navController)
        }

        composable("details/{pokemonId}") {
            Details(pokemonId = it.arguments?.getString("pokemonId") ?: "")
        }
    }
}
