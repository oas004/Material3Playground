package m3components.components

import Material3Playground
import TestTags
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class NavigationBarVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testNavigationBarIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.appBars).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.NavigationBar.regular, false).assertExists()
        }
    }

    @Test
    fun testNavigationBarNoLabelIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.appBars).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.NavigationBar.noLabel, false).assertExists()
        }
    }
}
