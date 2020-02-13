package com.cvcheck.cucumber.steps

import androidx.test.rule.ActivityTestRule
import com.cvcheck.utils.ActivityFinisher
import com.cvcheck.view.activities.SplashActivity
import com.kater.krs.driver.espresso.login.SplashScreenRobot
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then

class SplashSteps {

    private val robot = SplashScreenRobot()

    private val activityRule = ActivityTestRule(SplashActivity::class.java, false, false)

    @Before
    fun setup() {
        //not needed now, but you may needed to setup mock responses before your screen starts
    }

    @After
    fun tearDown() {
        ActivityFinisher.finishOpenActivities() // Required for test scenarios with multiple activities or scenarios with more cases
    }

    @Given("^I start the splash$")
    fun i_start_app() {
        robot.launchLoginScreen(activityRule)
    }

    @Then("^I expect to see successful name text$")
    fun logo_visible() {
        robot.isSuccessfulLogin()
    }
}
