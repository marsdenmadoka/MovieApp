package com.madoka.movieshop.ui.utils


/**Converts movie duration from minutes to hours and minutes
 * eg. 150 minutes => 1hr 30mins
 * eg. 250 minutes => 4hrs 10mins
 * */
fun Int?.getMovieDuration(): String? {
    return if (this != null) {
        val hours = (this / 60)
        val minutes = this % 60

        val runtime = if (hours <= 1) "${hours}hr ${minutes}mins" else "${hours}hrs ${minutes}mins"

        runtime
    } else null
}

/**Convert movie rating to a value out of 100% eg. 8 => 80% */
fun Double.getPopularity(): String {
    return ((this.toInt() * 100) / 10).toString()
}