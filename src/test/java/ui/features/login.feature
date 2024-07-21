@web
Feature: login


  Scenario: Login
    Given user is on login page
    When user input username on username field with "standard_user"
    And user input password on password field with "secret_sauce"
    And user click login button
    Then user redirect to inventory page


  Scenario: Login without password
    Given user is on login page
    When user input username on username field with "standard_user"
    And user click login button
    Then error message "Epic sadface: Password is required" shows up





