package com.madoka.movieshop

import androidx.annotation.DrawableRes

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