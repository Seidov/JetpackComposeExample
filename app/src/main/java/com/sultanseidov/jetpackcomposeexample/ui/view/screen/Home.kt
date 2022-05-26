package com.sultanseidov.jetpackcomposeexample.ui.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sultanseidov.jetpackcomposeexample.R
import com.sultanseidov.jetpackcomposeexample.model.Genres
import com.sultanseidov.jetpackcomposeexample.ui.theme.*
import com.sultanseidov.jetpackcomposeexample.ui.view.screen.CommonUiComponents


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {


    val commonUi = CommonUiComponents()
    Box(
        modifier = Modifier
            .background(DeepBlue2)
            .fillMaxSize()
    ) {
        Column {

            CurrentDiscoverWeekly()

            commonUi.AlertDialogSample()
            commonUi.ExtendedFloatingActionButtonDemo()

            ChipSection(chips = listOf("Deep House", "Melodic Techno", "Chill Out"))

            GenresSection(
                genres = listOf(
                    Genres(
                        title = "Melodic Techno",
                        R.drawable.ic_headphone,
                        BlueViolet1

                    ),
                    Genres(
                        title = "Downtempo",
                        R.drawable.ic_videocam,
                        LightGreen1
                    ),
                    Genres(
                        title = "Deep House",
                        R.drawable.ic_headphone,
                        OrangeYellow1
                    ),
                    Genres(
                        title = "Deep Tech",
                        R.drawable.ic_headphone,
                        Beige1
                    )
                )
            )
        }
    }
}


@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentDiscoverWeekly(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Discover Weekly",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Melodic Techno • 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun GenresSection(genres: List<Genres>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Genres",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(genres.size) {
                GenresItem(genres = genres[it])
            }
        }
    }
}

@Composable
fun GenresItem(
    genres: Genres
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(genres.lightColor)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = genres.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = genres.iconId),
                contentDescription = genres.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}
