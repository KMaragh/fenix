/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

@file:Suppress("TooManyFunctions")

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import org.hamcrest.CoreMatchers
import org.mozilla.fenix.helpers.TestHelper
import org.mozilla.fenix.helpers.click


/**
 * Implementation of Robot Pattern for the settings menu.
 */
class SettingsRobot {

    // BASICS SECTION
    fun verifyBasicsHeading() = assertBasicsHeading()
    fun verifySearchEngineButton() = assertSearchEngineButton()
    fun verifyThemeButton() = assertThemeButton()
    fun verifyThemeSelected() = assertThemeSelected()
    fun verifyAccessibilityButton() = assertAccessibilityButton()
    fun verifySetAsDefaultBrowserButton() = assertSetAsDefaultBrowserButton()

    // PRIVACY SECTION
    fun verifyPrivacyHeading() = assertPrivacyHeading()
    fun verifyEnhancedTrackingProtectionButton() = assertEnhancedTrackingProtectionButton()
    fun verifyEnhancedTrackingProtectionValue() = assertEnhancedTrackingProtectionValue()
    fun verifyAddPrivateBrowsingShortcutButton() = assertAddPrivateBrowsingShortcutButton()
    fun verifySitePermissionsButton() = assertSitePermissionsButton()
    fun verifyDeleteBrowsingDataButton() = assertDeleteBrowsingDataButton()
    fun verifyDeleteBrowsingDataOnQuitButton() = assertDeleteBrowsingDataOnQuitButton()
    fun verifyDataCollectionButton() = assertDataCollectionButton()
    fun verifyPrivacyNoticeButton() = assertPrivacyNoticeButton()
    fun verifyLeakCanaryButton() = assertLeakCanaryButton()
    fun verifySettingsView() = assertSettingsView()

    // DEVELOPER TOOLS SECTION
    fun verifyDeveloperToolsHeading() = assertDeveloperToolsHeading()
    fun verifyRemoteDebug() = assertRemoteDebug()

    // ABOUT SECTION
    fun verifyAboutHeading() = assertAboutHeading()
    fun verifyHelp() = assertHelp()
    fun verifyRateOnGooglePlay() = assertRateOnGooglePlay()
    fun verifyAboutFirefoxPreview() = assertAboutFirefoxPreview()

    class Transition {

        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun goBack(interact: HomeScreenRobot.() -> Unit): HomeScreenRobot.Transition {

            mDevice.waitForIdle()
            goBackButton().click()

            HomeScreenRobot().interact()
            return HomeScreenRobot.Transition()
        }

        fun clickOnHelpButton(interact: BrowserRobot.() -> Unit): BrowserRobot.Transition {

            mDevice.waitForIdle()
            assertHelp().click()

            BrowserRobot().interact()
            return BrowserRobot.Transition()
        }

        fun clickOnRateButton(interact: BrowserRobot.() -> Unit): BrowserRobot.Transition {

            mDevice.waitForIdle()
            assertRateOnGooglePlay().click()

            BrowserRobot().interact()
            return BrowserRobot.Transition()
        }

        fun clickOnAboutFirefoxPreview(interact: AboutFirefoxPreviewRobot.() -> Unit): AboutFirefoxPreviewRobot.Transition {

            mDevice.waitForIdle()
            assertAboutFirefoxPreview().click()

            AboutFirefoxPreviewRobot().interact()
            return AboutFirefoxPreviewRobot.Transition()
        }
    }
}

private fun assertSettingsView() {
    // verify that we are in the correct library view
    assertBasicsHeading()
    assertPrivacyHeading()
    assertDeveloperToolsHeading()
    assertAboutHeading()
}

// BASICS SECTION
private fun assertBasicsHeading() = onView(ViewMatchers.withText("Basics"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertSearchEngineButton() {
    onView(ViewMatchers.withText("Search"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertThemeButton() = onView(ViewMatchers.withText("Theme"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertThemeSelected() = onView(ViewMatchers.withText("Light"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertAccessibilityButton() = onView(ViewMatchers.withText("Accessibility"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertSetAsDefaultBrowserButton() = onView(ViewMatchers.withText("Set as default browser"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

// PRIVACY SECTION
private fun assertPrivacyHeading() {
    onView(ViewMatchers.withText("Privacy"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertEnhancedTrackingProtectionButton() = onView(ViewMatchers.withText("Enhanced Tracking Protection"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertEnhancedTrackingProtectionValue() = onView(ViewMatchers.withText("On"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertAddPrivateBrowsingShortcutButton() = onView(ViewMatchers.withText("Add private browsing shortcut"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertSitePermissionsButton() {
    TestHelper.scrollToElementByText("Site permissions")
    onView(ViewMatchers.withText("Site permissions"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertDeleteBrowsingDataButton() = onView(ViewMatchers.withText("Delete browsing data"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertDeleteBrowsingDataOnQuitButton() = onView(ViewMatchers.withText("Delete browsing data on quit"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertDataCollectionButton() = onView(ViewMatchers.withText("Data collection"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertPrivacyNoticeButton() = onView(ViewMatchers.withText("Privacy notice"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
private fun assertLeakCanaryButton() = onView(ViewMatchers.withText("LeakCanary"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

// DEVELOPER TOOLS SECTION
private fun assertDeveloperToolsHeading() {
    TestHelper.scrollToElementByText("Developer tools")
    onView(ViewMatchers.withText("Developer tools"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertRemoteDebug() = onView(ViewMatchers.withText("Remote debugging via USB"))
    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

// ABOUT SECTION

private fun assertTextIsVisible(text: String): ViewInteraction {
    TestHelper.scrollToElementByText(text)
    return onView(ViewMatchers.withText(text))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}
private fun assertAboutHeading(): ViewInteraction {
    return assertTextIsVisible("About")
}
private fun assertHelp(): ViewInteraction {
    return assertTextIsVisible("Help")
}
private fun assertRateOnGooglePlay(): ViewInteraction {
    return assertTextIsVisible("Rate on Google Play")
}
private fun assertAboutFirefoxPreview(): ViewInteraction {
    return assertTextIsVisible("About Firefox Preview")
}

private fun goBackButton() = onView(CoreMatchers.allOf(ViewMatchers.withContentDescription("Navigate up")))

//private fun helpButton() : ViewInteraction {
//    TestHelper.scrollToElementByText("Help")
//    return onView(ViewMatchers.withText("Help"))
//}

//private fun rateButton() : ViewInteraction {
//    TestHelper.scrollToElementByText("Rate on Google Play")
//    return onView(ViewMatchers.withText("Rate on Google Play"))
//}

//private fun aboutFirefoxPreviewButton() : ViewInteraction {
//    TestHelper.scrollToElementByText("About Firefox Preview")
//    return onView(ViewMatchers.withText("About Firefox Preview"))
//}