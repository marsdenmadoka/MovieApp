package com.madoka.movieshop

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData

data class FakeTopSectionItems(
    val title: String,
   // val Image: Int,
    @DrawableRes val Image: Int,
    //  val rating:Double,
)


data class FakeTrendingSectionItems(
    val title: String,
    // val Image: Int,
    @DrawableRes val Image: Int,
    //  val rating:Double,
)

data class FakePopularSectionItems(
    val title: String,
    // val Image: Int,
    @DrawableRes val Image: Int,
   val releaseDate:String
)