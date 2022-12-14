Feature: Automed Operations for Send and Get Local List Version 
As a user, I should make some operations 
Description: Send and Get Local List Version 
	

 Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected

 Scenario Outline: Operations when User send and Get Local List  
  
    And I click on operations V1.6 button
    And I click set Local List Version
    And I select charge point '<ChargePoint>'
    And I Enter List Version '<integer>'
    And I select Get Update Type'<Type>'
    And I select Add Update List '<UpdateList>'
    And I click perform button set local list version
    Then User is on the task result SetLocalListVersion
    And I click on operations V1.6 button
    And I click get Local List Version
    And I select charge point '<ChargePoint>'
    And I click perform button get local list version
    Then User is on the task result GetLocalListVersion
    
    Examples:
     
     | ChargePoint | integer | Type | UpdateList |
     | wiem_pole_real | 61 | FULL |  |
     | wiem_pole_real | 10 | DIFFERENTIAL | 7250939c52dc4d7cb59c |
     | wiem_pole_real | 39 | DIFFERENTIAL | 5c5e6ada |
     | wiem_pole_real | 21 | DIFFERENTIAL | 040f0032 |
     | wiem_pole_real | 11 | DIFFERENTIAL | 4b1f32bb |
     | wiem_pole_real | 60 | DIFFERENTIAL | 5392461f |
     | wiem_pole_real | 59 | DIFFERENTIAL | 9c756eda |
     | wiem_pole_real | 21 | DIFFERENTIAL | A0-00-00-00 |
     | wiem_pole_real | 98 | DIFFERENTIAL | wiem |
     
    
     

     
    
    
  
     
     
     
    