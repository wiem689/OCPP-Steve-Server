Feature: Automed Operations Remote Start Transaction Connector UnpluggedIn to the car 
As a user, I should make some operations 
Description: Automation test Remote Start Transaction UnpluggedIn
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected
  

    
  Scenario Outline: Operations to Get remote Start Transaction connector and car UnpluggedIn
    And I click on data management charge points button
	  And I select 'wiem_trydan' 
    And I click on operations V1.6 button
    And I click get remote start transaction
    And I select charge point 'wiem_trydan'
    And I select ConnectorId2 '<ConnectorId>'
    And I select OCPP ID Tag'<OCPPID>'
    And I click remote start transaction perform button'<initState>'
    Then User is on the task result Transaction
    And I click on data management charge points button
	  And I select 'wiem_trydan' 
	  And I click on all connector status
	  And I click on data management charge points button
	  And I select 'wiem_trydan' 
	  And I click on all connector status
	 
  
 
    Examples:
     
     | ConnectorId | OCPPID | initState |
     | 1 | 5c5e6ada | 0 |
     | 1 | 5c5e6ada | 1 |
    
     
    
    
    
 