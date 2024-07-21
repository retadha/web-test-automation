@web
Feature: checkout
  # Will fail
#  Scenario: Checkout with empty cart
#    Given user is on cart page
#    And cart is empty
#    When user checkout
#    Then checkout error message "Your cart is still empty" shows up


  Scenario: Fill checkout form without last name
    Given user is on inventory page
    And user add "Sauce Labs Backpack" to cart
    And user is on cart page
    And user checkout
    When user input first name on checkout form with "first name"
    And user input postal code on checkout form with "1612"
    And user click continue checkout
    Then checkout error message "Error: Last Name is required" shows up

  Scenario: Fill checkout form
    Given user is on inventory page
    And user add "Sauce Labs Backpack" to cart
    And user add "Sauce Labs Bike Light" to cart
    And user is on cart page
    And user checkout
    When user input first name on checkout form with "first name"
    And user input last name on checkout form with "last name"
    And user input postal code on checkout form with "1612"
    And user click continue checkout
    Then user see checkout detail
    And checkout detail has 2 items

  Scenario: Complete Checkout
    Given user is on inventory page
    And user add "Sauce Labs Backpack" to cart
    And user add "Sauce Labs Bike Light" to cart
    And user is on cart page
    When user checkout
    And user input first name on checkout form with "first name"
    And user input last name on checkout form with "last name"
    And user input postal code on checkout form with "1612"
    And user click continue checkout
    And user click finish checkout
    Then user see checkout complete message "Your order has been dispatched, and will arrive just as fast as the pony can get there!"

