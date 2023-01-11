package com.mohamedbenrejeb.cleanarchitecturesample.navigation

sealed class Screen(val route: String) {
    object Posts: Screen("posts")
    object Post: Screen("post")
}
