@MoisturizerPurchasing

Feature: MoisturizerPurchasing
  Description: This feature is to test different widget view modes functionality across the widget

  Background:
    Given user opens the weathershopper page

  Scenario: Verify_MoisturizerPurchasing

    And  checks the temperature is "below" than 19
    And  user clicks on "Buy Moisturizers"
    Then user is landed to the "Moisturizers" page
    And  user selects "Moisturizer" with "Aloe"
    And  user verifies the price is the least
    And  user selects "Moisturizer" with "Almond"
    And  user verifies the price is the least
    When user clicks on "Cart"
    Then user verifies the products are in the cart
    When user clicks on "Pay with card"
    Then Strip "Pop up" shows up
    And  user enters "email" and "card data"
    When user clicks on "Pay"
    Then user sees the "success" window

  Scenario: Verify_SunScreenPurchasing

    And  checks the temperature is "above" than 34
    And  user clicks on "Buy Sunscreens"
    Then user is landed to the "Sunscreens" page
    And  user selects "Sunscreen" with "SPF-50"
    And  user verifies the price is the least
    And  user selects "Sunscreen" with "SPF-30"
    And  user verifies the price is the least
    When user clicks on "Cart"
    Then user verifies the products are in the cart
    When user clicks on "Pay with card"
    Then Strip "Pop up" shows up
    And  user enters "email" and "card data"
    When user clicks on "Pay"
    Then user sees the "success" window



