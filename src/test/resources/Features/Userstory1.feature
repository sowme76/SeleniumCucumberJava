@Eligibility
Feature: To Access and Verify Eligibility Section

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

  
  @Scenario1
  Scenario Outline: To verify the Eligibility section and saved details when all options are selected as Yes
  Given Navigates to Eligibility section "<Section>"
  Then Verify the title displayed with form name and eligibility section header "<Formname>"
  And Verify the Eligibity hearders title "<Title>"
  And Verify the count of questions displayed in the Eligibility section <Count>
  And Verify the questions displayed in the Eligibility section
  | Is the applicant registered in Singapore? *                                                                                                   |
  | Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200? * |
  | Does the applicant have at least 30% local equity? *                                                                                          |
  | Are all the following statements true for this project? *                                                                                     |
  And Verify the options displayed for each question in the Eligibility section
  When Click on option Yes for all questions "<Option>"
  When Click on Save
  Then Verify the saved details once the page is refreshed "<Option>"
  
  Examples:
  | Section     | Formname                          | Title                  | Count | Option |
  | Eligibility | Market Readiness Assistance (MRA) | Check Your Eligibility |     5 | true   |
  
  
  @Scenario2
  Scenario Outline: Outline: To verify the Eligibility section, warning message and saved details when all options are selected as No
  Given Navigates to Eligibility section "<Section>"
  Then Verify the title displayed with form name and eligibility section header "<Formname>"
  And Verify the Eligibity hearders title "<Title>"
  And Verify the count of questions displayed in the Eligibility section <Count>
  And Verify the questions displayed in the Eligibility section
  | Is the applicant registered in Singapore? *                                                                                                   |
  | Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200? * |
  | Does the applicant have at least 30% local equity? *                                                                                          |
  | Are all the following statements true for this project? *                                                                  |
  And Verify the options displayed for each question in the Eligibility section
  When Click on option No for all questions "<Option>"
  Then Verify warning message is displayed when option no is selected "<WarnMsg>"
  And Verify the link in the warning message
  And Verify that a website launched in new window when link is clicked "https://www.ifaq.gov.sg/BGP/apps/Fcd_faqmain.aspx"
  When Click on Save
  Then Verify the saved details once the page is refreshed "<Option>"
  Examples:
  | Section     | Formname                          | Title                  | Count | Option | WarnMsg                                                                                                                             |
  | Eligibility | Market Readiness Assistance (MRA) | Check Your Eligibility |     5 | false  | The applicant may not meet the eligibility criteria for this grant. Visit FAQ page for more information on other government grants. |
  
  @Scenario3
  Scenario Outline: To verify the Eligibility section, warning message and saved details when options are selected as  Yes or No
    Given Navigates to Eligibility section "<Section>"
    And Verify the questions displayed in the Eligibility section
      | Is the applicant registered in Singapore? *                                                                                                   |
      | Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's group employment size less than or equal to 200? * |
      | Does the applicant have at least 30% local equity? *                                                                                          |
      | Are all the following statements true for this project? *                                                                                     |
    And Verify the options displayed for each question in the Eligibility section
    When Click on option for each question as Yes/No
      | true  |
      | false |
      | true  |
      | false |
      | true  |
    Then Verify the option selected and verify warning message is displayed when option no is selected "<WarnMsg>"
    And Verify the link in the warning message
    And Verify that a website launched in new window when link is clicked "https://www.ifaq.gov.sg/BGP/apps/Fcd_faqmain.aspx"
    When Click on Save

    Examples: 
      | Section     | WarnMsg                                                                                                                             |
      | Eligibility | The applicant may not meet the eligibility criteria for this grant. Visit FAQ page for more information on other government grants. |
