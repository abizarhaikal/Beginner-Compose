package com.example.mybeginnercompose.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mybeginnercompose.component.BottomBarApp
import com.example.mybeginnercompose.component.ListMain
import com.example.mybeginnercompose.component.TopAppBar
import com.example.mybeginnercompose.model.AppNavHost
import com.example.mybeginnercompose.model.Routes
import com.example.mybeginnercompose.model.dummyPlayer
import com.example.mybeginnercompose.ui.theme.MyBeginnerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBeginnerComposeTheme {
                val navController = rememberNavController()
                Surface {
                    AppNavHost(navController = navController)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = "My Beginner Compose",
                navController = navController
            )
        },
        bottomBar = { BottomBarApp(navController = navController) }
    ) { innerPadding ->
        LazyColumn(modifier = modifier.padding(innerPadding)) {
            items(dummyPlayer) { player ->
                ListMain(
                    listPlayer = player.second,
                    onItemClick = {
                        // Navigate to the detail screen with the player ID
                        navController.navigate("${Routes.Detail.route}/${player.first}")
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyBeginnerComposeTheme {
        val navController = rememberNavController()
        MainScreen(navController = navController)
    }
}
