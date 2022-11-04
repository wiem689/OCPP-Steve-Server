#Feature: Automed Operations Two Connectors
#As a user, I should make some operations 
	#Description: Automation test for Two Connectors
	
	

  #Background: Login 
	#Given user is on login Page
	#When 	the user put username
	#And   enter password
	#And   I click singnin button
  #Then the user is connected
 

 
    #Scenario Outline: Operations when we have two Connectors
     #And I click on data management charge points button
	   #And I select 'wiem' 
     #And I click on operations V1.6 button
     #And I select charge point 'wiem'
     #And I click all charge point 
     #And I select connecter ID as '<connectorId>'
     #And I select availability Type as '<availability>'
     #And I click perform button change availability with Initial State as '<initialState>'
     #Then User is on the task result
     
    
     #Examples:
     
     #| connectorId | availability | initialState |
     #| 0 | OPERATIVE | 0-0 |
     #| 0 | OPERATIVE | 0-1 |
     #| 0 | OPERATIVE | 1-0 |
     #| 0 | OPERATIVE | 1-1 |
     
         
     #Examples:
     
     #| connectorId | availability | initialState |
     #| 0 | INOPERATIVE | 0-0 |
     #| 0 | INOPERATIVE | 0-1 |
     #| 0 | INOPERATIVE | 1-0 |
 #    | 0 | INOPERATIVE | 1-1 |
     
  #   Examples:
     
   #  | connectorId | availability | initialState |
    # | 1 | OPERATIVE | 0-0 |
     #| 1 | OPERATIVE | 0-1 |
     #| 1 | OPERATIVE | 1-0 |
     #| 1 | OPERATIVE | 1-1 |
     
         
     #Examples:
     
     #| connectorId | availability | initialState |
     #| 1 | INOPERATIVE | 0-0 |
     #| 1 | INOPERATIVE | 0-1 |
     #| 1 | INOPERATIVE | 1-0 |
     #| 1 | INOPERATIVE | 1-1 |
     
     #Examples:
     
     #| connectorId | availability | initialState |
     #| 2 | OPERATIVE | 0-0 |
     #| 2 | OPERATIVE | 0-1 |
     #| 2 | OPERATIVE | 1-0 |
     #| 2 | OPERATIVE | 1-1 |
     
         
     #Examples:
     
     #| connectorId | availability | initialState |
    # | 2 | INOPERATIVE | 0-0 |
     #| 2 | INOPERATIVE | 0-1 |
     #| 2 | INOPERATIVE | 1-0 |
     #| 2 | INOPERATIVE | 1-1 |
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     