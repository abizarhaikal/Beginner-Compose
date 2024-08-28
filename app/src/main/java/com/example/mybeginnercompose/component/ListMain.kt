package com.example.mybeginnercompose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.mybeginnercompose.R
import com.example.mybeginnercompose.model.ListPlayer
import com.example.mybeginnercompose.ui.theme.MyBeginnerComposeTheme

@Composable
fun ListMain(modifier: Modifier = Modifier, listPlayer: ListPlayer, onItemClick: (Int) -> Unit) {
    Card(
        modifier = modifier
            .padding(bottom = 8.dp, top = 8.dp)
            .clickable { onItemClick(listPlayer.id) },
        shape = CircleShape,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = modifier.padding(16.dp)
        ) {
            // If using URL, but want to display something in preview

            val painter = rememberImagePainter(data = stringResource(id = listPlayer.photoUrl))
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = modifier.padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = listPlayer.name),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                HorizontalDivider()
                Text(
                    text = stringResource(id = listPlayer.description),
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier
                )
            }
        }
    }
}

@Preview
@Composable
fun ListMainPreview() {
    MyBeginnerComposeTheme {
        ListMain(
            listPlayer = ListPlayer(
                id = 1,
                name = R.string.name1,
                description = R.string.desc1,
                photoUrl = R.string.image1 // This would normally be a URL
            ), onItemClick = { /* Handle item click here */ }
        )
    }
}

// Helper function to check if running in preview mode
@Composable
fun isInPreview(): Boolean {
    return androidx.compose.ui.tooling.preview.PreviewParameterProvider::class.java
        .simpleName == "PreviewParameterProvider"
}
