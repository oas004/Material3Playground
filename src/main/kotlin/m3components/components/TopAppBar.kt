package components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
fun LazyGridScope.m3TopAppBars() {
    item {
        SmallTopAppBar(
            modifier = Modifier.width(600.dp).padding(8.dp),
            navigationIcon = { NavigationIcon() },
            title = { Text("Small top app bar") },
        )
    }
    item {
        CenterAlignedTopAppBar(
            modifier = Modifier.width(600.dp).padding(8.dp),
            navigationIcon = { NavigationIcon() },
            title = { Text("Center aligned top app bar") },
        )
    }
    item {

        // Hacky scroll state to show how the toolbar will look if its scrolled state
        val scrollState = TopAppBarScrollState(-1f, 0f, -2f)

        SmallTopAppBar(
            modifier = Modifier.width(600.dp).padding(8.dp),
            navigationIcon = { NavigationIcon() },
            title = { Text("Small top app bar") },
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(scrollState)
        )
    }

    item {

        // Hacky scroll state to show how the toolbar will look if its scrolled state
        val scrollState = TopAppBarScrollState(-1f, 0f, -2f)

        CenterAlignedTopAppBar(
            modifier = Modifier.width(600.dp).padding(8.dp),
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