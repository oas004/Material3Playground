package components

import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.Divider
import androidx.compose.ui.unit.dp

fun LazyGridScope.m3Divider() {
    item {
        Divider(thickness = 0.5.dp)
    }
}
