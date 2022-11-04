Feature: Automed Operations Change Configuration
As a user, I should make some operations 
	Description: Automation test Change Configuration
	
	

  Background: Login 
	Given user is on login Page
	When 	the user put username
	And   enter password
	And   I click singnin button
  Then the user is connected
 


  Scenario Outline: Operations when User In Get Configuration  
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
    And I select Key Type '<KeyType>'
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
  
  
  Examples: Tests for boolean Keys 
  
  | Chargepoint | Key | Chargepoint | KeyType | Key | Value | Chargepoint | Key |
  | wiem_pole | AllowOfflineTxForUnknownId | wiem_pole | Predefined | AllowOfflineTxForUnknownId | true | wiem_pole | AllowOfflineTxForUnknownId |   
  | wiem_pole | AllowOfflineTxForUnknownId | wiem_pole | Predefined | AllowOfflineTxForUnknownId | false | wiem_pole | AllowOfflineTxForUnknownId |
  | wiem_pole | AllowOfflineTxForUnknownId | wiem_pole | Predefined | AllowOfflineTxForUnknownId | hhhh | wiem_pole | AllowOfflineTxForUnknownId |  
  
   | wiem_pole |  ConnectorSwitch3to1PhaseSupported | wiem_pole | Predefined |  ConnectorSwitch3to1PhaseSupported | true | wiem_pole |  ConnectorSwitch3to1PhaseSupported |   
  | wiem_pole |  ConnectorSwitch3to1PhaseSupported | wiem_pole | Predefined |  ConnectorSwitch3to1PhaseSupported | false | wiem_pole |  ConnectorSwitch3to1PhaseSupported |
  | wiem_pole |  ConnectorSwitch3to1PhaseSupported | wiem_pole | Predefined |  ConnectorSwitch3to1PhaseSupported | hhhh | wiem_pole |  ConnectorSwitch3to1PhaseSupported |  
 
  | wiem_pole | AuthorizationCacheEnabled | wiem_pole | Predefined | AuthorizationCacheEnabled | true | wiem_pole | AuthorizationCacheEnabled |   
  | wiem_pole | AuthorizationCacheEnabled | wiem_pole | Predefined | AuthorizationCacheEnabled | false | wiem_pole | AuthorizationCacheEnabled |
  | wiem_pole | AuthorizationCacheEnabled | wiem_pole | Predefined | AuthorizationCacheEnabled | hhhh | wiem_pole | AuthorizationCacheEnabled |  
  
  | wiem_pole | AuthorizeRemoteTxRequests | wiem_pole | Predefined | AuthorizeRemoteTxRequests | true | wiem_pole | AuthorizeRemoteTxRequests |   
  | wiem_pole | AuthorizeRemoteTxRequests | wiem_pole | Predefined | AuthorizeRemoteTxRequests | false | wiem_pole | AuthorizeRemoteTxRequests |
  | wiem_pole | AuthorizeRemoteTxRequests | wiem_pole | Predefined | AuthorizeRemoteTxRequests | hhhh | wiem_pole | AuthorizeRemoteTxRequests |
  
  | wiem_pole | LocalAuthorizeOffline | wiem_pole | Predefined | LocalAuthorizeOffline | true | wiem_pole | LocalAuthorizeOffline |   
  | wiem_pole | LocalAuthorizeOffline | wiem_pole | Predefined | LocalAuthorizeOffline | false | wiem_pole | LocalAuthorizeOffline |
  | wiem_pole | LocalAuthorizeOffline | wiem_pole | Predefined | LocalAuthorizeOffline | hhhh | wiem_pole | LocalAuthorizeOffline |
  
  | wiem_pole | LocalPreAuthorize | wiem_pole | Predefined | LocalPreAuthorize | true | wiem_pole | LocalPreAuthorize |   
  | wiem_pole | LocalPreAuthorize | wiem_pole | Predefined | LocalPreAuthorize | false | wiem_pole | LocalPreAuthorize |
  | wiem_pole | LocalPreAuthorize | wiem_pole | Predefined | LocalPreAuthorize | hhhh | wiem_pole | LocalPreAuthorize |
  
  | wiem_pole | ReserveConnectorZeroSupported | wiem_pole | Predefined | ReserveConnectorZeroSupported | true | wiem_pole | ReserveConnectorZeroSupported |   
  | wiem_pole | ReserveConnectorZeroSupported | wiem_pole | Predefined | ReserveConnectorZeroSupported | false | wiem_pole | ReserveConnectorZeroSupported |
  | wiem_pole | ReserveConnectorZeroSupported | wiem_pole | Predefined | ReserveConnectorZeroSupported | hhhh | wiem_pole | ReserveConnectorZeroSupported |
  
  | wiem_pole | StopTransactionOnEVSideDisconnect | wiem_pole | Predefined | StopTransactionOnEVSideDisconnect | true | wiem_pole | StopTransactionOnEVSideDisconnect |   
  | wiem_pole | StopTransactionOnEVSideDisconnect | wiem_pole | Predefined | StopTransactionOnEVSideDisconnect | false | wiem_pole | StopTransactionOnEVSideDisconnect |
  | wiem_pole | StopTransactionOnEVSideDisconnect | wiem_pole | Predefined | StopTransactionOnEVSideDisconnect | hhhh | wiem_pole | StopTransactionOnEVSideDisconnect |
  
  | wiem_pole | StopTransactionOnInvalidId | wiem_pole | Predefined | StopTransactionOnInvalidId | true | wiem_pole | StopTransactionOnInvalidId |   
  | wiem_pole | StopTransactionOnInvalidId | wiem_pole | Predefined | StopTransactionOnInvalidId | false | wiem_pole | StopTransactionOnInvalidId |
  | wiem_pole | StopTransactionOnInvalidId | wiem_pole | Predefined | StopTransactionOnInvalidId | hhhh | wiem_pole | StopTransactionOnInvalidId |
  
  | wiem_pole | UnlockConnectorOnEVSideDisconnect | wiem_pole | Predefined | UnlockConnectorOnEVSideDisconnect | true | wiem_pole | UnlockConnectorOnEVSideDisconnect |   
  | wiem_pole | UnlockConnectorOnEVSideDisconnect | wiem_pole | Predefined | UnlockConnectorOnEVSideDisconnect | false | wiem_pole | UnlockConnectorOnEVSideDisconnect |
  | wiem_pole | UnlockConnectorOnEVSideDisconnect | wiem_pole | Predefined | UnlockConnectorOnEVSideDisconnect | hhhh | wiem_pole | UnlockConnectorOnEVSideDisconnect |
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
  
  