package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
fun LazyGridScope.m3Cards() {
    item {
        ElevatedCard(
            onClick = {},
            modifier = Modifier.size(width = 180.dp, height = 100.dp).padding(8.dp)
        ) {
            Box(Modifier.fillMaxSize()) {
                Text("Elevated card", Modifier.align(Alignment.Center))
            }
        }
    }

    item {
        OutlinedCard(
            onClick = {},
            modifier = Modifier.size(width = 180.dp, height = 100.dp).padding(8.dp)
        ) {
            Box(Modifier.fillMaxSize()) {
                Text("Outlined card", Modifier.align(Alignment.Center))
            }
        }
    }


    item {
        Card(
            onClick = {},
            modifier = Modifier.size(width = 180.dp, height = 100.dp).padding(8.dp)
        ) {
            Box(Modifier.fillMaxSize()) {
                Text("Filled card", Modifier.align(Alignment.Center))
            }
        }
    }
}
