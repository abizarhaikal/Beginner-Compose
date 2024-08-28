package com.example.mybeginnercompose.model

import androidx.annotation.StringRes
import com.example.mybeginnercompose.R

data class ListPlayer(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    val photoUrl: Int
)

val dummyPlayer = listOf(
    1 to ListPlayer(
        id = 1,
        name = R.string.name1,
        description = R.string.desc1,
        photoUrl = R.string.image1
    ),
    2 to ListPlayer(
        id = 2,
        name = R.string.name2,
        description = R.string.desc2,
        photoUrl = R.string.image2
    ),
    3 to ListPlayer(
        id = 3,
        name = R.string.name3,
        description = R.string.desc3,
        photoUrl = R.string.image3
    ),
    4 to ListPlayer(
        id = 4,
        name = R.string.name4,
        description = R.string.desc4,
        photoUrl = R.string.image4
    ),
    5 to ListPlayer(
        id = 5,
        name = R.string.name5,
        description = R.string.desc5,
        photoUrl = R.string.image5
    ),
    6 to ListPlayer(
        id = 6,
        name = R.string.name6,
        description = R.string.desc6,
        photoUrl = R.string.image6
    ),
    7 to ListPlayer(
        id = 7,
        name = R.string.name7,
        description = R.string.desc7,
        photoUrl = R.string.image7
    ),
    8 to ListPlayer(
        id = 8,
        name = R.string.name8,
        description = R.string.desc8,
        photoUrl = R.string.image8
    ),
    9 to ListPlayer(
        id = 9,
        name = R.string.name9,
        description = R.string.desc9,
        photoUrl = R.string.image9
    ),
    9 to ListPlayer(
        id = 10,
        name = R.string.name10,
        description = R.string.desc10,
        photoUrl = R.string.image10
    ),
)