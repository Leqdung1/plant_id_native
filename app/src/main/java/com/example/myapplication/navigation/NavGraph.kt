package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screen.home.HomeScreen
import com.example.myapplication.screen.onboarding.OnboardingScreen
import com.example.myapplication.screen.premium.PremiumScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.ONBOARDING
    ) {
        composable(NavRoute.ONBOARDING) {
            OnboardingScreen(
                onFinish = {
                    navController.navigate(NavRoute.HOME) {
                        popUpTo(NavRoute.ONBOARDING) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(NavRoute.HOME) {
            HomeScreen(
                onClose = {
                    navController.navigate(NavRoute.PREMIUM)
                }
            )
        }

        composable(NavRoute.PREMIUM) {
            PremiumScreen()
        }
    }
}
