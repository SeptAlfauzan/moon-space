package com.septalfauzan.moonspace

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.septalfauzan.moonspace.core.presentation.ui.ScheduleAdapter

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HomeScreenTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun check_searchbar_showed() {
        Espresso.onView(withId(R.id.searchLaunched)).check(
            matches(
                isDisplayed()
            )
        )
    }

    @Test
    fun check_drawer_navigation_menu_displyed() {
        val drawerButton = Espresso.onView(withContentDescription(R.string.navigation_drawer_open))
        drawerButton.check(
            matches(
                isDisplayed()
            )
        )
        drawerButton.perform(ViewActions.click())

        val homeMenu = Espresso.onView(withId(R.id.nav_home))
        val bookmarkMenu = Espresso.onView(withId(R.id.nav_bookmark))
        val launchedMapMenu = Espresso.onView(withId(R.id.nav_launch_location))

        homeMenu.check(matches(isDisplayed()))
        bookmarkMenu.check(matches(isDisplayed()))
        launchedMapMenu.check(matches(isDisplayed()))
    }

    @Test
    fun check_rv_is_displayed(){
        val rvContainter = Espresso.onView(withId(R.id.rv_container))

        Thread.sleep(1000)
        rvContainter.check(matches(isDisplayed()))
    }

    @Test
    fun check_rv_item_is_displayed(){
        val rvContainer = Espresso.onView(withId(R.id.rv_container))
        Thread.sleep(1000)
        rvContainer.check(matches(isDisplayed()))
        val itemTitle = "Falcon 9 Block 5 | Starlink Group 7-5"

        rvContainer.perform(RecyclerViewActions.scrollTo<ScheduleAdapter.ListViewHolder>(hasDescendant(withText(itemTitle))))
    }
}