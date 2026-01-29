package com.example.myapplication.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.navigation.NavRoute
import com.example.myapplication.screen.home.HomeScreen
import com.example.myapplication.screen.profile.ProfileScreen

@Composable
fun MainNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoute.HOME
    ) {
        composable(NavRoute.HOME) {
            HomeScreen(
                onClose = {
                    navController.navigate(NavRoute.PROFILE)
                }
            )
        }
        composable(NavRoute.PROFILE) {
            ProfileScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}
