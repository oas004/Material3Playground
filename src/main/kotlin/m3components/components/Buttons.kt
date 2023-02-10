package m3components.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.M3OnSurfaceText

@Composable
fun M3Buttons() {
    Column {
        var enabled by remember { mutableStateOf(true) }

        Spacer(Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Buttons",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.size(16.dp))

        Row {
            Button(
                onClick = {},
                enabled = enabled
            ) {
                Text("Primary button")
            }

            Spacer(Modifier.size(16.dp))

            OutlinedButton(
                onClick = {},
                enabled = enabled
            ) {
                Text("Secondary button")
            }

            Spacer(Modifier.size(16.dp))

            TextButton(
                onClick = {},
                enabled = enabled
            ) {
                Text("Text button")
            }

            Spacer(Modifier.size(16.dp))

            FloatingActionButton(onClick = {}) {
                Text("FAB")
            }

            Spacer(Modifier.size(16.dp))

            ExtendedFloatingActionButton(onClick = {}) {
                Text("Extended FAB")
            }
        }
    }
}