Feature:Verify that two products are purchased successfully
  Scenario Outline: User add two products to cart
    Given user navigate to login
    When  user login with valid data "<username>" "<password>"
    And   user navigate to laptops
    And   user choose first product
    And   user add first product to cart and validate on message "<added message>"
    And   user back to the last page
    And   user choose second product
    And   user add second product to cart and validate on message "<added message>"
    And   user navigate to cart
    And   validate that two products include title and Price are added in products page
    And   validate that total amount is calculated correctly
    And   user click on place order
    And   validate that total amount is the same calculated before
    And   user fill data "<name>""<city>""<country>""<card>""<month>""<year>"
    And   user click on purchase
    Then  validate on error message "<message>"


  Examples:
    |username| |password| |added message | |name| |city| |country||card    ||month||year||message                     |
    |doaatest|  |1234 |   |Product added.||      ||cairo||Egypt  || |      | 8   |  |2024||Please fill out Name and Creditcard.|