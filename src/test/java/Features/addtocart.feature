Feature: To Test DemowebShop Add/Remove from cart functionality

  Background: 
    Given User navigates to the URL
    When User performs the login process
    Then Validate the login is successful

  Scenario: User confirms all books with "AddToCart" button
    And User clicks on book menu
    Then User validates whether all books have addtocart button

  Scenario: User adds the third book to the cart
    Given User clicks on book menu
    And User add third book to cart
    Then Validate the third book is successfully added to the cart

  Scenario: User adds and deletes products from the cart
    Given User clicks on book menu
    And User adds any 3 products to the cart
    And User deletes any two products from the cart
    Then Validate the cart after deleting the products
