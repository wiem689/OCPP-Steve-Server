Feature: Automed Operations for Clear Cache 
As a user, I should make some operations 
Description: Clear Cache 
	

 Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected

 Scenario: Operations when User on Clear Cache 
  
        And I click on operations V1.6 button
        And I click Clear Cache
        And I select charge point 'wiem_pole_real'
        And I click perform button Clear Cache
        Then User is on the task result Clear Cache
        