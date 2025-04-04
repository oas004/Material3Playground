package m3components.components

import Material3Playground
import TestTags
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TopAppBarVisibilityTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testSmallAppBarIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.appBars).performClick()
            waitForIdle()
            assertTopAppBarDisplayed(
                navigationIconTestTag = TestTags.TopAppBar.navigationIconSmall,
                appBarTestTag = TestTags.TopAppBar.small
            )
        }
    }

    @Test
    fun testCenterAlignedAppBarIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.appBars).performClick()
            waitForIdle()
            assertTopAppBarDisplayed(
                navigationIconTestTag = TestTags.TopAppBar.navigationIconCenterAligned,
                appBarTestTag = TestTags.TopAppBar.centerAligned
            )
        }
    }

    @Test
    fun testSmallAppBarWithScrollStateIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.appBars).performClick()
            waitForIdle()
            assertTopAppBarDisplayed(
                navigationIconTestTag = TestTags.TopAppBar.navigationIconsmallScroll,
                appBarTestTag = TestTags.TopAppBar.smallScroll
            )
        }
    }

    @Test
    fun testCenterAlignedAppBarWithScrollStateIsPresent() {
        rule.apply {
            setContent {
                Material3Playground(false)
            }
            waitForIdle()
            onNodeWithTag(TestTags.NavRailButtons.appBars).performClick()
            waitForIdle()
            assertTopAppBarDisplayed(
                navigationIconTestTag = TestTags.TopAppBar.navigationIconCenterAlignedScroll,
                appBarTestTag = TestTags.TopAppBar.centerAlignedScroll
            )
        }
    }
}

private fun SemanticsNodeInteractionsProvider.assertTopAppBarDisplayed(
    navigationIconTestTag: String,
    appBarTestTag: String
) {
    onNodeWithTag(navigationIconTestTag, false).assertIsDisplayed()
    onNodeWithTag(appBarTestTag, false).assertIsDisplayed()
}