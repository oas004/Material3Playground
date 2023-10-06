import androidx.compose.ui.graphics.Color
import org.junit.Assert.*
import org.junit.Test

class FileUtilsKtTest {
    @Test
    fun testGetColorNameFunction() {
        val colorNameLowerCase = "red"
        val color = Color.Red

        val result = getColorKotlinProperty(colorNameLowerCase, color)

        // Assert
        val expected = "val Red: Color = Color(0xFFFF0000) \n"
        assertEquals(expected, result)
    }
}
