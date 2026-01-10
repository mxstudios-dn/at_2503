@allure.label.owner:MinhPham
Feature: Alert Scenarios
    As a user
    I want to test alert scenarios on the Alert page
    So that I can verify the alert functionalities
    
    Background:
        Given User is on the Automation demo page
    
    @critical
    Scenario: Alert with OK & Cancel tab
        And User navigates to the 'Alert' page
        When I click "Alert with OK" button to display an alert box
        Then I verify the alert display with message "I am an alert box!" successfully
        When I dismiss the alert box
        Then I verify the alert was disappeared successfully
    
    # Scenario: Alert with Textbox tab
    #     And User navigates to the 'Alert' page
    #     When User adds sharing message: 'abc 123'
    #     Then Verify the sharing message is added successfully
    
    