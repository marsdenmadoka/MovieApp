package com.madoka.movieshop.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import com.madoka.movieshop.R
import com.madoka.movieshop.ui.theme.MovieShopTheme
import com.madoka.movieshop.ui.theme.TextSecondary




@Composable
fun MovieRatingSection(
popularity: String?, voteAverage: String?
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .placeholder(
                visible = popularity.isNullOrEmpty(),
                color = Gray,
                highlight = PlaceholderHighlight.fade(highlightColor = TextSecondary)
            ),
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
                text = if (popularity.isNullOrEmpty()) "N/A" else popularity,
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
            color = Black //MaterialTheme.colors.onSurface
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

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsTopBarPreview() {
    MovieShopTheme {
        MovieRatingSection("po","2.5")
    }
}



//Composable functions with non-default parameters are not supported in Preview unless they are annotated with @PreviewParameter