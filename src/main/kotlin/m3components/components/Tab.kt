package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
fun M3Tab() {
    var selectedIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Accounts", "Cards", "Funds")

    Column {
        Spacer(Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Tab",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.size(16.dp))

        TabRow(selectedTabIndex = selectedIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = index == selectedIndex,
                    onClick = { selectedIndex = index }
                )
            }
        }
    }
}
