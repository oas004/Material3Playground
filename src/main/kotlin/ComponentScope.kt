import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.*
import m3components.components.M3Buttons

@Composable
internal fun ComponentScope(
    onColorPicked: (name: String, color: Color) -> Unit
) {
    Row(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        // Components
        M3Components(
            modifier = Modifier.fillMaxSize()
                .weight(2f)
                .padding(16.dp)
        )

        // Color picking area
        ColorPickers(
            modifier = Modifier.fillMaxSize()
                .weight(1f)
                .padding(16.dp),
            onColorPicked = onColorPicked
        )
    }
}

@Composable
private fun M3Components(modifier: Modifier) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(20.dp)
    ) {
        item { M3Buttons() }
        item { M3TextFields() }
        item { M3Chips() }
        item { M3Switch() }
        item { M3Checkbox() }
        item { M3Slider() }
        item { M3ProgressBar() }
        item { M3Divider() }
        item { M3Cards() }
        item { M3TopAppBars() }
        item { M3NavigationBars() }
        item { M3Tab() }
    }
}

@Composable
private fun ColorPickers(
    modifier: Modifier,
    onColorPicked: (name: String, color: Color) -> Unit,
) {
    // Do not use MutableList since it will not be stable.
    var recentlyUsedColors: List<Color> by remember { mutableStateOf(listOf()) }

    val colorPickedCallback: (colorName: String, pickedColor: Color) -> Unit =
        { colorName, pickedColor ->
            onColorPicked(colorName, pickedColor)
            recentlyUsedColors = recentlyUsedColors.toMutableList().also { it.add(pickedColor) }
        }

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(40.dp)
    ) {

        item {
            ThemeColorPicker(
                colorName = "primary",
                currentColor = MaterialTheme.colorScheme.primary,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onPrimary",
                currentColor = MaterialTheme.colorScheme.onPrimary,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "primaryContainer",
                currentColor = MaterialTheme.colorScheme.primaryContainer,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onPrimaryContainer",
                currentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "inversePrimary",
                currentColor = MaterialTheme.colorScheme.inversePrimary,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "secondary",
                currentColor = MaterialTheme.colorScheme.secondary,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onSecondary",
                currentColor = MaterialTheme.colorScheme.onSecondary,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "secondaryContainer",
                currentColor = MaterialTheme.colorScheme.secondaryContainer,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onSecondaryContainer",
                currentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "tertiary",
                currentColor = MaterialTheme.colorScheme.tertiary,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onTertiary",
                currentColor = MaterialTheme.colorScheme.onTertiary,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "tertiaryContainer",
                currentColor = MaterialTheme.colorScheme.tertiaryContainer,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onTertiaryContainer",
                currentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "background",
                currentColor = MaterialTheme.colorScheme.background,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onBackground",
                currentColor = MaterialTheme.colorScheme.onBackground,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "surface",
                currentColor = MaterialTheme.colorScheme.surface,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onSurface",
                currentColor = MaterialTheme.colorScheme.onSurface,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "surfaceVariant",
                currentColor = MaterialTheme.colorScheme.surfaceVariant,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onSurfaceVariant",
                currentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "surfaceTint",
                currentColor = MaterialTheme.colorScheme.surfaceTint,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "inverseSurface",
                currentColor = MaterialTheme.colorScheme.inverseSurface,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "inverseOnSurface",
                currentColor = MaterialTheme.colorScheme.inverseOnSurface,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "error",
                currentColor = MaterialTheme.colorScheme.error,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onError",
                currentColor = MaterialTheme.colorScheme.onError,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "errorContainer",
                currentColor = MaterialTheme.colorScheme.errorContainer,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "onErrorContainer",
                currentColor = MaterialTheme.colorScheme.onErrorContainer,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
        item {
            ThemeColorPicker(
                colorName = "outline",
                currentColor = MaterialTheme.colorScheme.outline,
                onColorPicked = colorPickedCallback,
                recentlyUsedColors = recentlyUsedColors,
            )
        }
    }
}
