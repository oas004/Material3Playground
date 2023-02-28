package m3components.components

import Material3Playground
import TestTags
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CardVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testOutlinedCardIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.cards).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Cards.outlined, false).assertExists()
        }
    }


    @Test
    fun testElevatedCardIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.cards).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Cards.elevated, false).assertExists()
        }
    }

    @Test
    fun testFilledCardIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.cards).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Cards.filled, false).assertExists()
        }
    }
}