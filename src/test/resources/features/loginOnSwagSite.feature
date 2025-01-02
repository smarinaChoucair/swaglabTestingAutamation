@Suite @Login
Feature: Login on SwagLabs website
  As an user
  I want to login on the SwagLabs website
  So I can check all the products that the SwagLabs offers

  Background:
    Given that the user was on the website

  @HappyPath
  Scenario Outline: Successful login on the website
    When attemps to login with the correct credentials
      | user   | pass   |
      | <user> | <pass> |
    And click in the login button
    Then he will see the title <title> on screen
    Examples:
      | user          | pass         | title    |
      | standard_user | secret_sauce | Products |

  @UnhappyPath
  Scenario Outline: Unsuccessful login on the website by incorrect username
    When attemps to login with the wrong username, but correct pass
      | user   | pass   |
      | <user> | <pass> |
    And click in the login button
    Then he will see the error message <error> on screen
    Examples:
      | user            | pass         | error        |
      | worng_user_name | secret_sauce | Epic sadface |

  @UnhappyPath
  Scenario Outline: Unsuccessful login on the website by incorrect password
    When attemps to login with the correct username, but wrong pass
      | user   | pass   |
      | <user> | <pass> |
    And click in the login button
    Then he will see the error message <error> on screen
    Examples:
      | user          | pass  | error        |
      | standard_user | 12341 | Epic sadface |

  @UnhappyPath1
  Scenario Outline: Unsuccessful login on the website with no credentials
    When attemps to login with no credentials
    And click in the login button
    Then he will see the error message <error> on screen
    Examples:
      | error        |
      | Epic sadface |