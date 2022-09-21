package com.madoka.movieshop.ui.navGraph

sealed class NavItem(
    val route: String
    ) {
    object Home : NavItem("home")
    object Details : NavItem("details/{movieId}")
}

//sealed class NavigationItem(
//
//    @StringRes val title: Int,
//    @DrawableRes val icon: Int?
//) {
//
//    object Home : NavigationItem("home", R.string.title_home, R.drawable.ic_home)
//    object Favorites : NavigationItem("favorites", R.string.title_favorites, R.drawable.ic_favourite)
//    object Settings : NavigationItem("settings", R.string.title_settings, R.drawable.ic_settings)
//    object Details : NavigationItem("details/{movieId}/{cacheId}", R.string.title_details, null)
//}