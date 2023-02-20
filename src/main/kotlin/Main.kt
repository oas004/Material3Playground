import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import java.awt.Dimension

private const val windowMinWidth = 500
private const val windowMinHeight = 600

fun main() = application {

    Tray(
        icon = painterResource("icon.png"),
        menu = {
            Item("Quit App", onClick = ::exitApplication)
        }
    )

    Window(
        onCloseRequest = ::exitApplication,
        title = "Material 3 Playground",
        state = rememberWindowState(
            width = 1200.dp, height = 800.dp, position = WindowPosition(
                Alignment.Center
            )
        ),
        resizable = true,
        icon = painterResource("icon.png")
    ) {
        var darkmode by remember { mutableStateOf(false) }

        MenuBar {
            Menu(text = "UI Mode", mnemonic = 'U') {
                val darkModeMenuText = if (darkmode) {
                    "Toggle Dark Mode Off"
                } else {
                    "Toggle Dark Mode On"
                }
                Item(
                    text = darkModeMenuText,
                    onClick = {
                        darkmode = !darkmode
                    },
                )
            }
        }

        window.minimumSize = Dimension(windowMinWidth, windowMinHeight)


        var lightColorScheme by remember { mutableStateOf(lightColorScheme()) }
        var darkColorScheme by remember { mutableStateOf(darkColorScheme()) }

        MaterialTheme(
            colorScheme = if (darkmode) darkColorScheme else lightColorScheme
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surface)
            ) {

                val currentColorPalette = MaterialTheme.colorScheme

                ComponentScope(
                    onColorPicked = { colorName, color ->
                        val updatedColorPalette = updateColorPalette(
                                currentColorPalette = currentColorPalette,
                                colorName = colorName,
                                color = color,
                            )

                        if (darkmode) {
                            darkColorScheme = updatedColorPalette
                        } else {
                            lightColorScheme = updatedColorPalette
                        }
                    }
                )
            }
        }
    }
}

private fun updateColorPalette(
    currentColorPalette: ColorScheme,
    colorName: String,
    color: Color
): ColorScheme {
    return when (colorName) {
        "primary" -> currentColorPalette.copy(primary = color)
        "onPrimary" -> currentColorPalette.copy(onPrimary = color)
        "primaryContainer" -> currentColorPalette.copy(primaryContainer = color)
        "onPrimaryContainer" -> currentColorPalette.copy(onPrimaryContainer = color)
        "inversePrimary" -> currentColorPalette.copy(inversePrimary = color)
        "secondary" -> currentColorPalette.copy(secondary = color)
        "onSecondary" -> currentColorPalette.copy(onSecondary = color)
        "secondaryContainer" -> currentColorPalette.copy(secondaryContainer = color)
        "onSecondaryContainer" -> currentColorPalette.copy(onSecondaryContainer = color)
        "tertiary" -> currentColorPalette.copy(tertiary = color)
        "onTertiary" -> currentColorPalette.copy(onTertiary = color)
        "tertiaryContainer" -> currentColorPalette.copy(tertiaryContainer = color)
        "onTertiaryContainer" -> currentColorPalette.copy(onTertiaryContainer = color)
        "background" -> currentColorPalette.copy(background = color)
        "onBackground" -> currentColorPalette.copy(onBackground = color)
        "surface" -> currentColorPalette.copy(surface = color)
        "onSurface" -> currentColorPalette.copy(onSurface = color)
        "surfaceVariant" -> currentColorPalette.copy(surfaceVariant = color)
        "onSurfaceVariant" -> currentColorPalette.copy(onSurfaceVariant = color)
        "surfaceTint" -> currentColorPalette.copy(surfaceTint = color)
        "inverseSurface" -> currentColorPalette.copy(inverseSurface = color)
        "inverseOnSurface" -> currentColorPalette.copy(inverseOnSurface = color)
        "error" -> currentColorPalette.copy(error = color)
        "onError" -> currentColorPalette.copy(onError = color)
        "errorContainer" -> currentColorPalette.copy(errorContainer = color)
        "onErrorContainer" -> currentColorPalette.copy(onErrorContainer = color)
        "outline" -> currentColorPalette.copy(outline = color)
        else -> throw IllegalArgumentException("Color name is wrong $colorName")
    }
}
