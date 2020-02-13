package com.kater.krs.driver.espresso.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.cvcheck.R
import com.cvcheck.view.activities.SplashActivity


class SplashScreenRobot {

    fun launchLoginScreen(testRule: ActivityTestRule<SplashActivity>) {
        testRule.launchActivity(null)
    }

    fun isSuccessfulLogin() {
        onView(withId(R.id.txtName)).check(matches(isDisplayed()))
    }
}
