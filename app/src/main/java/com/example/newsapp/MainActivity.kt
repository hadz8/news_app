package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                Surface(modifier = Modifier.fillMaxWidth()) {
                    NewsList(newsItems = newsItems)
                }
            }
        }
    }
}

data class NewsItem(
    val title: String,
    val description: String,
    val image: Int
)

val newsItems = listOf(
    NewsItem("Title 1", "Description 1", R.drawable.ic_launcher_foreground),
    NewsItem("Title 2", "Description 2", R.drawable.ic_launcher_foreground),
    NewsItem("Title 3", "Description 3", R.drawable.ic_launcher_foreground),
    NewsItem("Title 4", "Description 4", R.drawable.ic_launcher_foreground),
    NewsItem("Title 5", "Description 5", R.drawable.ic_launcher_foreground),
    NewsItem("Title 6", "Description 6", R.drawable.ic_launcher_foreground),
)

@Composable
fun NewsList(newsItems: List<NewsItem>) {
    LazyColumn {
        items(newsItems) { newsItem ->
            NewsItemRow(newsItem = newsItem)
        }
    }
}

@Composable
fun NewsItemRow(newsItem: NewsItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = newsItem.image),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = newsItem.title, style = MaterialTheme.typography.titleMedium)
            Text(text = newsItem.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsAppTheme {
        NewsList(newsItems = newsItems)
    }
}