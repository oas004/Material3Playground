package m3components.components

import Material3Playground
import TestTags
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class SaveFileDialogTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testAlertDialogIsNotOpenAtDefault() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.FileSaverDialog.dialog).assertDoesNotExist()
        }
    }
}