Feature: Driver Certificate

@drive
Scenario: Driver views certificate when not on a trip
Given the driver is not on a trip and on the Main Menu
When they select "view certificate"
Then they should be shown a copy of their certificate

Scenario: Driver views certificate when on a trip
Given that a driver is currently on a trip
When they select "view driver certificate" from Support Menu
Then they should be shown a copy of their certificate
