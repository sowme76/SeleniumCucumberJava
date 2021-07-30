@Login
Feature: Login to the Business Grants Portal

  @Scenario1
  Scenario Outline: Navigate to QA Environment using valid credentials
    Given Navigate to QA Business Grants Portal using valid URL and credentials "<URL>""<Username>""<Password>"
    Then Business Grants Portal Login page Should be displayed with login "<login>"
    When Click on login
    And Enter the user NRIC "<nric>"
    And Enter the user Name "<name>"
    And Enter the user UEN "<uen>"
    And Select the user Role "<role>"
    And Click on corppass login
    Then User should be able to successfully login to the home page

    Examples: 
      | URL                 | Username | Password         | nric         | name                  | uen        | role     | login  |
      | bgp-qa.gds-gov.tech | cHVibGlj | TGV0JEJlQzAwMQ== | RzM5MTI4MTJO | sowmiya purushothaman | T12LL1368D | Viewer   | LOG IN |
      | bgp-qa.gds-gov.tech | cHVibGlj | TGV0JEJlQzAwMQ== | RzM5MTI4MTJO | sowmiya purushothaman | T12LL1368D | Acceptor | LOG IN |
      | bgp-qa.gds-gov.tech | cHVibGlj | TGV0JEJlQzAwMQ== | RzM5MTI4MTJO | sowmiya purushothaman | T12LL1368D | Preparer | LOG IN |
