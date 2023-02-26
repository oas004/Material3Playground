package components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun LazyGridScope.m3NavigationBars() {

    item {
        val navbarItems = listOf("Home", "Payments", "Spending")
        var selectedItem by remember { mutableStateOf(0) }

        NavigationBar(Modifier.width(600.dp).padding(8.dp)) {
            navbarItems.forEachIndexed { index, title ->
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text(title) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }
    }

    item {
        val navbarItems = listOf("Home", "Payments", "Spending")
        var selectedItem by remember { mutableStateOf(0) }

        NavigationBar(Modifier.width(600.dp).padding(8.dp)) {
            navbarItems.forEachIndexed { index, title ->
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text(title) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    alwaysShowLabel = false,
                )
            }
        }
    }
}
