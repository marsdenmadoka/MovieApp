package com.madoka.movieshop.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madoka.domain.model.Movie
import com.madoka.movieshop.R
import com.madoka.movieshop.ui.utils.getRating


@Composable
fun MovieRatingSection(
popularity: String?, voteAverage: String?
//movie: Movie
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
                /*
            .placeholder(
                visible = popularity.isNullOrEmpty(),
                color = Gray,
                highlight = PlaceholderHighlight.fade(highlightColor = TextSecondary)
            )*/,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        //region Popularity
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (popularity.isNullOrEmpty()) "N/A" else popularity,//movie.popularity.toString() ,   //"$popularity",
                style = MaterialTheme.typography.h6,
                fontSize = 42.sp,
                color = MaterialTheme.colors.onSurface,


            )

            Text(
                text = "Popularity",
                style = MaterialTheme.typography.h6,
                fontSize = 18.sp,
                color = MaterialTheme.colors.onSurface,
            )
        }
        //endregion

        Divider(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .width(1.dp)
                .fillMaxHeight(1f),
            color = MaterialTheme.colors.onSurface
        )

        //region Rating
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_rating_star),
                contentDescription ="Rating" //stringResource(R.string.rating)
            )

            Text(
                text = if (voteAverage.isNullOrEmpty()) "N/A" else "$voteAverage/5.0",//movie.voteAverage?.getRating()?.toFloat().toString(), ///5.0 "$voteAverage/5.0",
                style = MaterialTheme.typography.h6,
                fontSize = 20.sp,
                color = MaterialTheme.colors.onSurface,
            )
        }
    }
}