package com.example.mybeginnercompose.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mybeginnercompose.R
import com.example.mybeginnercompose.component.BottomBarApp
import com.example.mybeginnercompose.component.TopAppBar
import com.example.mybeginnercompose.ui.theme.MyBeginnerComposeTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = "Prfile Section",
                navController = navController
            )
        },
        bottomBar = {
            BottomBarApp(navController = navController)
        }
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.fotoo),
                contentDescription = null,
                modifier = modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Text(text = "Haikal Abizar")
            Spacer(modifier = modifier.size(16.dp))
            HorizontalDivider(
                modifier = modifier.padding(horizontal = 32.dp),
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.clickable {
                        showGithub(context)
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = null,
                        Modifier
                            .background(Color.White)
                            .size(40.dp)
                    )
                    Text(text = "Abizarhaikal")
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.clickable {
                        showMail(context, "abizarhaikal@gmail.com")
                    }
                ) {
                    Image(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        Modifier
                            .background(Color.White)
                            .size(40.dp),
                        colorFilter = ColorFilter.tint(Color.Red, BlendMode.SrcAtop),
                    )
                    Text(text = "abizarhaikal@gmail.com")
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.padding(start = 4.dp).clickable {
                        showInstagram(context)
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.instagram),
                        contentDescription = null,
                        Modifier
                            .background(Color.White)
                            .size(30.dp)
                    )
                    Text(text = "Abizarhaikal")
                }
            }
        }
    }
}

fun showInstagram(context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/abizarhaikal/"))
    context.startActivity(intent)

}

@SuppressLint("QueryPermissionsNeeded")
fun showMail(context: Context, emailAddress: String) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto: $emailAddress")
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}

fun showGithub(context : Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Abizarhaikal"))
    context.startActivity(intent)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    MyBeginnerComposeTheme {
        ProfileScreen(modifier = Modifier, navController)
    }
}