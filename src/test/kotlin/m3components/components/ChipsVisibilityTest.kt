package m3components.components

import Material3Playground
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ChipsVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testChipIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.chips).performClick()
            waitForIdle()
            onAllNodesWithTag(TestTags.CheckBox.regular, false).assertCountEquals(3)
        }
    }
}