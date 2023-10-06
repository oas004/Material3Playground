package m3components.components

import Material3Playground
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class SliderVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testSliderIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.sliders).performClick()
            waitForIdle()
            onNodeWithTag(TestTags.Slider.regular, false).assertIsDisplayed()
        }
    }
}