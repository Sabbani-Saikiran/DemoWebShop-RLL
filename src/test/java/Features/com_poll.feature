Feature: To Test DemoWebshop Community Poll Functionality

  Background: 
    Given User navigate to Url

  Scenario: User to poll with login
    Then User performs Login
    Then User select one option from poll and vote
   

  Scenario: User to poll without Login
    Then User select one option from given poll
    Then Click on vote button

  Scenario: User to poll without selecting anything
    Then Click on vote button directly
