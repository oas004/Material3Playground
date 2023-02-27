package components

import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

fun LazyGridScope.m3Tab() {
    item {
        var selectedIndex by remember { mutableStateOf(0) }
        val tabs = listOf("Accounts", "Cards", "Funds")

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
