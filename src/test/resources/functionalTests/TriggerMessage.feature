Feature: Automed Operations for Trigger Message 
As a user, I should make some operations 
Description: Trigger Message Test
	

 Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected

 Scenario Outline: Operations when User on Trigger Message  
    
    And I click on operations V1.6 button
    And I click Get Trigger Message
    And I select charge point 'wiem_pole_real'
    And I select Trigger Message '<TriggerMessage>'
    And I select connecter ID as '<ConnectorId>'
    And I click perform button put trigger msg
    Then User is on the task result Trigger Message
    
    
    Examples:
     
     | TriggerMessage | ConnectorId |
     |BootNotification|1|
     |DiagnosticsStatusNotification|1|
     |FirmwareStatusNotification|1|
     |Heartbeat|1|
     |MeterValues|1|
     |StatusNotification|1|
     
     
     
     