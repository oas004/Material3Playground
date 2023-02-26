package components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
fun LazyGridScope.m3Checkbox() {
    item {
        var checked by remember { mutableStateOf(true) }
        Row {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )

            Spacer(Modifier.size(8.dp))

            Checkbox(
                checked = !checked,
                onCheckedChange = { checked = !it }
            )
        }
    }
}
