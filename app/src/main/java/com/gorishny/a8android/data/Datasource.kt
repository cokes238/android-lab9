package com.gorishny.a8android.data

import com.gorishny.a8android.R
import com.gorishny.a8android.model.Anime

class Datasource {
    fun loadAnimeList(): List<Anime>{
        return listOf(
            Anime(
                titleResourceId = R.string.anime1,
                descriptionResourceId = R.string.anime1_description,
                imageResourceId = R.drawable.anime1
            ),
            Anime(
                R.string.anime2,
                R.string.anime2_description,
                R.drawable.anime2
            ),
            Anime(
                titleResourceId = R.string.anime3,
                descriptionResourceId = R.string.anime3_description,
                imageResourceId = R.drawable.anime3
            ),
            Anime(
                titleResourceId = R.string.anime4,
                descriptionResourceId = R.string.anime4_description,
                imageResourceId = R.drawable.anime4
            ),
            Anime(
                titleResourceId = R.string.anime5,
                descriptionResourceId = R.string.anime5_description,
                imageResourceId = R.drawable.anime5
            ),
            Anime(
                titleResourceId = R.string.anime6,
                descriptionResourceId = R.string.anime6_description,
                imageResourceId = R.drawable.anime6
            ),
            Anime(
                titleResourceId = R.string.anime7,
                descriptionResourceId = R.string.anime7_description,
                imageResourceId = R.drawable.anime7
            ),
            Anime(
                titleResourceId = R.string.anime8,
                descriptionResourceId = R.string.anime8_description,
                imageResourceId = R.drawable.anime8
            ),
            Anime(
                titleResourceId = R.string.anime9,
                descriptionResourceId = R.string.anime9_description,
                imageResourceId = R.drawable.anime9
            ),
            Anime(
                titleResourceId = R.string.anime10,
                descriptionResourceId = R.string.anime10_description,
                imageResourceId = R.drawable.anime10
            ),
        )
    }
}