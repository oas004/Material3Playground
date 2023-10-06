import ColorFileType.Kotlin
import ColorFileType.XML
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
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


        Material3Playground(darkmode = darkmode)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun Material3Playground(darkmode: Boolean) {
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
            var shouldShowFileChooser by remember { mutableStateOf(false) }
            var fileSaverDialog: String? by remember { mutableStateOf(null) }
            var fileTypeDialog by remember { mutableStateOf(false) }
            var savableFileType by remember { mutableStateOf(Kotlin) }

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
                },
                onPrintColors = {
                    fileTypeDialog = true
                }
            )

            if (shouldShowFileChooser) {
                FileChooserDialog(
                    title = "Select directory to save file",
                    onResult = {
                        saveColorsToFile(
                            currentColorPalette, file = it, onResult = { success, message ->
                                // Implement success / failure screens for this when VM is implemented,
                                // and we can easier manage states.
                                fileSaverDialog = message
                            },
                            fileType = savableFileType
                        )
                        shouldShowFileChooser = false
                    },
                    onCancel = {
                        shouldShowFileChooser = false
                    }
                )
            }

            if (fileSaverDialog != null) {
                val title = when (savableFileType) {
                    Kotlin -> "Saving Colors to Colors.kt"
                    XML -> "Saving Colors to Colors.xml"
                }
                AlertDialog(
                    modifier = Modifier.defaultMinSize(minWidth = 400.dp, minHeight = 150.dp)
                        .background(color = MaterialTheme.colorScheme.surface).testTag(TestTags.FileSaverDialog.dialog),
                    shape = RoundedCornerShape(8.dp),
                    title = {
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(12.dp),
                            text = title,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    },
                    buttons = {
                        Button(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            onClick = {
                                fileSaverDialog = null
                            }
                        ) {
                            Text(
                                text = "OK",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    },
                    onDismissRequest = {
                        fileSaverDialog = null
                    },
                    text = {
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(12.dp),
                            text = fileSaverDialog ?: "",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                )
            }

            if (fileTypeDialog) {
                ChooseFileTypeDialog(
                    onTypeChosen = { type ->
                        savableFileType = type
                        shouldShowFileChooser = true
                        fileTypeDialog = false
                    },
                    onDismiss = {
                        fileTypeDialog = false
                    }
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ChooseFileTypeDialog(onTypeChosen: (colorType: ColorFileType) -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        modifier = Modifier.defaultMinSize(minWidth = 400.dp, minHeight = 150.dp)
            .background(color = MaterialTheme.colorScheme.surface).testTag(TestTags.FileSaverDialog.dialog),
        shape = RoundedCornerShape(8.dp),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                text = "Do you want to save colors as XML or Kotlin?",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
        },
        buttons = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Button(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = {
                        onTypeChosen(Kotlin)
                    }
                ) {
                    Text(
                        text = "Kotlin",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
                Spacer(Modifier.size(20.dp))
                Button(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = {
                        onTypeChosen(XML)
                    }
                ) {
                    Text(
                        text = "XML",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        onDismissRequest = {
            onDismiss.invoke()
        },
        text = {
            Text(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                text = "Please choose a file type to save the color files as",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )
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
