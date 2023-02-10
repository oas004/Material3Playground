package components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun M3OnSurfaceText(
    text: String,
    style: TextStyle,
) {
    Text(
        color = MaterialTheme.colorScheme.onSurface,
        text = text,
        style = style,
    )
}