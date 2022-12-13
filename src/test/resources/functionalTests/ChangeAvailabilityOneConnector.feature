Feature: Automed Operations one Connector
As a user, I should make some operations 
Description: Automation test for one Connector
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected
 

 
    Scenario Outline: Operations when we have One Connectors
     And I click on data management charge points button
	   And I select 'wiem_pole_real' 
     And I click on operations V1.6 button
     And I select charge point 'wiem_pole_real'
     And I select connecter ID as '<connectorId>'
     And I select availability Type as '<availability>'
     And I click perform button change availability with Initial State as '<initialState>'
     Then User is on the task result
     
    
     Examples:
     
     | connectorId | availability | initialState |
     | 0 | OPERATIVE | 0|
     | 0 | OPERATIVE | 1|
         
     Examples:
     
     | connectorId | availability | initialState |
     | 0 | INOPERATIVE | 0|
     | 0 | INOPERATIVE | 1|
     
     
     
     Examples:
     
     | connectorId | availability | initialState |
     | 1 | OPERATIVE | 0|
     | 1 | OPERATIVE | 1|
     
     
      Examples:
     
     | connectorId | availability | initialState |
     | 1 | INOPERATIVE | 0|
     | 1 | INOPERATIVE | 1|
          
    
     