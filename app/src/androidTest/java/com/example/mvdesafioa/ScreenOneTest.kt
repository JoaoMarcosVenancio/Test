package com.example.mvdesafioa

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ScreenOneTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun isEditTextFunctional() {
        onView(withId(R.id.edtCamp)).check(matches(ViewMatchers.isEnabled()))
    }

    @Test
    fun isAlertWorking() {
        onView(withId(R.id.edtCamp)).perform(ViewActions.clearText())
        onView(withId(R.id.btnView)).perform(ViewActions.click())
        onView(withText(R.string.empty_camp)).check(matches(isDisplayed()))
    }

}