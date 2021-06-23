package com.randy.bajp2.ui.activities


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.randy.bajp2.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class SplashScreensTest{

    @Before
    fun setUp() {
       ActivityScenario.launch(SplashScreens::class.java)
    }

    @Test
    fun loadSplashScreen() {
        onView(withId(R.id.imageView2)).check(matches(isDisplayed()))
        onView(withText("Design by randy")).check(matches(isDisplayed()))
    }
}