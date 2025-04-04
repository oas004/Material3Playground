package components

import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

fun LazyGridScope.m3Slider() {
    item {
        var sliderPosition by remember { mutableStateOf(0f) }

        Slider(
            modifier = Modifier.testTag(TestTags.Slider.regular),
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
    }
}
