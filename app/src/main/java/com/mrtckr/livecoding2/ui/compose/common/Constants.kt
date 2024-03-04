package com.mrtckr.livecoding2.ui.compose.common

object Constants {
    // Weather
    const val DEFAULT_VALUE = 0f
    const val INVISIBLE_ALPHA = 0f
    const val VISIBLE_ALPHA = 1f
    const val OVERLAP_CURRENT_INFORMATION_WIDGET_TEMPERATURE_THRESHOLD = 300f
    const val OVERLAP_CURRENT_INFORMATION_WIDGET_DESCRIPTION_THRESHOLD = 260f
    const val OVERLAP_CURRENT_INFORMATION_WIDGET_CITY_NAME_THRESHOLD = 240f
    const val SCROLLABLE_WIDGET_TOP_POINT = 220f
    const val CURRENT_INFORMATION_WIDGET_TRANSLATION_Y = 600
    const val CURRENT_INFORMATION_WIDGET_ALPHA_ANIMATION_TOP_THRESHOLD = 161
    const val CURRENT_INFORMATION_WIDGET_ALPHA_ANIMATION_DURATION = 100
    const val INFORMATION_BOX_ALPHA = 0.7F
    const val FORECAST_TITLE_ALPHA = 0.4f
    const val FORECAST_DIVIDER_ALPHA = 0.7f
    const val GRID_LIKED_LIST = "GridLikedList"
    const val HORIZONTAL_PLAYLIST = "HorizontalPlaylist"
    val RANGE_OF_WEATHER_TEMPERATURE_BAR: Pair<Float, Float> = Pair(-10f, 20f)
    val WEATHER_MAP_TOP_THRESHOLD_RANGE: Pair<Float, Float> = Pair(160f, 220f)
    val FORECAST_TOP_THRESHOLD_RANGE: Pair<Float, Float> = Pair(160f, 180f)
    val SCROLLABLE_TOP_THRESHOLD_RANGE: Pair<Float, Float> = Pair(160f, 161f)
    val CATEGORIES = listOf("All", "Music", "Podcasts")

    // Music Player
    const val LIST_DETAIL_IMAGE_SIZE = 250f
    const val IMAGE_SCALE_RATIO = 7
    const val IMAGE_SIZE_SCALE_FACTOR_RATIO = 2
    const val THRESHOLD_OF_SCALE_ANIMATION = 270f
    const val ALPHA_SCALE_RATIO = 11
    const val BACKGROUND_COLOR_AFFECT_MIN_VALUE = 140f
    const val SCROLLABLE_WIDGET_TOP_POINT_FOR_THRESHOLD = 100f
    const val ANIMATION_DURATION = 1000
}
