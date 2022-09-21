package com.madoka.movieshop.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.madoka.movieshop.FakeTopSectionItems
import com.madoka.movieshop.R
import com.madoka.movieshop.ui.components.TopPlayingNowSectionItem
import com.madoka.movieshop.ui.theme.DeepBlue


@Composable
fun HomeScreen() {

    val scrollState = rememberScrollState()
    Surface(
        //picks the color depending on  light mode or dark mode
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopSectionPlayingNow(
                faketopitems = listOf(
                    FakeTopSectionItems(
                        title = "movie 1",
                        R.drawable.drawable1
                    ),
                    FakeTopSectionItems(
                        title = "movie 2",
                        R.drawable.ic_videocam
                    ),

                    )
            )

        }
    }

}


@OptIn(ExperimentalPagerApi::class)
@Composable
private fun TopSectionPlayingNow(
    faketopitems: List<FakeTopSectionItems>
) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp),
        /**          .placeholder(
        visible = false,
        color = Color.Gray,
        highlight = PlaceholderHighlight.shimmer(highlightColor = Color.White)
        ),**/
        count = if (faketopitems.size >= 5) 5 else faketopitems.size,
        state = pagerState
    ) { page ->
        TopPlayingNowSectionItem(
            modifier = Modifier
                .fillMaxSize(),
            faketopitem = faketopitems[page]
        ) {
            /** val items = faketopitems[page]
            navController.navigate("details/${movie.id!!}/${movie.cacheId!!}") */
        }
    }

    Spacer(modifier = Modifier.height(6.dp))

    HorizontalPagerIndicator(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(0.15f),
        pagerState = pagerState,
        indicatorHeight = 6.dp,
        indicatorWidth = 6.dp,
        spacing = 6.dp,
        activeColor = DeepBlue,
        inactiveColor = Gray
    )

}



