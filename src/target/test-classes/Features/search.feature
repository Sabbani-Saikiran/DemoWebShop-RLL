Feature: Search Functionality

  Scenario: Handle Pop-up
    Given the user is on the search page
    When the user clicks the search button
    Then the user dismisses the pop-up

  Scenario: Perform Search
    Given the user is on the search page
  	When the user performs a search with data from Excel sheet "<search_term>"
    Then the search results should be displayed for "<search_term>"

 






   