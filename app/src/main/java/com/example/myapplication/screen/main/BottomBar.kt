package com.example.myapplication.screen.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController


data class BottomData(
    val title: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomData("Home", Icons.Default.Home, "home"),
        BottomData("Profile", Icons.Default.Person, "profile")
    )

    NavigationBar {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach {
            item -> NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                       navController.navigate(item.route) {
                           popUpTo("home")
                           launchSingleTop = true
                       }
                },
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }
}
