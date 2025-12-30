package com.example.myapplication.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.screen.home.HomeScreen

@Composable
fun MainNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = "HOME"
    ) {
        composable("HOME") {
            HomeScreen()
        }
        composable("PROFILE") {

        }

    }
}