package m3components.components

import TestTags
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardTravel
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
fun LazyGridScope.m3Buttons() {

    item {
        Button(
            modifier = Modifier.padding(8.dp).testTag(TestTags.Buttons.regular),
            onClick = {},
            enabled = true
        ) {
            Text("Primary button")
        }
    }

    item {
        OutlinedButton(
            modifier = Modifier.padding(8.dp).testTag(TestTags.Buttons.outlined),
            onClick = {},
            enabled = true
        ) {
            Text("Secondary button")
        }
    }

    item {
        TextButton(
            modifier = Modifier.padding(8.dp).testTag(TestTags.Buttons.text),
            onClick = {},
            enabled = true
        ) {
            Text("Text button")
        }
    }

    item {
        Box {
            FloatingActionButton(
                modifier = Modifier.align(Alignment.Center).padding(8.dp).testTag(TestTags.Buttons.floating),
                onClick = {}) {
                Text("FAB")
            }
        }
    }

    item {
        Box {
            ExtendedFloatingActionButton(
                modifier = Modifier.testTag(TestTags.Buttons.extendedFloating)
                    .align(Alignment.Center)
                    .padding(8.dp),
                onClick = {}
            ) {
                Text("Extended FAB")
            }
        }
    }

    item {
        IconButton(
            modifier = Modifier.padding(8.dp).testTag(TestTags.Buttons.icon),
            onClick = {}, enabled = true
        ) {
            Icon(imageVector = Icons.Default.CardTravel, contentDescription = null)
        }
    }

    item {
        var checked by remember { mutableStateOf(false) }
        IconToggleButton(
            modifier = Modifier.padding(8.dp).testTag(TestTags.Buttons.iconToggle),
            checked = checked, onCheckedChange = { checked = it }
        ) {
            if (checked) {
                Icon(Icons.Filled.Lock, contentDescription = "Localized description")
            } else {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }
        }
    }

    item {
        Box {
            FilledIconButton(
                modifier = Modifier.align(Alignment.Center).padding(8.dp).testTag(TestTags.Buttons.filledIcon),
                onClick = {}, enabled = true
            ) {
                Icon(imageVector = Icons.Default.CardTravel, contentDescription = null)
            }
        }
    }
}
