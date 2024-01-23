@all
Feature: Test DemoWebShop page Test

  Scenario Outline: Testing of News Letter Subscription Page
    Given I am on DemoWebShop Homepage launching url
    When I will be on Login Page and Capture the title of the page
    Then I click on login link
    And I entered email id on the page
    And I entered password on the page
    And I click on Login button
    And I click on sign up for our newsletter '<signup_emailid>'
    And I click on Subscribe
    And i get the result block
    And I logout

    Examples: 
      | signup_emailid         |
      | saikirandemo@gmail.com |
      |                1111111 |
      | ssssssgmail.com        |
      | demouser@yahoo.com     |
      | abcdefg@gmail1.com     |
      |                        |
