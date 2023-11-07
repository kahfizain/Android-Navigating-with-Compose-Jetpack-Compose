package com.kaza.navigation.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kaza.navigation.feature.user_input.UserInputScreen
import com.kaza.navigation.feature.user_input.data.UserInputViewModel
import com.kaza.navigation.feature.welcome.WelcomeScreen

@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {

        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(userInputViewModel, showWelcomeScreen = { it ->
                val userName = it.first
                val animal = it.second
                val route = "${Routes.WELCOME_SCREEN}/${userName}/${animal}"
                navController.navigate(route)
            })
        }

        composable(
            route = "${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.ANIMAL_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME) { type = NavType.StringType },
                navArgument(name = Routes.ANIMAL_SELECTED) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString(Routes.USER_NAME)
            val animalSelected = backStackEntry.arguments?.getString(Routes.ANIMAL_SELECTED)

            WelcomeScreen(userName, animalSelected)
        }
    }
}
