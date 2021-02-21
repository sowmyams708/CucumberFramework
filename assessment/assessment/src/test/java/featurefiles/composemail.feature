Feature: Compose Mail Module

  #Scenario: Once the user logs into gmail account, he should be able to see "compose mail" CTA at left side and it should be clickable
    #Given user logs into gmail account
    #Then click on compose mail
    #
    #
   #Scenario: User should be able to add "To" address
    #Given user logs into gmail account
    #Then click on compose mail
    #And Verify To,CC,BCC CTA
    
    
    Scenario: User should be able to send the mail 
    Given user logs into gmail account
    Then click on compose mail
    And Verify To,CC,BCC CTA
    And Add Subject as "Assessment framework" and add body of the mail 
    And Attach the files
    And Click on send
