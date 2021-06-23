package com.randy.bajp2.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.randy.bajp2.R
import com.randy.bajp2.ui.activities.MainActivity
import com.randy.bajp2.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

        @Rule
        @JvmField
        var activityRule = ActivityTestRule(MainActivity::class.java, true)

        @Before
        fun setUp() {
            IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource())
        }

        @After
        fun tearDown() {
            IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource())
        }

        @Test
        fun loadMovie() {
            onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
            onView(withId(R.id.nav_movie)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_movie)).apply {
                check(matches(isDisplayed()))
                perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
            }
        }

        @Test
        fun movieBehaviour() {
            onView(withId(R.id.bottom_nav)).check(matches(isDisplayed()))
            onView(withId(R.id.nav_movie)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_movie)).apply {
                perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
                pressBack()
                check(matches(isDisplayed()))
                perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(19, click()))
                pressBack()
            }
        }

    @Test
    fun testDetailMovie() {
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                        click()
            )
        )

        onView(withId(R.id.iv_big_poster))
            .check(matches(isDisplayed()))
        onView(withId(R.id.iv_small_poster))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tv_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_tag_line))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_release))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_score))
            .check(matches(isDisplayed()))


        pressBack()
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
    }


        @Test
        fun loadTvShow() {
            onView(withId(R.id.bottom_nav)).perform(click())
            onView(withId(R.id.nav_tvShow)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_tvShow)).apply {
                check(matches(isDisplayed()))
                perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
            }
        }


        @Test
        fun tvshowBehavior() {
            onView(withId(R.id.bottom_nav)).perform(click())
            onView(withId(R.id.nav_tvShow)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_tvShow)).apply {
                perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
                pressBack()
                check(matches(isDisplayed()))
                perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(19, click()))
                pressBack()
            }
        }

      @Test
      fun testDetailTvShow() {
          onView(withId(R.id.bottom_nav))
              .perform(click())
          onView(withId(R.id.bottom_nav))
              .check(matches(isDisplayed()))
          onView(withId(R.id.nav_tvShow))
              .check(matches(isDisplayed()))
          onView(withId(R.id.rv_tvShow)).perform(
              RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                  0,
                  click()
              )
          )

          onView(withId(R.id.iv_big_poster))
              .check(matches(isDisplayed()))
          onView(withId(R.id.iv_small_poster))
              .check(matches(isDisplayed()))

          onView(withId(R.id.tv_title))
              .check(matches(isDisplayed()))
          onView(withId(R.id.tv_tag_line))
              .check(matches(isDisplayed()))
          onView(withId(R.id.tv_release))
              .check(matches(isDisplayed()))
          onView(withId(R.id.tv_score))
              .check(matches(isDisplayed()))

          onView(withId(R.id.tv_overview))
              .check(matches(isDisplayed()))


          pressBack()
          onView(withId(R.id.rv_tvShow))
              .check(matches(isDisplayed()))
      }

}
