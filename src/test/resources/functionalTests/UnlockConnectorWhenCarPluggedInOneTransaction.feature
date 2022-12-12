Feature: Automed Operations Remote Transaction pluggedIn One Transaction with Unlock Connector
As a user, I should make some operations 
Description: Automation test Remote Transaction PluggedIn  : One Start Transaction AND Unlock Connector at the end  With parameter Lock 
to test both of connector-Status "Available" and "Unavailable" 
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then  the user is connected
  

    
  Scenario Outline: Operations to Get remote transaction Transaction pluggedIn One Start Transaction AND Unlock Connector
    And I click on data management charge points button
	  And I select 'wiem_trydan' 
    And I click on operations V1.6 button
    And I click get remote start transaction
    And I select charge point 'wiem_trydan'
    And I select ConnectorId2 '<ConnectorId>'
    And I select OCPP ID Tag'<OCPPID>'
    And I click remote start transaction perform button'<ConnectorState>'
    Then User is on the task result Transaction
    And I click on data management charge points button
	  And I select 'wiem_trydan' 
	  And I click on all connector status
	  And I click on operations V1.6 button
    And I click get Unlock Connector
    And I select charge point 'wiem_trydan' 
    And I select ConnectorId2 '1'
    And I click unlock connector perform button
    Then User is on the task result Unlock Transaction
	 
	 
  
 
    Examples:
     
     | ConnectorId | OCPPID | ConnectorState | OCPPID2|
     | 1 | 9c756eda | 0 | 040f0032 |
     | 1 | 9c756eda | 1 | 040f0032 |
    
     
    
    
    
 