package com.mohamedbenrejeb.cleanarchitecturesample.home.ui.navigation

sealed class HomeNavigation {
    data class NavigateToPost(
        val postId: String
    ): HomeNavigation()
}
