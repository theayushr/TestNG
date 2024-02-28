@tag
Feature: Purchase the orders from my website

  Background:
    Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive test of purchasing the order
    Given Login with username <Name> and password <Password>
    When I add product to the cart
    And Checkout and submit the order
    Then ThankYou message is displayed

    Examples:
      | Name                      | Password    |
      | ayush3338@mailinator.com  | TestNG@3338 |


