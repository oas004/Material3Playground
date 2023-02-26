import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.FileAlreadyExistsException
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
    onResult: (success: Boolean, message: String) -> Unit
) {
    try {
        val path = file.path
        val outputFile = Path(path, "colors.kt").createFile().toFile()
        outputFile.apply {
            appendText("val Primary: Color = Color(0x${currentColorPalette.primary.hexCode.takeLast(8)}) \n")
            appendText("val OnPrimary: Color = Color(0x${currentColorPalette.onPrimary.hexCode.takeLast(8)}) \n")
            appendText("val PrimaryContainer: Color = Color(0x${currentColorPalette.primaryContainer.hexCode.takeLast(8)}) \n")
            appendText(
                "val OnPrimaryContainer: Color = Color(0x${
                    currentColorPalette.onPrimaryContainer.hexCode.takeLast(
                        8
                    )
                }) \n"
            )
            appendText("val InversePrimary: Color = Color(0x${currentColorPalette.inversePrimary.hexCode.takeLast(8)}) \n")
            appendText("val Secondary: Color = Color(0x${currentColorPalette.secondary.hexCode.takeLast(8)}) \n")
            appendText("val OnSecondary: Color = Color(0x${currentColorPalette.onSecondary.hexCode.takeLast(8)}) \n")
            appendText(
                "val SecondaryContainer: Color = Color(0x${
                    currentColorPalette.secondaryContainer.hexCode.takeLast(
                        8
                    )
                }) \n"
            )
            appendText(
                "val OnSecondaryContainer: Color = Color(0x${
                    currentColorPalette.onSecondaryContainer.hexCode.takeLast(
                        8
                    )
                }) \n"
            )
            appendText("val Tertiary: Color = Color(0x${currentColorPalette.tertiary.hexCode.takeLast(8)}) \n")
            appendText("val OnTertiary: Color = Color(0x${currentColorPalette.onTertiary.hexCode.takeLast(8)}) \n")
            appendText(
                "val TertiaryContainer: Color = Color(0x${
                    currentColorPalette.tertiaryContainer.hexCode.takeLast(
                        8
                    )
                }) \n"
            )
            appendText(
                "val OnTertiaryContainer: Color = Color(0x${
                    currentColorPalette.onTertiaryContainer.hexCode.takeLast(
                        8
                    )
                }) \n"
            )
            appendText("val Background: Color = Color(0x${currentColorPalette.background.hexCode.takeLast(8)}) \n")
            appendText("val OnBackground: Color = Color(0x${currentColorPalette.onBackground.hexCode.takeLast(8)}) \n")
            appendText("val Surface: Color = Color(0x${currentColorPalette.surface.hexCode.takeLast(8)}) \n")
            appendText("val OnSurface: Color = Color(0x${currentColorPalette.onSurface.hexCode.takeLast(8)}) \n")
            appendText("val SurfaceVariant: Color = Color(0x${currentColorPalette.surfaceVariant.hexCode.takeLast(8)}) \n")
            appendText("val OnSurfaceVariant: Color = Color(0x${currentColorPalette.onSurfaceVariant.hexCode.takeLast(8)}) \n")
            appendText("val SurfaceTint: Color = Color(0x${currentColorPalette.surfaceTint.hexCode.takeLast(8)}) \n")
            appendText("val InverseSurface: Color = Color(0x${currentColorPalette.inverseSurface.hexCode.takeLast(8)}) \n")
            appendText("val InverseOnSurface: Color = Color(0x${currentColorPalette.inverseOnSurface.hexCode.takeLast(8)}) \n")
            appendText("val Error: Color = Color(0x${currentColorPalette.error.hexCode.takeLast(8)}) \n")
            appendText("val OnError: Color = Color(0x${currentColorPalette.onError.hexCode.takeLast(8)}) \n")
            appendText("val ErrorContainer: Color = Color(0x${currentColorPalette.errorContainer.hexCode.takeLast(8)}) \n")
            appendText("val OnErrorContainer: Color = Color(0x${currentColorPalette.onErrorContainer.hexCode.takeLast(8)}) \n")
            appendText("val Outline: Color = Color(0x${currentColorPalette.outline.hexCode.takeLast(8)}) \n")
        }
        onResult(true, "Saving colors worked")
    } catch (fileNotFound: FileNotFoundException) {
        onResult(false, "Could not save to this folder as it does not exist.")
    } catch (securityException: SecurityException) {
        onResult(false, "Can't save this file due to security reasons.")
    } catch (fileAlreadyExists: FileAlreadyExistsException) {
        onResult(false, "A file with this name already exists here.")
    }
}
