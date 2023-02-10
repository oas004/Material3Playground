import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
internal fun ThemeColorPicker(
    modifier: Modifier = Modifier,
    colorName: String,
    currentColor: Color,
    onColorPicked: (colorName: String, pickedColor: Color) -> Unit,
    recentlyUsedColors: List<Color> = listOf(),
) {
    var isDialogVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier then Modifier.clickable { isDialogVisible = true }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(40.dp)
                .background(color = currentColor)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        M3OnSurfaceText(
            text = colorName,
            style = MaterialTheme.typography.titleMedium
        )
    }

    Dialog(
        visible = isDialogVisible,
        onCloseRequest = { isDialogVisible = false },
        title = colorName,
    ) {
        ColorPickerDialogContent(
            currentColor,
            onOkClicked = { pickedColor ->
                // Update the color palette and hide the dialog
                onColorPicked(colorName, pickedColor)
                isDialogVisible = false
            },
            recentlyUsedColors = recentlyUsedColors
        )
    }
}
@Composable
private fun ColorPickerDialogContent(
    currentColor: Color,
    onOkClicked: (pickedColor: Color) -> Unit,
    modifier: Modifier = Modifier,
    recentlyUsedColors: List<Color> = listOf(),
) {
    var pickedColor by remember { mutableStateOf(currentColor) }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(80.dp)
                .background(color = pickedColor)
                .clip(shape = RoundedCornerShape(8.dp))
        )

        Spacer(Modifier.size(8.dp))

        val currentColorHexString = currentColor.value.toString(16).substring(0, 8)
        val text = remember { mutableStateOf("#$currentColorHexString") }

        TextField(
            modifier = Modifier.width(120.dp),
            value = text.value,
            onValueChange = {
                text.value = it

                val newColor = getColorFromText(it)
                if (newColor != null) pickedColor = newColor
            },
            placeholder = { Text("Please enter a color hex") }
        )

        Spacer(modifier = Modifier.size(16.dp))

        if (recentlyUsedColors.isNotEmpty()) {
            M3OnSurfaceText(
                "Recently used colors",
                MaterialTheme.typography.labelSmall
            )

            RecentlyUsedColors(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                colors = recentlyUsedColors,
                onColorClick = {
                    text.value = it.hexCode
                    val newColor = getColorFromText(it.hexCode)
                    if (newColor != null) pickedColor = newColor
                }
            )
        }

        Spacer(modifier = Modifier.size(32.dp))

        Button(
            onClick = { onOkClicked(pickedColor) }
        ) {
            Text("OK")
        }
    }
}

@Composable
fun M3OnSurfaceText(
    text: String,
    style: TextStyle,
) {
    Text(
        color = MaterialTheme.colorScheme.onSurface,
        text = text,
        style = style,
    )
}

@Composable
private fun RecentlyUsedColors(
    colors: List<Color>,
    onColorClick: (color: Color) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        colors.forEach {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .padding(8.dp)
                    .clickable { onColorClick(it) }
                    .clip(CircleShape)
                    .background(it)
            )
        }
    }
}

private fun getColorFromText(hexCode: String): Color? {
    return try {
        val hexString = hexCode.removePrefix("#").lowercase()
        val updatedHexString = if (hexString.length == 6) "ff$hexString" else hexString

        Color(updatedHexString.toLong(16))
    } catch (e: Exception) {
        null
    }
}

private val Color.hexCode: String
    get() = String.format("#%08X", toArgb())