Feature: Automed Operations Change Configuration
As a user, I should make some operations 
	Description: Automation test Change Configuration for Boolean Keys 
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected
 


  Scenario Outline: Operations when User In Get Configuration  Boolean Keys 
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
 
  
  Examples: Tests for boolean Keys 
  
  | Key | Value |
  | AllowOfflineTxForUnknownId | true |  
  | AllowOfflineTxForUnknownId | false |
  | AllowOfflineTxForUnknownId | hahahaha |  
  
  |  ConnectorSwitch3to1PhaseSupported | true |   
  |  ConnectorSwitch3to1PhaseSupported | false |
  |  ConnectorSwitch3to1PhaseSupported | hahahaha |  
 
  | AuthorizationCacheEnabled | true |   
  | AuthorizationCacheEnabled | false |
  | AuthorizationCacheEnabled | hahahaha |  
  
  | AuthorizeRemoteTxRequests | true |   
  | AuthorizeRemoteTxRequests | false |
  | AuthorizeRemoteTxRequests | hahahaha |
  
  | LocalAuthorizeOffline | true |   
  | LocalAuthorizeOffline | false |
  | LocalAuthorizeOffline | hahahaha |
  
  | LocalPreAuthorize | true |   
  | LocalPreAuthorize | false |
  | LocalPreAuthorize | hahahaha |
  
  | ReserveConnectorZeroSupported | true |   
  | ReserveConnectorZeroSupported | false |
  | ReserveConnectorZeroSupported | hahahaha |
  
  | StopTransactionOnEVSideDisconnect | true |   
  | StopTransactionOnEVSideDisconnect | false |
  | StopTransactionOnEVSideDisconnect | hahahaha |
  
  | StopTransactionOnInvalidId | true |   
  | StopTransactionOnInvalidId | false |
  | StopTransactionOnInvalidId | hahahaha |
  
  | UnlockConnectorOnEVSideDisconnect | true |   
  | UnlockConnectorOnEVSideDisconnect | false |
  | UnlockConnectorOnEVSideDisconnect | hahahaha |
  
  
  
  
  
  
  
  
  
  
  
  