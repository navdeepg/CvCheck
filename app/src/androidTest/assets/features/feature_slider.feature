  @login
Feature: Check Slider Screens

  Scenario: Check Go Online Slider Screen
    Given I start the application
    When I swipe left
    Then I expect to see the Go Online Slider Screen

  Scenario: Check Receive Assignment Slider Screen
    Given I am on the Go Online Slider Screen
    When I swipe left
    Then I expect to see the Receive Assignment Slider Screen

  Scenario: Check Track Trips Slider Screen
    Given I am on the Receive Assignment Slider Screen
    When I swipe left
    Then I expect to see the Track Trips Slider Screen

  Scenario: Check Login Screen
    Given I am on the Track Trips Slider Screen
    When I press the back button
    Then I expect to see the Login Slider Screen