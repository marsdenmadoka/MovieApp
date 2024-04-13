package com.madoka.movieshop.utils

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.palette.graphics.Palette

object PaletteGenerator {
    fun generateImagePalette(imageDrawable: Drawable, onGenerated: (Palette.Swatch) -> Unit) {
        val bitmap = (imageDrawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bitmap).maximumColorCount(24).generate { palette ->
            val vibrantSwatch = palette?.vibrantSwatch
            val dominantSwatch = palette?.vibrantSwatch

            if (vibrantSwatch != null) {
                onGenerated(vibrantSwatch)
            } else if (dominantSwatch != null) {
                onGenerated(dominantSwatch)
            }
        }
    }
}


/**Convert movie rating to a value out of 5.0 eg. 8 => 4.0/5.0 */
fun Double.getRating(): String {
    val byTwo = this / 2
    val before = byTwo.toString().substringBefore(".")
    val after = byTwo.toString().substringAfter(".").split("")[1]
    return "$before.$after"
}