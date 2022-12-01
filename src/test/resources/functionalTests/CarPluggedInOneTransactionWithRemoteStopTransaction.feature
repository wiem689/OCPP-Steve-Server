Feature: Automed Operations Remote Transaction pluggedIn One Transaction With Stop Remote Transaction
As a user, I should make some operations 
Description: Automation test Remote Transaction PluggedIn  : One Start Transaction AND Stop remote Transaction at the end  With parameter Lock
                                                             to test both of connector-Status "Available" and "Unavailable" 
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then  the user is connected
  

    
  Scenario Outline: Operations pluggedIn One Transaction With Stop Remote Transaction
    And I click on data management charge points button
	  And I select 'wiem_pole' 
    And I click on operations V1.6 button
    And I click get remote start transaction
    And I select charge point 'wiem_pole'
    And I select ConnectorId2 '<ConnectorId>'
    And I select OCPP ID Tag'<OCPPID>'
    And I click remote start transaction perform button'<initState>'
    Then User is on the task result Transaction
    And I click on data management charge points button
	  And I select 'wiem_pole' 
	  And I click on all connector status
	  And I click on operations V1.6 button
    And I click get remote stop transaction
    And I select charge point 'wiem_pole'
    And I select ID of the Active Transaction
    And I click remote stop transaction perform button
    Then User is on the task result after stop transaction
	 
	 
  
 
    Examples:
     
     | ConnectorId | OCPPID | initState | OCPPID2|
     | 1 | 9c756eda | 0 | 040f0032 |
     | 1 | 9c756eda | 1 | 040f0032 |
    
     
    
    
    
 