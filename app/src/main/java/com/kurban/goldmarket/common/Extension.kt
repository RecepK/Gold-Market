package com.kurban.goldmarket.common

import androidx.navigation.NavController


fun NavController.navigate(screen: Screen, popBackStack: Boolean = true) {
    if (popBackStack) popBackStack()
    navigate(route = screen.name)
}
