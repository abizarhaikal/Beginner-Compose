package com.example.mybeginnercompose.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mybeginnercompose.model.Routes
import com.example.mybeginnercompose.ui.theme.MyBeginnerComposeTheme

@Composable
fun BottomBarApp(modifier: Modifier = Modifier, navController: NavController) {
    var selectedItem by remember {
        mutableIntStateOf(0)
    }
    val items = listOf(
        Routes.Home.route to Icons.Filled.Home,
        Routes.Profile.route to Icons.Default.Person
    )
    NavigationBar {
        items.forEach { (route, icon) ->
            val selected = navController.currentBackStackEntry?.destination?.route == route
            NavigationBarItem(selected = selected, onClick = {
                navController.navigate(route) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }, icon = { Icon(imageVector = icon, contentDescription = null) },
                label = { Text(text = route) })
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    MyBeginnerComposeTheme {
        BottomBarApp(navController = navController)
    }
}