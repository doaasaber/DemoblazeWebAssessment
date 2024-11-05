Feature: Validate SignUp successfully

  Scenario Outline: User sign up

    Given navigates to sign up
    When fill data and click on sign up button based on data: "<username>" "<password>"
    And validate on displayed message "<message>"

    Examples:
    | username   | password | message                |
    |@Automation3|1234      | Sign up successful.    |

