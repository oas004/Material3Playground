package m3components.components

import Material3Playground
import TestTags
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class NavRailButtonTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testNavRailIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.Components.navRail, false).assertExists()
        }
    }


    @Test
    fun testNavRailButtonsIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.buttons, false).assertExists()
        }
    }

    @Test
    fun testNavRailAppBarIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.appBars, false).assertExists()
        }
    }

    @Test
    fun testNavRailCardsIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.cards, false).assertExists()
        }
    }

    @Test
    fun testNavRailTextFieldIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.textFields, false).assertExists()
        }
    }

    @Test
    fun testNavRailChipsIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.chips, false).assertExists()
        }
    }

    @Test
    fun testNavRailSwitchIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.switch, false).assertExists()
        }
    }

    @Test
    fun testNavRailCheckBoxIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.checkBox, false).assertExists()
        }
    }

    @Test
    fun testNavRailSlidersIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.sliders, false).assertExists()
        }
    }

    @Test
    fun testNavRailProgressBarIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.progressBar, false).assertExists()
        }
    }
    @Test
    fun testNavRailDividerIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.dividers, false).assertExists()
        }
    }
}
