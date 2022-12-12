Feature: Automed Operations for Send With Delete and Get Local List Version 
As a user, I should make some operations 
Description: Send With Delete  and Get Local List Version 
	

 Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected

 Scenario Outline: Operations when User send With Delete and Get Local List  
  
    And I click on operations V1.6 button
    And I click set Local List Version
    And I select charge point '<ChargePoint>'
    And I Enter List Version '<integer>'
    And I select Get Update Type'<Type>'
    And I select Delete List '<DeleteList>'
    And I click perform button set local list version
    Then User is on the task result SetLocalListVersion
    And I click on operations V1.6 button
    And I click get Local List Version
    And I select charge point '<ChargePoint>'
    And I click perform button get local list version
    Then User is on the task result GetLocalListVersion
    
    Examples:
     
     | ChargePoint | integer | Type | DeleteList |
     | wiem_pole_real | 10 | DIFFERENTIAL | 7250939c52dc4d7cb59c |
     | wiem_pole_real | 10 | DIFFERENTIAL | 5392461f |
 
    
    
     

     
    
    
  
     
     
     
    