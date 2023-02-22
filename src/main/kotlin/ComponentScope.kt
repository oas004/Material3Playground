import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppShortcut
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Poll
import androidx.compose.material.icons.filled.Slideshow
import androidx.compose.material.icons.filled.SpatialAudio
import androidx.compose.material.icons.filled.SwitchLeft
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import components.M3Cards
import components.M3Checkbox
import components.M3Chips
import components.M3Divider
import components.M3NavigationBars
import components.M3ProgressBar
import components.M3Slider
import components.M3Switch
import components.M3Tab
import components.M3TextFields
import components.M3TopAppBars
import m3components.components.M3Buttons

enum class Page {
    Buttons, AppBars, Cards, TextFields, Chips, Switch, Checkbox, Sliders, ProgressBars, Dividers
}

@Composable
internal fun ComponentScope(
    onColorPicked: (name: String, color: Color) -> Unit
) {
    var selectedPage by remember { mutableStateOf(Page.Buttons) }

    Row(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        NavigationRail(
            modifier = Modifier.fillMaxHeight().padding(4.dp),
        ) {

            NavigationRailItem(
                selected = selectedPage == Page.Buttons,
                onClick = {
                    selectedPage = Page.Buttons
                },
                icon = {
                    Icon(imageVector = Icons.Default.TouchApp, contentDescription = "Buttons")
                },
                label = {
                    Text(
                        text = "Buttons",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )

            NavigationRailItem(
                selected = selectedPage == Page.AppBars,
                onClick = {
                    selectedPage = Page.AppBars
                },
                icon = {
                    Icon(imageVector = Icons.Default.AppShortcut, contentDescription = "App Bars")
                },
                label = {
                    Text(
                        text = "App Bars",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )

            NavigationRailItem(
                selected = selectedPage == Page.Cards,
                onClick = {
                    selectedPage = Page.Cards
                },
                icon = {
                    Icon(imageVector = Icons.Default.CreditCard, contentDescription = "Cards")
                },
                label = {
                    Text(
                        text = "Cards",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )

            NavigationRailItem(
                selected = selectedPage == Page.TextFields,
                onClick = {
                    selectedPage = Page.TextFields
                },
                icon = {
                    Icon(imageVector = Icons.Default.TextFields, contentDescription = "TextFields")
                },
                label = {
                    Text(
                        text = "TextFields",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )

            NavigationRailItem(
                selected = selectedPage == Page.Chips,
                onClick = {
                    selectedPage = Page.Chips
                },
                icon = {
                    Icon(imageVector = Icons.Default.SpatialAudio, contentDescription = "Chips")
                },
                label = {
                    Text(
                        text = "Chips",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )
            NavigationRailItem(
                selected = selectedPage == Page.Switch,
                onClick = {
                    selectedPage = Page.Switch
                },
                icon = {
                    Icon(imageVector = Icons.Default.SwitchLeft, contentDescription = "Switch")
                },
                label = {
                    Text(
                        text = "Switch",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )
            NavigationRailItem(
                selected = selectedPage == Page.Checkbox,
                onClick = {
                    selectedPage = Page.Checkbox
                },
                icon = {
                    Icon(imageVector = Icons.Default.CheckBox, contentDescription = "Checkbox")
                },
                label = {
                    Text(
                        text = "Checkbox",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )
            NavigationRailItem(
                selected = selectedPage == Page.Sliders,
                onClick = {
                    selectedPage = Page.Sliders
                },
                icon = {
                    Icon(imageVector = Icons.Default.Slideshow, contentDescription = "Sliders")
                },
                label = {
                    Text(
                        text = "Sliders",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )

            NavigationRailItem(
                selected = selectedPage == Page.ProgressBars,
                onClick = {
                    selectedPage = Page.ProgressBars
                },
                icon = {
                    Icon(imageVector = Icons.Default.Download, contentDescription = "Progress Bars")
                },
                label = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "ProgressBars",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )

            NavigationRailItem(
                selected = selectedPage == Page.Dividers,
                onClick = {
                    selectedPage = Page.Dividers
                },
                icon = {
                    Icon(imageVector = Icons.Default.Poll, contentDescription = "Dividers")
                },
                label = {
                    Text(
                        text = "Dividers",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            )
        }

        // Components
        M3Components(
            modifier = Modifier.fillMaxSize()
                .weight(2f)
                .padding(16.dp),
            page = selectedPage,
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
private fun M3Components(modifier: Modifier, page: Page) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(20.dp)
    ) {
        when (page) {
            Page.Buttons -> {
                item { M3Buttons() }
            }

            Page.AppBars -> {
                item { M3TopAppBars() }
                item { M3NavigationBars() }
                item { M3Tab() }
            }

            Page.Cards -> {
                item { M3Cards() }
            }

            Page.TextFields -> {
                item { M3TextFields() }
            }

            Page.Chips -> {
                item { M3Chips() }
            }

            Page.Switch -> {
                item { M3Switch() }
            }

            Page.Checkbox -> {
                item { M3Checkbox() }
            }

            Page.Sliders -> {
                item { M3Slider() }
            }

            Page.ProgressBars -> {
                item { M3ProgressBar() }
            }

            Page.Dividers -> {
                item { M3Divider() }
            }
        }
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
