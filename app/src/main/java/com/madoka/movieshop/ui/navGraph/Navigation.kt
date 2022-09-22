package com.madoka.movieshop.ui.navGraph

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.madoka.movieshop.ui.screens.details.detailsScreen
import com.madoka.movieshop.ui.screens.home.HomeScreen



@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavigationGraph() {

    val navController = rememberAnimatedNavController()
    NavHost(navController = navController, startDestination = NavItem.Home.route ){

        composable(route=NavItem.Home.route){
           HomeScreen(navController = navController)
        }

        composable(route=NavItem.Details.route){
            detailsScreen(navController = navController)
           // navController.popBackStack()
        }
        /*
       composable(
           route = NavItem.Details.route,
           arguments = listOf(
               navArgument("movieId"){
                   type = NavType.IntType
               }
           )

       ){
           val movieID = it.arguments?.getInt("movieId")
           if (movieID !=null){
             //  detailsScreen(navController = navController, movieId = movieID)
           } */

       }
    }
