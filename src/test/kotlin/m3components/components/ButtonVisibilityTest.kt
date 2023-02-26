package m3components.components

import Material3Playground
import TestTags
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ButtonVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testIconButtonIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Buttons.icon, false).assertExists()
        }
    }


    @Test
    fun testRegularButtonIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Buttons.regular, false).assertExists()
        }
    }


    @Test
    fun testOutlinedButtonIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Buttons.outlined, false).assertExists()
        }
    }


    @Test
    fun testTextButtonIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Buttons.text, false).assertExists()
        }
    }

    @Test
    fun testFloatingButtonIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Buttons.floating, false).assertExists()
        }
    }


    @Test
    fun testExtendedFloatingButtonIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Buttons.extendedFloating, false).assertExists()
        }
    }


    @Test
    fun testFilledIconButtonIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Buttons.filledIcon, false).assertExists()
        }
    }


    @Test
    fun testIconToggleButtonIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Buttons.iconToggle, false).assertExists()
        }
    }
}
