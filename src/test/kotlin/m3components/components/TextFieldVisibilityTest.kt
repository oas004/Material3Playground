package m3components.components

import Material3Playground
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TextFieldVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testRegularTextFieldIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.textFields).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.TextField.regular, false).assertIsDisplayed()
        }
    }

    @Test
    fun testErrorTextFieldIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.textFields).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.TextField.error, false).assertIsDisplayed()
            onNodeWithTag(TestTags.TextField.errorLabel, false).assertIsDisplayed()
        }
    }
}