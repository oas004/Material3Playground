package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun M3NavigationBars() {
    val navbarItems = listOf("Home", "Payments", "Spending", "Savings", "Me")
    var selectedItem by remember { mutableStateOf(0) }

    Column {
        Spacer(Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Bottom app bars",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.size(16.dp))

        Column {
            NavigationBar {
                navbarItems.forEachIndexed { index, title ->
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(title) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }

            Spacer(Modifier.size(16.dp))

            Column {
                NavigationBar {
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
    }
}
