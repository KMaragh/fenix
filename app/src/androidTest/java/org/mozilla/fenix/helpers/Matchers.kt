/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.helpers

import android.view.View
import android.widget.TextView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import java.util.regex.Pattern
import androidx.test.espresso.matcher.ViewMatchers.isChecked as espressoIsChecked
import androidx.test.espresso.matcher.ViewMatchers.isEnabled as espressoIsEnabled
import androidx.test.espresso.matcher.ViewMatchers.isSelected as espressoIsSelected

/**
 * The [espressoIsEnabled] function that can also handle disabled state through the boolean argument.
 */
fun isEnabled(isEnabled: Boolean): Matcher<View> = maybeInvertMatcher(espressoIsEnabled(), isEnabled)

/**
 * The [espressoIsChecked] function that can also handle unchecked state through the boolean argument.
 */
fun isChecked(isChecked: Boolean): Matcher<View> = maybeInvertMatcher(espressoIsChecked(), isChecked)

/**
 * The [espressoIsSelected] function that can also handle not selected state through the boolean argument.
 */
fun isSelected(isSelected: Boolean): Matcher<View> = maybeInvertMatcher(espressoIsSelected(), isSelected)

private fun maybeInvertMatcher(matcher: Matcher<View>, useUnmodifiedMatcher: Boolean): Matcher<View> = when {
    useUnmodifiedMatcher -> matcher
    else -> not(matcher)
}

/**
 * The [matchDatePattern] function will match a date pattern following this format: "Wednesday 10/16 @ 12:09 PM".
 */
//fun matchDatePattern() = withPattern(dateRegex)

fun withPattern(regex: String): Matcher<View>? = RegexMatcherForTextView(regex)

class RegexMatcherForTextView(private val regex: String) : BoundedMatcher<View, TextView>(TextView::class.java) {
    private val pattern = Pattern.compile(regex)

    override fun describeTo(description: Description?) {
        description?.appendText("Checking the matcher on received view: with pattern=$regex")
    }

    override fun matchesSafely(item: TextView?) : Boolean {
        return item?.text?.let {
            pattern.matcher(it).matches()
        } ?: false
    }

}
