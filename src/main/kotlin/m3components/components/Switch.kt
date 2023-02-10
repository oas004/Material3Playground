package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun M3Switch() {
    Column {
        Spacer(Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Switch",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.size(16.dp))

        Row {
            var checked by remember { mutableStateOf(false) }

            Switch(checked = checked, onCheckedChange = { checked = !checked })
            Spacer(modifier = Modifier.size(16.dp))
            Switch(checked = !checked, onCheckedChange = { checked = !checked })
        }
    }
}

