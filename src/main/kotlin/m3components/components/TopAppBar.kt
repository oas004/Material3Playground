package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3TopAppBars() {
    Column {
        Spacer(Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Top app bars",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.size(16.dp))
        M3OnSurfaceText(
            text = "Not Scrolled State",
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(Modifier.size(4.dp))
        SmallTopAppBar(
            navigationIcon = { NavigationIcon() },
            title = { Text("Small top app bar") },
        )
        Spacer(modifier = Modifier.size(16.dp))
        CenterAlignedTopAppBar(
            navigationIcon = { NavigationIcon() },
            title = { Text("Center aligned top app bar") },
        )

        Spacer(modifier = Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Scrolled State",
            style = MaterialTheme.typography.labelLarge,
        )
        Spacer(Modifier.size(4.dp))
        // Hacky scroll state to show how the toolbar will look if its scrolled state
        val scrollState = TopAppBarScrollState(-1f, 0f, -2f)

        SmallTopAppBar(
            navigationIcon = { NavigationIcon() },
            title = { Text("Small top app bar") },
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(scrollState)
        )

        Spacer(modifier = Modifier.size(16.dp))

        CenterAlignedTopAppBar(
            navigationIcon = { NavigationIcon() },
            title = { Text("Center aligned top app bar") },
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(scrollState)
        )
    }
}

@Composable
private fun NavigationIcon() {
    IconButton(onClick = {}) {
        Icon(
            painter = painterResource("ic_arrow_back.xml"),
            contentDescription = null
        )
    }
}