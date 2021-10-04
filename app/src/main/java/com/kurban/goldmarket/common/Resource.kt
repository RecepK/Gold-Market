package com.kurban.goldmarket.common


sealed class Resource<out R> {
    object Loading : Resource<Nothing>()
    data class Success<T>(val value: T) : Resource<T>()
    data class Error(val error: String) : Resource<Nothing>()
}


sealed class Screen(val name: String) {
    object SplashScreen : Screen("SplashScreen")
    object MainScreen : Screen("MainScreen")
    object DetailScreen : Screen("DetailScreen")
}