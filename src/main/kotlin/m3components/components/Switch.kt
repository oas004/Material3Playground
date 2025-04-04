package components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.Switch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

fun LazyGridScope.m3Switch() {
    item {
        Row {
            var checked by remember { mutableStateOf(false) }

            Switch(
                modifier = Modifier.testTag(TestTags.Switch.regular),
                checked = checked,
                onCheckedChange = { checked = !checked }
            )
            Spacer(modifier = Modifier.size(16.dp))
            Switch(
                modifier = Modifier.testTag(TestTags.Switch.regular),
                checked = !checked,
                onCheckedChange = { checked = !checked }
            )
        }
    }
}
