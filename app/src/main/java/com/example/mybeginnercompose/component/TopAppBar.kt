package com.example.mybeginnercompose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mybeginnercompose.R
import com.example.mybeginnercompose.model.Routes
import com.example.mybeginnercompose.ui.theme.MyBeginnerComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    title: String,
    navController: NavController
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title =
        {
            Text(text = title)
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logoo),
                contentDescription = null,
                modifier = modifier
                    .size(60.dp)
                    .clickable {
                        // Navigate to the home screen
                        navController.navigate(Routes.Home.route) {
                            popUpTo(Routes.Home.route) { inclusive = true}
                        }
                    }
            )
        },
        actions = {
            IconButton(onClick = {
//                navController.navigate(Routes.Profile.route) {
//                    popUpTo(Routes.Home.route) { inclusive = true}
//                }
            }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = null)
            }
        },
        scrollBehavior = scrollBehavior
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopAppBarPreview() {
    MyBeginnerComposeTheme {
        val navController = rememberNavController()
        TopAppBar(
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
            title = "My Beginner Compose",
            navController = navController
        )
    }
}