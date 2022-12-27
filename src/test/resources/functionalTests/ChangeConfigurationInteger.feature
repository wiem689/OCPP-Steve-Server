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
  | TransactionMessageAttempts | 20 |   
  | TransactionMessageAttempts | 37 |
  | TransactionMessageAttempts | hahahah |  
  
  Examples: Tests for Integer Keys ResetRetries 
  
  | Key| Value |
  | ResetRetries | 25 |   
  | ResetRetries | 36 |
  | ResetRetries | hahahah |  
  
  
  
 Examples: Tests for Integer Keys BlinkRepeat
  
  | Key| Value |
  | BlinkRepeat | 3 |   
  | BlinkRepeat | 41 |
  | BlinkRepeat | hahahah |  
       
    
    
 Examples: Tests for Integer Keys ClockAlignedDataInterval
  
  | Key| Value |
  | ClockAlignedDataInterval | 41000 |   
  | ClockAlignedDataInterval | 93000 |
  | ClockAlignedDataInterval | hahahah |  
          
   Examples: Tests for Integer Keys HeartbeatInterval
  
  | Key| Value |
  | HeartbeatInterval | 51000 |   
  | HeartbeatInterval | 92000 |
  | HeartbeatInterval | hahahah |   
    
    
    Examples: Tests for Integer Keys MeterValueSampleInterval
  
  | Key| Value |
  | MeterValueSampleInterval | 61000 |   
  | MeterValueSampleInterval | 93000 |
  | MeterValueSampleInterval | hahahah | 
    
    

    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
 
  
  
     