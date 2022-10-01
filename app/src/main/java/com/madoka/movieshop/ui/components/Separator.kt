package com.madoka.movieshop.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.madoka.movieshop.ui.theme.DarkPrimaryColor

@Composable
fun Separator(modifier: Modifier = Modifier, sectionTitle: String, onItemClick: () -> Unit) {
    Row(
        modifier = modifier.clickable { onItemClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = sectionTitle,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h6,
            fontSize = 20.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
                  text ="View All",
                  color = DarkPrimaryColor,
                  style = MaterialTheme.typography.h5,
                  fontSize = 14.sp
              )
    }
}