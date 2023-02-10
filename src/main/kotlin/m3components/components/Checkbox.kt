package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
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
@Composable
fun M3Checkbox() {
    var checked by remember { mutableStateOf(true) }
    Column {
        Spacer(Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Checkbox",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.size(16.dp))

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
