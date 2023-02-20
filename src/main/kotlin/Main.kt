import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import java.awt.Dimension
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import javax.swing.JFileChooser
import javax.swing.filechooser.FileSystemView
import kotlin.io.path.Path
import kotlin.io.path.createFile

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
                var shouldShowFileChooser by remember { mutableStateOf(false) }
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
                        shouldShowFileChooser = true
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
                                }
                            )
                            shouldShowFileChooser = false
                        },
                        onCancel = {
                            shouldShowFileChooser = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun FileChooserDialog(
    title: String,
    onResult: (result: File) -> Unit,
    onCancel: () -> Unit
) {
    val fileChooser = JFileChooser(FileSystemView.getFileSystemView())
    fileChooser.currentDirectory = File(System.getProperty("user.dir"))
    fileChooser.dialogTitle = title
    fileChooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
    fileChooser.isAcceptAllFileFilterUsed = true
    fileChooser.selectedFile = null
    fileChooser.currentDirectory = null
    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        val file = fileChooser.selectedFile
        onResult(file)
    } else {
        onCancel.invoke()
    }
}

private fun saveColorsToFile(
    currentColorPalette: ColorScheme,
    file: File,
    onResult: (success: Boolean, message: String) -> Unit
) {
    val path = file.path
    val outputFile = Path(path, "colors.txt").createFile().toFile()
    try {
        FileOutputStream(outputFile, true).bufferedWriter().use { fileWriter ->
            fileWriter.write("Exported Material 3 Colors" + "\n")
            fileWriter.write("primary : " + currentColorPalette.primary.hexCode + "\n")
            fileWriter.write("onPrimary : " + currentColorPalette.onPrimary.hexCode + "\n")
            fileWriter.write("primaryContainer : " + currentColorPalette.primaryContainer.hexCode + "\n")
            fileWriter.write("onPrimaryContainer : " + currentColorPalette.onPrimaryContainer.hexCode + "\n")
            fileWriter.write("inversePrimary : " + currentColorPalette.inversePrimary.hexCode + "\n")
            fileWriter.write("secondary : " + currentColorPalette.secondary.hexCode + "\n")
            fileWriter.write("onSecondary : " + currentColorPalette.onSecondary.hexCode + "\n")
            fileWriter.write("secondaryContainer : " + currentColorPalette.secondaryContainer.hexCode + "\n")
            fileWriter.write("onSecondaryContainer : " + currentColorPalette.onSecondaryContainer.hexCode + "\n")
            fileWriter.write("tertiary : " + currentColorPalette.tertiary.hexCode + "\n")
            fileWriter.write("onTertiary : " + currentColorPalette.onTertiary.hexCode + "\n")
            fileWriter.write("tertiaryContainer : " + currentColorPalette.tertiaryContainer.hexCode + "\n")
            fileWriter.write("onTertiaryContainer : " + currentColorPalette.onTertiaryContainer.hexCode + "\n")
            fileWriter.write("background : " + currentColorPalette.background.hexCode + "\n")
            fileWriter.write("onBackground : " + currentColorPalette.onBackground.hexCode + "\n")
            fileWriter.write("surface : " + currentColorPalette.surface.hexCode + "\n")
            fileWriter.write("onSurface : " + currentColorPalette.onSurface.hexCode + "\n")
            fileWriter.write("surfaceVariant : " + currentColorPalette.surfaceVariant.hexCode + "\n")
            fileWriter.write("onSurfaceVariant : " + currentColorPalette.onSurfaceVariant.hexCode + "\n")
            fileWriter.write("surfaceTint : " + currentColorPalette.surfaceTint.hexCode + "\n")
            fileWriter.write("inverseSurface : " + currentColorPalette.inverseSurface.hexCode + "\n")
            fileWriter.write("inverseOnSurface : " + currentColorPalette.inverseOnSurface.hexCode + "\n")
            fileWriter.write("error : " + currentColorPalette.error.hexCode + "\n")
            fileWriter.write("onError : " + currentColorPalette.onError.hexCode + "\n")
            fileWriter.write("errorContainer : " + currentColorPalette.errorContainer.hexCode + "\n")
            fileWriter.write("onErrorContainer : " + currentColorPalette.onErrorContainer.hexCode + "\n")
            fileWriter.write("outline : " + currentColorPalette.outline.hexCode + "\n")
            fileWriter.close()
        }
        onResult(true, "Saving colors worked")
    } catch (fileNotFound: FileNotFoundException) {
        onResult(false, "Could not save to this folder as it does not exist.")
    } catch (securityException: SecurityException) {
        onResult(false, "Can't save this file due to security reasons.")
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
