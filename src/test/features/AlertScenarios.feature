Feature: Alert Scenarios
    As a user
    I want to test alert scenarios on the Alert page
    So that I can verify the alert functionalities
    
    Background:
        Given User is on the Automation demo page
    
    Scenario: Alert with OK & Cancel tab
        And User navigates to the 'Alert' page
        When I click "Alert with OK" button to display an alert box
        Then I verify the alert display with message "I am an alert box!" successfully
        When I dismiss the alert box
        Then I verify the alert was disappeared successfully
    
    # Scenario: Alert with Textbox tab
    #     And User navigates to the 'Alert' page
    #     When I click "Alert with Textbox" button to display a prompt box
    #     And I enter text "Automation Test" in the prompt box
    #     And I accept the prompt box
    #     Then I verify the prompt box accepted the text "Automation Test" successfully
    
    