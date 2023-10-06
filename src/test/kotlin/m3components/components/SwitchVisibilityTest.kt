package m3components.components

import Material3Playground
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class SwitchVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testSwitchIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.switch).performClick()
            waitForIdle()
            onAllNodesWithTag(TestTags.Switch.regular, false).assertCountEquals(2)
        }
    }
}