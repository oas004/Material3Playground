package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

fun LazyGridScope.m3ProgressBar() {
    item {
        Box {
            CircularProgressIndicator(
                modifier = Modifier.testTag(TestTags.ProgressBar.circular)
            )
        }
    }
}
