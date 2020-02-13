Feature: Enter login details

  @login
  Scenario Outline: Successful login
    Given I start the application
    When I click email field
    And I enter valid email <email>
    And I close the keyboard
    And I click password field
    And I enter valid password <password>
    And I close the keyboard
    And I click sign in button
    Then I expect to see successful login message
    Examples:
      | email                    | password       |
#      | newkaterer+autotest1@kater.com| test |
      | the@email.com            | ultimatesecret |
      | great-driver@example.com | nobrakes666    |