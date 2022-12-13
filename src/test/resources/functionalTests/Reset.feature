Feature: Automed Operations for Reset 
As a user, I should make some operations 
Description: Reset 
	

 Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected

  Scenario Outline: Operations when User on Reset
  
    And I click on operations V1.6 button
    And I click get remote reset
    And I select charge point 'wiem_pole_real' 
    And I select Reset Type'<type>'
    And I click reset perform button
    Then User is on the task result Reset
    
        Examples:
     
     | type | 
     | HARD | 
     | SOFT |
    
        