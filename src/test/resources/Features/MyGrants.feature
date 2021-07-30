@Grant
Feature: Access MyGrants page

  Background: 
    Given Navigate to QA Business Grants Portal using valid URL and credentials "bgp-qa.gds-gov.tech""cHVibGlj""TGV0JEJlQzAwMQ=="
    When Click on login
    And Enter the user NRIC "RzM5MTI4MTJO"
    And Enter the user Name "sowmiya"
    And Enter the user UEN "T12LL1368D"
    And Select the user Role "Acceptor"
    And Click on corppass login

  @Scenario1
  Scenario Outline: To Access My Grants page with or without Subitem Selection
    Given Navigates to my grants page "<Title>"
    When Click on Get New Grant
    And Select sector for business "<Sector>"
    And Select the subitem in the sector "<Subitem>"
    And Select a development area "<DevelopmentArea>"
    And Select a functional area "<FunctionalArea>"
    Then Draft form should be created successfully "<FormName>"
    When Click on proceed button
    Then Verify all sections in the form <SectionCount>

    Examples: 
      | Title     | Sector        | Subitem  | DevelopmentArea         | FunctionalArea                | FormName                          | SectionCount |
      | My Grants | Agriculture   | Food     | International Expansion | Market Readiness Assistance 2 | Market Readiness Assistance (MRA) |            6 |
      | My Grants | Air Transport | Airports | International Expansion | Market Readiness Assistance 2 | Market Readiness Assistance (MRA) |            6 |
      | My Grants | IT            |          | International Expansion | Market Readiness Assistance 2 | Market Readiness Assistance (MRA) |            6 |

  @Scenario2
  Scenario Outline: To Access My Grants page without Subitem Selection
    Given Navigates to my grants page "<Title>"
    When Click on Get New Grant
    And Select sector for business "<Sector>"
    And Select a development area "<DevelopmentArea>"
    And Select a functional area "<FunctionalArea>"
    Then Draft form should be created successfully "<FormName>"
    When Click on proceed button
    Then Verify all sections in the form <SectionCount>

    Examples: 
      | Title     | Sector    | DevelopmentArea         | FunctionalArea                | FormName                          | SectionCount |
      | My Grants | IT        | International Expansion | Market Readiness Assistance 2 | Market Readiness Assistance (MRA) |            6 |
      | My Grants | Logistics | International Expansion | Market Readiness Assistance 2 | Market Readiness Assistance (MRA) |            6 |
