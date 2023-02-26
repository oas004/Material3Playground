package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
fun LazyGridScope.m3Chips() {
    item {
        Row(Modifier.padding(8.dp)) {
            var selectedId by remember { mutableStateOf(1) }

            FilterChip(
                label = { Text("Android") },
                onClick = { selectedId = 1 },
                selected = selectedId == 1
            )

            Spacer(modifier = Modifier.size(4.dp))

            FilterChip(
                label = { Text("Material") },
                onClick = { selectedId = 2 },
                selected = selectedId == 2
            )

            Spacer(modifier = Modifier.size(4.dp))

            FilterChip(
                label = { Text("Compose") },
                onClick = { selectedId = 3 },
                selected = selectedId == 3
            )
        }
    }
}
