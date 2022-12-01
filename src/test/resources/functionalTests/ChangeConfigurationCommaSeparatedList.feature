Feature: Automed Operations Change Configuration
As a user, I should make some operations 
	Description: Automation test Change Configuration for Comma Separated Keys 
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected
 


  Scenario Outline: Operations when User In Get Configuration Comma Separated Keys 
    And I click on operations V1.6 button
    And I click get configuration
    And I select charge point '<Chargepoint>'
    And I select parameters '<Key>'
    And I click perform button get Configuration
    Then User is on the task result Configuration
    And I click details button get Configuration
    And I click on operations V1.6 button
    And I click change configuration
    And I select charge point '<Chargepoint>'
    And I select Key Type 'Predefined'
    And I select Configuration Key '<Key>'  
    And I enter Value '<Value>' 
    And I click perform button change configuration
    Then User is on the task result Configuration
    And I click on operations V1.6 button
    And I click get configuration
    And I select charge point '<Chargepoint>'
    And I select parameters '<Key>'
    And I click perform button get Configuration
    Then User is on the task result Configuration
    And I click details button get Configuration after change
    
    
    
   Examples: Tests for Comma Separated Keys ChargingScheduleAllowedChargingRateUnit 
  
  | Chargepoint | Key| Value |
  | wiem_pole | ConnectorPhaseRotation | 0.Unknown,1.Unknown,2 |   
  | wiem_pole | ConnectorPhaseRotation | 35 |
  | wiem_pole | ConnectorPhaseRotation | hhhh |  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  