package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.CircularProgressIndicator

fun LazyGridScope.m3ProgressBar() {
    item {
        Box {
            CircularProgressIndicator()
        }
    }
}
