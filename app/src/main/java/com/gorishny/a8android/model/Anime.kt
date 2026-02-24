package com.gorishny.a8android.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Anime(
    @StringRes val titleResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @DrawableRes val imageResourceId: Int
)