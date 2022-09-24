package com.madoka.movieshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.madoka.movieshop.ui.navGraph.MainNavigationGraph
import com.madoka.movieshop.ui.theme.MovieShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieShopTheme {
                MainNavigationGraph()
                }
            }
        }
    }
