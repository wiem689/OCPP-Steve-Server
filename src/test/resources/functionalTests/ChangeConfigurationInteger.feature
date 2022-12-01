Feature: Automed Operations Change Configuration
As a user, I should make some operations 
	Description: Automation test Change Configuration for Integer Keys 
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected
 


  Scenario Outline: Operations when User In Get Configuration  Intger Keys 
    And I click on operations V1.6 button
    And I click get configuration
    And I select charge point 'wiem_pole_real'
    And I select parameters '<Key>'
    And I click perform button get Configuration
    Then User is on the task result Configuration
    And I click details button get Configuration
    And I click on operations V1.6 button
    And I click change configuration
    And I select charge point 'wiem_pole_real'
    And I select Key Type 'Predefined'
    And I select Configuration Key '<Key>'  
    And I enter Value '<Value>' 
    And I click perform button change configuration
    Then User is on the task result Configuration
    And I click on operations V1.6 button
    And I click get configuration
    And I select charge point 'wiem_pole_real'
    And I select parameters '<Key>'
    And I click perform button get Configuration
    Then User is on the task result Configuration
    And I click details button get Configuration after change
    
 
    
   Examples: Tests for Integer Keys TransactionMessageAttempts 
  
  | Key| Value |
  | TransactionMessageAttempts | 21 |   
  | TransactionMessageAttempts | 36 |
  | TransactionMessageAttempts | hahahah |  
  
  Examples: Tests for Integer Keys ResetRetries 
  
  | Key| Value |
  | ResetRetries | 24 |   
  | ResetRetries | 37 |
  | ResetRetries | hahahah |  
  
  
  
 Examples: Tests for Integer Keys BlinkRepeat
  
  | Key| Value |
  | BlinkRepeat | 4 |   
  | BlinkRepeat | 40 |
  | BlinkRepeat | hahahah |  
       
    
    
 Examples: Tests for Integer Keys ClockAlignedDataInterval
  
  | Key| Value |
  | ClockAlignedDataInterval | 40000 |   
  | ClockAlignedDataInterval | 94000 |
  | ClockAlignedDataInterval | hahahah |  
          
   Examples: Tests for Integer Keys HeartbeatInterval
  
  | Key| Value |
  | HeartbeatInterval | 50000 |   
  | HeartbeatInterval | 93000 |
  | HeartbeatInterval | hahahah |   
    
    
    Examples: Tests for Integer Keys MeterValueSampleInterval
  
  | Key| Value |
  | MeterValueSampleInterval | 60000 |   
  | MeterValueSampleInterval | 92000 |
  | MeterValueSampleInterval | hahahah | 
    
    
   Examples: Tests for Integer Keys MinimumStatusDuration
  
  | Key| Value |
  | MinimumStatusDuration | 70000 |   
  | MinimumStatusDuration | 91000 |
  | MinimumStatusDuration | hahahah |   
    
    
    
  Examples: Tests for Integer Keys TransactionMessageRetryInterval
  
  | Key| Value |
  | TransactionMessageRetryInterval | 66000 |   
  | TransactionMessageRetryInterval | 99000 |
  | TransactionMessageRetryInterval | hahahah |  
  
  Examples: Tests for Integer Keys WebSocketPingInterval
  
  | Key| Value |
  | WebSocketPingInterval | 44000 |   
  | WebSocketPingInterval | 98500 |
  | WebSocketPingInterval | hahahah |    
    
    
  Examples: Tests for Integer Keys MaxEnergyOnInvalidId
  
  | Key| Value |
  | MaxEnergyOnInvalidId | 28000 |   
  | MaxEnergyOnInvalidId | 100000 |
  | MaxEnergyOnInvalidId | hahahah |  
    
    
    
   Examples: Tests for Integer Keys LightIntensity
  
  | Key| Value |
  | LightIntensity | 98 |   
  | LightIntensity | 900000 |
  | LightIntensity | hahahah |    
    
    
    Examples: Tests for Integer Keys ConnectionTimeOut
  
  | Key| Value |
  | ConnectionTimeOut | 118 |   
  | ConnectionTimeOut | 150000 |
  | ConnectionTimeOut | hahahah |    
     
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
 
  
  
     