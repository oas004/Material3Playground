import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import java.util.prefs.Preferences

/**
 * Handles persistence of custom color schemes using Java Preferences API.
 * Colors are stored in the user's preferences and automatically loaded on app startup.
 */
object ColorPreferences {
    private val prefs: Preferences = Preferences.userNodeForPackage(ColorPreferences::class.java)

    private const val LIGHT_PREFIX = "light_"
    private const val DARK_PREFIX = "dark_"

    private val colorNames = listOf(
        "primary",
        "onPrimary",
        "primaryContainer",
        "onPrimaryContainer",
        "inversePrimary",
        "secondary",
        "onSecondary",
        "secondaryContainer",
        "onSecondaryContainer",
        "tertiary",
        "onTertiary",
        "tertiaryContainer",
        "onTertiaryContainer",
        "background",
        "onBackground",
        "surface",
        "onSurface",
        "surfaceVariant",
        "onSurfaceVariant",
        "surfaceTint",
        "inverseSurface",
        "inverseOnSurface",
        "error",
        "onError",
        "errorContainer",
        "onErrorContainer",
        "outline",
    )

    fun saveLightColorScheme(colorScheme: ColorScheme) {
        saveColorScheme(colorScheme, LIGHT_PREFIX)
    }

    fun saveDarkColorScheme(colorScheme: ColorScheme) {
        saveColorScheme(colorScheme, DARK_PREFIX)
    }

    fun loadLightColorScheme(): ColorScheme {
        return loadColorScheme(LIGHT_PREFIX, lightColorScheme())
    }

    fun loadDarkColorScheme(): ColorScheme {
        return loadColorScheme(DARK_PREFIX, darkColorScheme())
    }

    private fun saveColorScheme(colorScheme: ColorScheme, prefix: String) {
        colorNames.forEach { colorName ->
            val color = getColorFromScheme(colorScheme, colorName)
            prefs.putLong("$prefix$colorName", color.value.toLong())
        }
        prefs.flush()
    }

    private fun loadColorScheme(prefix: String, defaultScheme: ColorScheme): ColorScheme {
        var scheme = defaultScheme
        colorNames.forEach { colorName ->
            val storedValue = prefs.getLong("$prefix$colorName", Long.MIN_VALUE)
            if (storedValue != Long.MIN_VALUE) {
                val color = Color(storedValue.toULong())
                scheme = updateColorScheme(scheme, colorName, color)
            }
        }
        return scheme
    }

    private fun getColorFromScheme(colorScheme: ColorScheme, colorName: String): Color {
        return when (colorName) {
            "primary" -> colorScheme.primary
            "onPrimary" -> colorScheme.onPrimary
            "primaryContainer" -> colorScheme.primaryContainer
            "onPrimaryContainer" -> colorScheme.onPrimaryContainer
            "inversePrimary" -> colorScheme.inversePrimary
            "secondary" -> colorScheme.secondary
            "onSecondary" -> colorScheme.onSecondary
            "secondaryContainer" -> colorScheme.secondaryContainer
            "onSecondaryContainer" -> colorScheme.onSecondaryContainer
            "tertiary" -> colorScheme.tertiary
            "onTertiary" -> colorScheme.onTertiary
            "tertiaryContainer" -> colorScheme.tertiaryContainer
            "onTertiaryContainer" -> colorScheme.onTertiaryContainer
            "background" -> colorScheme.background
            "onBackground" -> colorScheme.onBackground
            "surface" -> colorScheme.surface
            "onSurface" -> colorScheme.onSurface
            "surfaceVariant" -> colorScheme.surfaceVariant
            "onSurfaceVariant" -> colorScheme.onSurfaceVariant
            "surfaceTint" -> colorScheme.surfaceTint
            "inverseSurface" -> colorScheme.inverseSurface
            "inverseOnSurface" -> colorScheme.inverseOnSurface
            "error" -> colorScheme.error
            "onError" -> colorScheme.onError
            "errorContainer" -> colorScheme.errorContainer
            "onErrorContainer" -> colorScheme.onErrorContainer
            "outline" -> colorScheme.outline
            else -> throw IllegalArgumentException("Unknown color name: $colorName")
        }
    }

    private fun updateColorScheme(
        colorScheme: ColorScheme,
        colorName: String,
        color: Color
    ): ColorScheme {
        return when (colorName) {
            "primary" -> colorScheme.copy(primary = color)
            "onPrimary" -> colorScheme.copy(onPrimary = color)
            "primaryContainer" -> colorScheme.copy(primaryContainer = color)
            "onPrimaryContainer" -> colorScheme.copy(onPrimaryContainer = color)
            "inversePrimary" -> colorScheme.copy(inversePrimary = color)
            "secondary" -> colorScheme.copy(secondary = color)
            "onSecondary" -> colorScheme.copy(onSecondary = color)
            "secondaryContainer" -> colorScheme.copy(secondaryContainer = color)
            "onSecondaryContainer" -> colorScheme.copy(onSecondaryContainer = color)
            "tertiary" -> colorScheme.copy(tertiary = color)
            "onTertiary" -> colorScheme.copy(onTertiary = color)
            "tertiaryContainer" -> colorScheme.copy(tertiaryContainer = color)
            "onTertiaryContainer" -> colorScheme.copy(onTertiaryContainer = color)
            "background" -> colorScheme.copy(background = color)
            "onBackground" -> colorScheme.copy(onBackground = color)
            "surface" -> colorScheme.copy(surface = color)
            "onSurface" -> colorScheme.copy(onSurface = color)
            "surfaceVariant" -> colorScheme.copy(surfaceVariant = color)
            "onSurfaceVariant" -> colorScheme.copy(onSurfaceVariant = color)
            "surfaceTint" -> colorScheme.copy(surfaceTint = color)
            "inverseSurface" -> colorScheme.copy(inverseSurface = color)
            "inverseOnSurface" -> colorScheme.copy(inverseOnSurface = color)
            "error" -> colorScheme.copy(error = color)
            "onError" -> colorScheme.copy(onError = color)
            "errorContainer" -> colorScheme.copy(errorContainer = color)
            "onErrorContainer" -> colorScheme.copy(onErrorContainer = color)
            "outline" -> colorScheme.copy(outline = color)
            else -> throw IllegalArgumentException("Unknown color name: $colorName")
        }
    }
}
