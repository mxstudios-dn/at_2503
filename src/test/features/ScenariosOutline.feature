Feature: Math test
    As a user
    I want to test basic math operations
    So that I can verify the correctness of addition and subtraction

    Background:
        Given User is on the Math demo page

    Scenario Outline: Addition of two numbers
        And User navigates to the Addition page
        When I add <num1> and <num2>
        Then I verify the result is <result>
    Examples:
        | num1 | num2 | result |
        | 5    | 3    | 8      |
        | 7    | 2    | 9      |

    Scenario Outline: Subtraction of two numbers
        And User navigates to the Subtraction page
        When I subtract <num2> from <num1>
        Then I verify the result is <result>
    Examples:
        | num1 | num2 | result |
        | 10   | 2    | 8      |
        | 20   | 5    | 15     |        