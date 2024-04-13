package com.madoka.movieshop.navGraph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.madoka.movieshop.screens.details.detailsScreen
import com.madoka.movieshop.screens.home.HomeScreen



@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavigationGraph() {

    val navController = rememberAnimatedNavController()
    NavHost(navController = navController, startDestination = NavItem.Home.route ) {

        composable(route = NavItem.Home.route) {
            HomeScreen(navController = navController)
        }

//        composable(route=NavItem.Details.route){
//            detailsScreen(navController = navController)
//        }

        composable(
            route = NavItem.Details.route,
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.IntType
                }
            )

        ) {
            val movieID = it.arguments?.getInt("movieId")
            if (movieID != null) {
                 detailsScreen(navController = navController, movieId = movieID)
            }

        }
    }
}
