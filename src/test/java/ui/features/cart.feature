@web
Feature: cart


  Scenario: Add product to cart
    Given user is on inventory page
    When user add "Sauce Labs Backpack" to cart
    And user add "Sauce Labs Bike Light" to cart
    Then cart badge shown as 2
    And cart page has 2 items


  Scenario: Remove product to cart
    Given user is on inventory page
    And user add "Sauce Labs Backpack" to cart
    And user add "Sauce Labs Bike Light" to cart
    When user remove "Sauce Labs Backpack" from cart
    Then cart badge shown as 1
    And cart page has 1 items

