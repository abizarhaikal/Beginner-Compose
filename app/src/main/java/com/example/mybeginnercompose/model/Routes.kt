package com.example.mybeginnercompose.model

import okhttp3.Route

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Detail : Routes("detail")
    object Profile : Routes("profile")
}