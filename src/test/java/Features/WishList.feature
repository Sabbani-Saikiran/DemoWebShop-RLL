Feature: To Test DemoWebShop Wishlist Functionality

  Background: 
    Given User navigates to the URL demowebshop
    When User performs the login process with credentials
    Then Validate the login is successful or not

  Scenario: User can add and remove products from the wishlist
    Given the user is on the Demo Web Shop homepage
    When the user clicks on "Digital Downloads"
    Then the user adds products to the wishlist
    And the user goes to the Wishlist
    And the user removes a product from the Wishlist
    Then the Wishlist should be updated accordingly