package com.cvcheck.test

import cucumber.api.CucumberOptions

@CucumberOptions(plugin = ["pretty"],
        features = ["features"],
        glue = ["com.cvcheck.cucumber.steps"],
        tags = ["@splash"])
@Suppress("unused")
class CucumberTestCase
