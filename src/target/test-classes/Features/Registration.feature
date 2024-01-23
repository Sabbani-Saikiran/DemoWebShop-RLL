Feature: Test the Register functionality
Scenario Outline: Register user with different data
    Given the user is on the home page
    When the user clicks on the register link
    And the user selects gender
    And the user enters First Name from Excel <RowNumber>
    And the user enters Last Name from Excel <RowNumber>
    And the user enters email from Excel <RowNumber>
    And the user enters password from Excel <RowNumber>
    And the user enters confirm password from Excel <RowNumber>
    And the user clicks on register
    Then the registration should be successful or not

Examples:
    | RowNumber |
    | 0         |
    | 1         |
    | 2         |
    | 3         |
    | 4         |  