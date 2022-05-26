package com.sultanseidov.jetpackcomposeexample.ui.view.bottomNav


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sultanseidov.jetpackcomposeexample.ui.view.HomeScreen
import com.sultanseidov.jetpackcomposeexample.ui.view.ProfileScreen
import com.sultanseidov.jetpackcomposeexample.ui.view.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}