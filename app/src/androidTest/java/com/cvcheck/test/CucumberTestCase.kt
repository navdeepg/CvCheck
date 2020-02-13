package com.cvcheck.test


import cucumber.api.junit.Cucumber
import cucumber.api.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(plugin = ["pretty"],
        features = ["features"],
        glue = ["com.cvcheck.cucumber.steps"],
        tags = ["@splash"])
@Suppress("unused")
class CucumberTestCase
