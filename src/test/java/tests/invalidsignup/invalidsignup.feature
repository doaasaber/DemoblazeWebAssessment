Feature: Validate Invalid SignUp

  Scenario Outline: User can't sign up

    Given navigates to sign up
    When fill data and click on sign up button based on data: "<username>" "<password>"
    And validate on displayed message "<message>"

    Examples:
    | username   | password   |  message                   |
    |dosaber2   |1234        |This user already exist.    |
    |doaa        |            |Please fill out Username and Password.|