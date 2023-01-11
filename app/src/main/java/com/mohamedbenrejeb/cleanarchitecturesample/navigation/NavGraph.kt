package com.mohamedbenrejeb.cleanarchitecturesample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mohamedbenrejeb.cleanarchitecturesample.home.ui.HomeScreen
import com.mohamedbenrejeb.cleanarchitecturesample.home.ui.navigation.HomeNavigation
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.PostScreen
import com.mohamedbenrejeb.cleanarchitecturesample.post.ui.navigation.PostNavigation

@Composable
fun NavGraphSetup(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Posts.route
    ) {

        composable(
            route = Screen.Posts.route
        ) {
            HomeScreen(
                onNavigation = { navigation ->
                    when(navigation) {
                        is HomeNavigation.NavigateToPost -> {
                            navController.navigate(
                                "${Screen.Post.route}/${navigation.postId}"
                            )
                        }
                    }
                }
            )
        }

        composable(
            route = "${Screen.Post.route}/{postId}"
        ) {
            PostScreen(
                onNavigation = { navigation ->
                    when(navigation) {
                        is PostNavigation.NavigateBack -> {
                            navController.popBackStack()
                        }
                    }
                }
            )
        }

    }

}