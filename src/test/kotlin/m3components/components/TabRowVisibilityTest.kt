package m3components.components

import Material3Playground
import TestTags
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TabRowVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testTabRowIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.appBars).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.TabRow.regular, false).assertExists()
        }
    }
}
