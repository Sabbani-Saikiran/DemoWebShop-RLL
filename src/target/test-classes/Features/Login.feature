Feature: Login functionality

  Scenario Outline: User login with different credentials
    Given user navigates to the login page
    When user enters '<email>' and '<password>'
    And clicks the login button
    Then Message Should Be Displayed '<loginResult>'

  Examples:
    | email                         	 | password       			| loginResult           			|
    | sameena1@gmail.com        			 | sam@12345 			    	| logged_in_successfully			|
    | sam@gmail.com            		 		 | sam@12345			 			| incorrect email or Password |
    | sameena1@gmail.com    		 			 | 1234       					| incorrect email or Password |
    | sameena@gmail.com  				       | 12345								| incorrect email or Password |
    |                              		 |               			  | incorrect email or Password |