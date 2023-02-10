package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun M3ProgressBar() {
    Column {
        Spacer(Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Progress bar ",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.size(16.dp))

        CircularProgressIndicator()
    }
}
