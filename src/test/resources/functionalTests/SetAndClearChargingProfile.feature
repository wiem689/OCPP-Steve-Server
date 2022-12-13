Feature: Automed Operations for Charging Profile
As a user, I should make some operations 
Description: Clear and Set Charging Profile
	

 Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected

 Scenario Outline: Operations when User on Clear and Set Charging Profile  
 
    And I click on operations V1.6 button
    And I click Clear Charging Profile
    And I select charge point 'wiem_pole_real'
    And I select Filter Type '<filterType>'
    And I select Charging Profile ID '<ChargingProfile>'
    And I click perform button Clear Charging Profile
    Then User is on the task result Clear Charging Profile
    And I click on operations V1.6 button
    And I click Set Charging Profile
    And I select charge point 'wiem_pole_real'
    And I select Charging Profile ID '<ChargingProfile>'
    And I select connecter ID as '<ConnectorId>'
    And I click perform button Set Charging Profile
    Then User is on the task result Set Charging Profile
    And I click on operations V1.6 button
    And I click Get Composite Schedule
    And I select charge point 'wiem_pole_real'
    And I select connecter ID as '<ConnectorId>'
    And I Enter Composite Schedule '<Duration>' 
    And I select Charging Rate Unit '<Unit>'
    And I click perform button get composite schedule
    And User is on the task result get composite schedule
    Then I click details button get Composite Schedule
    
    
    Examples:
     
     | filterType | ChargingProfile | ConnectorId | Duration | Unit |
     | ChargingProfileId | 3 (WIEM TEST) | 0 | 172800 | A |
     
     
     
     
     
     
     
     
     
     
     