@Suite @BuyE2E
Feature: Buy on SwagLabs Website
  As an user
  I want to make a buy on SwagLabs website
  So I can see the purchase message at the end

  Background:

  @Login
  Scenario Outline: Successful login on the website
    Given that the user was on the website
    When attemps to login with the correct credentials
      | user   | pass   |
      | <user> | <pass> |
    Then he will see the title <title> on screen
    Examples:
      | user          | pass         | title    |
      | standard_user | secret_sauce | Products |

  @Buy
  Scenario Outline: Successful purchase on the website
    When adds some <product> to the cart
    And checks that exactly <product> is on the cart
    When fills the checkout personal information fields
      | firstName   | lastName   | postalCode   |
      | <firstName> | <lastName> | <postalCode> |
    Then he will see the title <message> on screen
    Examples:
      | product             | firstName     | lastName      | postalCode | message                  |
      | Sauce Labs Backpack | standard_user | standard_user | 12345      | THANK YOU FOR YOUR ORDER |



