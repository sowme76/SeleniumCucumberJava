@ETE
Feature: To Verify the End to End Validation
  
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
    And Select the subitem in the sector ""
    And Select a development area "International Expansion"
    And Select a functional area "Market Readiness Assistance 2"
    Then Draft form should be created successfully "Market Readiness Assistance (MRA)"
    When Click on proceed button

  @Scenario5
  Scenario Outline: 
    To Verify the Eligibility section displayed with all the details
    To Verify the Contacts section displayed with all the details
    To Verify the Proposal section displayed with all the details
    To Verify the Business Impact section displayed with all the details
    To Verify the cost section displayed with all the details
    To Verify the Declare & Review section displayed with all the details
    To Verify the mandatory fields, when click on save and Review option with all the details
    To Verify once the mandatory fields are entered, system allows to saved the details
    To Verify the saved details in Eligibility section
    To Verify the saved details in Contacts section
    To Verify the saved details in Proposal section
    To Verify the saved details in Business Impact section 
    To Verify the saved details in cost section 
    To Verify the saved details in Declare & Review section 
    To Verify after click on Acknowledgment, application is submitted with all details(Ref ID,Submission Message, Agency details)

    Given Navigates to Eligibility section "<Section>"
    When Click on option for each question as Yes/No
      | true  |
      | false |
      | true  |
      | false |
      | true  |
    When Click on Save
    Then Verify the option selected and verify warning message is displayed when option no is selected "<WarnMsg>"
    Then Click on Next
    #Given Navigates to contacts section "<Section1>"
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
    When Click the Same as main contact person checkbox option
    When Click on save
    Then Verify the saved contact details once the page is refreshed
      | sowmiya           |
      | QA                |
      |          98661947 |
      | sowme76@gmail.com |
      | sowme76@test.com  |
    Then Verify the fields in Letter of offer section gets auto populated from Main contact person section
    Then Click on Next
    #÷Given Navigates to Proposal section "<Section3>"
    When Enter the Project Title "<Project Title>"
    And Select the Start Date "<Start Date>" "Aug" "2021"
    And Select the End Date "<End Date>" "Jun" "2022"
    And Enter the Project Description "<Project Description>"
    And Select the Activity "<Activity>"
    And Select Target Market "<Target Market>"
    And Select Is this the first time you are expanding into a target market outside Singapore? "<option>"
    And Click on Save
    #Then Click on Next
    Given Navigates to Business impact section "Business Impact"
    When Select FY end date "31" "Aug" "2021"
    And Enter overseas sales
      | 1 |
      | 1 |
      | 1 |
      | 1 |
    And Enter overseas investments
      | 1 |
      | 1 |
      | 1 |
      | 1 |
    And Enter rationale for projections "test"
    And Non tangible benefits "test"
    And Click on Save
    Given Navigates to Cost section "Cost"
    When Click expand button
    And Select radio button for vendor registration check "false"
    And Enter vendor name "test"
    And Upload supporting document "path"
    And Enter vendor cost "12"
    And Click on Save
    Then Click on Next
    #Given Navigates to Declare & Review section "<Declare & Review>"
    When Click on option for each question in Declare & Review section as Yes/No
      |       |
      | false |
      | false |
      | false |
      | false |
      | false |
      | false |
      | false |
      | true  |
      | true  |
    And Select Consent & Acknowledgement
    When Click on Save
    Then Click on Review
    Then Verify mandatory fields "false"
    When Click on Save
    Then Click on Review
    When Navigates to Eligibility section "Eligibility"
    Then Verify saved values for eligibility section
      | Yes |
      | No  |
      | Yes |
      | No  |
      | Yes |
    When Navigates contacts section "Contact Details"
    Then Verify the saved contact details
      | sowmiya           |
      | QA                |
      |          98661947 |
      | sowme76@gmail.com |
      | sowme76@test.com  |
    When Navigates to Proposal section "<Section3>"
    Then Verify saved values for proposal section
      | Title1                                        |
      | 29 Aug 2021                                   |
      | 30 Jun 2022                                   |
      | Description                                   |
      | Identification of Potential Overseas Partners |
      | Portugal                                      |
      | Yes                                           |
    When Navigates to Business impact section "Business Impact"
    Then Verify saved values for business impact section
      | 31 Aug 2021 | test | test |      |
      |        1.00 | 1.00 | 1.00 | 1.00 |
      |        1.00 | 1.00 | 1.00 | 1.00 |
    When Navigates to Cost section "Cost"
    Then Verify saved values for cost section
      | Overseas  |
      | test      |
      | SGD 12.00 |
    When Navigates to Declare & Review section "<Declare & Review>"
    Then Verify saved values for declare & review
      | No  |
      | No  |
      | No  |
      | No  |
      | No  |
      | No  |
      | No  |
      | No  |
      | Yes |
      | Yes |
    Then Select the Consent and Acknowledgement checkbox
    Then Click on Submit button
    Then Verify the Application submitted message

    Examples: 
      | Section     | Formname                          | Title                  | WarnMsg                                                                                                                             | Title                        | PostalCode | MailingSection  | Letter of offer addressee section | Section1        | Section3 | Project Title | Start Date | End Date | Project Description | Activity                                      | Target Market | option | Declare & Review |
      | Eligibility | Market Readiness Assistance (MRA) | Check Your Eligibility | The applicant may not meet the eligibility criteria for this grant. Visit FAQ page for more information on other government grants. | Provide your Contact Details |     822167 | Mailing Address | Letter of offer addressee         | Contact Details | Proposal | Title1        |         29 |       30 | Description         | Identification of Potential Overseas Partners | Portugal      | true   | Declare & Review |
