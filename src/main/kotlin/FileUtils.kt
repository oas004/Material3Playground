import ColorFileType.Kotlin
import ColorFileType.XML
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.FileAlreadyExistsException
import java.util.Locale
import javax.swing.JFileChooser
import javax.swing.filechooser.FileSystemView
import kotlin.io.path.Path
import kotlin.io.path.createFile

@Composable
internal fun FileChooserDialog(
    title: String,
    onResult: (result: File) -> Unit,
    onCancel: () -> Unit
) {
    val fileChooser = JFileChooser(FileSystemView.getFileSystemView()).apply {
        currentDirectory = File(System.getProperty("user.dir"))
        dialogTitle = title
        fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
        isAcceptAllFileFilterUsed = true
        selectedFile = null
        currentDirectory = null
    }
    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        val file = fileChooser.selectedFile
        onResult(file)
    } else {
        onCancel.invoke()
    }
}

internal fun saveColorsToFile(
    currentColorPalette: ColorScheme,
    file: File,
    fileType: ColorFileType,
    onResult: (success: Boolean, message: String) -> Unit
) {
    when (fileType) {
        Kotlin -> saveColorsToKotlinFile(file = file, currentColorPalette = currentColorPalette, onResult = onResult)
        XML -> saveColorsToXMLFile(file = file, currentColorPalette = currentColorPalette, onResult = onResult)
    }
}

private fun saveColorsToXMLFile(
    file: File,
    currentColorPalette: ColorScheme,
    onResult: (success: Boolean, message: String) -> Unit
) {
    tryWriteToFile(
        onResult = onResult
    ) {
        val path = file.path
        val outputFile = Path(path, "colors.xml").createFile().toFile()
        outputFile.apply {

            getColorList(colorPalette = currentColorPalette).forEach { color ->
                appendText(getColorsXMLProperty(colorNameLowerCase = color.key, color = color.value))
            }

        }
        onResult(true, "Saving colors worked")
    }
}


private fun saveColorsToKotlinFile(
    file: File,
    currentColorPalette: ColorScheme,
    onResult: (success: Boolean, message: String) -> Unit
) {
    tryWriteToFile(
        onResult = onResult
    ) {
        val path = file.path
        val outputFile = Path(path, "colors.kt").createFile().toFile()
        outputFile.apply {

            getColorList(colorPalette = currentColorPalette).forEach { color ->
                appendText(getColorKotlinProperty(colorNameLowerCase = color.key, color = color.value))
            }

        }
        onResult(true, "Saving colors worked")
    }
}
private fun tryWriteToFile(
    onResult: (success: Boolean, message: String) -> Unit,
    block: () -> Unit,
) {
    try {
        block.invoke()
    } catch (fileNotFound: FileNotFoundException) {
        onResult(false, "Could not save to this folder as it does not exist.")
    } catch (securityException: SecurityException) {
        onResult(false, "Can't save this file due to security reasons.")
    } catch (fileAlreadyExists: FileAlreadyExistsException) {
        onResult(false, "A file with this name already exists here.")
    }
}

internal fun getColorsXMLProperty(colorNameLowerCase: String, color: Color): String {
    return "<color name=\"$colorNameLowerCase\">${color.hexCode}</color> \n"
}


internal fun getColorKotlinProperty(colorNameLowerCase: String, color: Color): String {
    val capitalizedColorName = colorNameLowerCase.replaceFirstChar {
        if (it.isLowerCase()) {
            it.titlecase(Locale.getDefault())
        } else {
            it.toString()
        }
    }
    return "val $capitalizedColorName: Color = Color(0x${color.hexCode.takeLast(8)}) \n"
}

private fun getColorList(colorPalette: ColorScheme): Map<String, Color> {
    return mapOf(
        "primary" to colorPalette.primary,
        "onPrimary" to colorPalette.onPrimary,
        "primaryContainer" to colorPalette.primaryContainer,
        "onPrimaryContainer" to colorPalette.onPrimaryContainer,
        "inversePrimary" to colorPalette.inversePrimary,
        "secondary" to colorPalette.secondary,
        "onSecondary" to colorPalette.onSecondary,
        "secondaryContainer" to colorPalette.secondaryContainer,
        "onSecondaryContainer" to colorPalette.onSecondaryContainer,
        "tertiary" to colorPalette.tertiary,
        "onTertiary" to colorPalette.onTertiary,
        "tertiaryContainer" to colorPalette.tertiaryContainer,
        "onTertiaryContainer" to colorPalette.onTertiaryContainer,
        "background" to colorPalette.background,
        "onBackground" to colorPalette.onBackground,
        "surface" to colorPalette.surface,
        "onSurface" to colorPalette.onSurface,
        "surfaceVariant" to colorPalette.surfaceVariant,
        "onSurfaceVariant" to colorPalette.onSurfaceVariant,
        "surfaceTint" to colorPalette.surfaceTint,
        "inverseSurface" to colorPalette.inverseSurface,
        "inverseOnSurface" to colorPalette.inverseOnSurface,
        "error" to colorPalette.error,
        "onError" to colorPalette.onError,
        "errorContainer" to colorPalette.errorContainer,
        "onErrorContainer" to colorPalette.onErrorContainer,
        "outline" to colorPalette.outline,
    )
}

internal enum class ColorFileType {
    Kotlin, XML
}
