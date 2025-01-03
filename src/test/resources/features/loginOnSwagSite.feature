@Suite @Login
Feature: Login on SwagLabs website
  As an user
  I want to login on the SwagLabs website
  So I can check all the products that the SwagLabs offers

  Background:
    Given that the user was on the website

  @HappyPath
  Scenario Outline: Successful login on the website
    When attemps to login with credentials
      | user   | pass   |
      | <user> | <pass> |
    Then he will see the title <title> on screen
    Examples:
      | user            | pass         | title        |
      | standard_user   | secret_sauce | Products     |
      | worng_user_name | secret_sauce | Epic sadface |
      |                 |              | Epic sadface |