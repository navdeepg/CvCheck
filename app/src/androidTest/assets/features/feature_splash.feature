Feature: Start App

  @splash
  Scenario: Successful Splash
    Given I start the splash
    Then I expect to see successful name text
