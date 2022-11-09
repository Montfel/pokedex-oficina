package com.montfel.pokedexoficina

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            Home(navController = navController)
        }

        composable(
            route = "details/{pokemonId}/{dominantColor}",
            arguments = listOf(
                navArgument("pokemonId") {
                    type = NavType.StringType
                },
                navArgument("dominantColor") {
                    type = NavType.IntType
                }
            )
        ) {
            val dominantColor = remember {
                val color = it.arguments?.getInt("dominantColor")
                color?.let { Color(it) } ?: Color.LightGray
            }
            val pokemonId = remember {
                it.arguments?.getString("pokemonId")
            }
            Details(
                pokemonId = pokemonId ?: "",
                dominantColor = dominantColor
            )
        }
    }
}
