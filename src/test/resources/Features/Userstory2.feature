@Contacts
Feature: To Access and Verify Contacts Section

  Background: 
    Given Navigate to QA Business Grants Portal using valid URL and credentials "bgp-qa.gds-gov.tech""cHVibGlj""TGV0JEJlQzAwMQ=="
    When Click on login
    And Enter the user NRIC "RzM5MTI4MTJO"
    And Enter the user Name "sowmiya"
    And Enter the user UEN "T12LL1368D"
    And Select the user Role "Acceptor"
    And Click on corppass login
    Given Navigates to my grants page "My Grants"
    When Click on Get New Grant
    And Select sector for business "IT"
    And Select a development area "International Expansion"
    And Select a functional area "Market Readiness Assistance 2"
    Then Draft form should be created successfully "Market Readiness Assistance (MRA)"
    When Click on proceed button

  @Scenario4
  Scenario Outline: To verify the contacts section and saved values, once the page is refreshed
    Given Navigates to contacts section "<Section>"
    Then Verify the title displayed with form name and contacts section header "<Formname>"
    And Verify the contacts hearders title "<Title>"
    And Verify the fields displayed in the contacts section
      | Name                             |
      | Job Title                        |
      | Contact No.                      |
      | Email                            |
      | Alternate Contact Person's Email |
    And Enter the field values displayed in the contacts section
      | sowmiya           |
      | QA                |
      | "98661947"        |
      | sowme76@gmail.com |
      | sowme76@test.com  |
    When Verify mailing section and Enter postal code in Mailing address "<MailingSection>" "<PostalCode>"
    Then Verify other fields in Mailing address details are auto populated
    When Click same as registered address option in mailing address section
    Then Verify all fields in Mailing address details are auto populated
    And Verify Letter of offer addressee section "<Letter of offer addressee section>"
    And Check the fields displayed in Letter of offer section
      | Name      |
      | Job Title |
      | Email     |
    When Click the Same as main contact person checkbox option
    Then Verify the fields in Letter of offer section gets auto populated from Main contact person section
    When Click on save
    Then Verify the saved contact details once the page is refreshed
      | sowmiya           |
      | QA                |
      | 98661947        |
      | sowme76@gmail.com |
      | sowme76@test.com  |

    Examples: 
      | Section         | Formname                          | Title                        | PostalCode | MailingSection  | Letter of offer addressee section |
      | Contact Details | Market Readiness Assistance (MRA) | Provide your Contact Details |     822167 | Mailing Address | Letter of offer addressee         |
