package com.gorishny.a8android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gorishny.a8android.data.Datasource
import com.gorishny.a8android.model.Anime
import com.gorishny.a8android.ui.theme._8androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _8androidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimeCatalogApp()
                }
            }
        }
    }
}

@Composable
fun AnimeCard(anime: Anime, modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Column {
            Image(
                painter = painterResource (anime.imageResourceId),
                contentDescription = stringResource (anime.titleResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(anime.titleResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = stringResource(anime.descriptionResourceId),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun AnimeList(animeList: List<Anime>, modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {
        // Отображение текущего аниме
        AnimeCard(
            anime = animeList[currentIndex],
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp)
        )

        // Кнопки навигации
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) {
                        currentIndex--
                    }
                },
                enabled = currentIndex > 0
            ) {
                Text("Назад")
            }

            Button(
                onClick = {
                    if (currentIndex < animeList.size - 1) {
                        currentIndex++
                    }
                },
                enabled = currentIndex < animeList.size - 1
            ) {
                Text("Вперед")
            }
        }
    }
}

@Composable
fun AnimeCatalogApp(){
    AnimeList(
        animeList = Datasource().loadAnimeList()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _8androidTheme {
        Text("Hello Android")
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimeCardPreview(){
    _8androidTheme{
        AnimeCard(
            Anime(
                R.string.anime1,
                R.string.anime1_description,
                R.drawable.anime1
            )
        )
    }
}