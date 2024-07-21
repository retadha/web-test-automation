@web
Feature: inventory


  Scenario: See default item list
    Given user is on inventory page
    Then user see item list
    And items are sorted by names in ascending order


  Scenario: Sort items based on price in descending order
    Given user is on inventory page
    When user filter items based on "Price (high to low)"
    Then user see item list
    And items are sorted by price in descending order


  Scenario: See product detail
    Given user is on inventory page
    When user click "Sauce Labs Backpack" product
    Then user see product details displayed
