package com.example.mybeginnercompose.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.mybeginnercompose.R
import com.example.mybeginnercompose.component.TopAppBar
import com.example.mybeginnercompose.model.ListPlayer
import com.example.mybeginnercompose.model.dummyPlayer
import com.example.mybeginnercompose.ui.theme.MyBeginnerComposeTheme

@Composable
fun DetailScreen(playerId: Int, navController: NavController) {
    val player = dummyPlayer.find { it.second.id == playerId }
    if (player != null) {
        DetailView(modifier = Modifier, listPlayer = player.second, navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(
    modifier: Modifier = Modifier,
    listPlayer: ListPlayer,
    navController: NavController
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = stringResource(id = listPlayer.name),
                navController = navController
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            val painter = rememberImagePainter(data = stringResource(id = listPlayer.photoUrl))
            Box(
                modifier = modifier
                    .padding(16.dp)
                    .shadow(8.dp)
                    .background(Color.White)
            ) {
                Image(
                    painter = painter,
                    contentDescription = stringResource(id = listPlayer.name),
                    modifier = modifier.size(400.dp)
                )
            }
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(text = "Player Name", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = listPlayer.name))
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(text = "Description", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = listPlayer.description))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailView() {
    val navController = rememberNavController()
    DetailView(
        listPlayer = ListPlayer(
            id = 1,
            name = R.string.name1,
            description = R.string.desc1,
            photoUrl = R.string.image1
        ),
        navController = rememberNavController()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    MyBeginnerComposeTheme {
        val navController = rememberNavController()
        DetailScreen(playerId = 1, navController)
    }
}

// Helper function to check if running in preview mode
@Composable
fun isInPreview(): Boolean {
    return androidx.compose.ui.tooling.preview.PreviewParameterProvider::class.java
        .simpleName == "PreviewParameterProvider"
}
