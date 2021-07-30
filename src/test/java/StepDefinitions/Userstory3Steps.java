package StepDefinitions;


import java.util.List;

import context.TestContextUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Userstory3Steps {
	
	TestContextUI testContextUI;
	public Userstory3Steps(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	
	@Then("Click on Next")
	public void click_on_next() {
		testContextUI.getEligibilityPage().nextbtn();
	}
	
@Given("Navigates to Proposal section {string}")
public void navigates_to_proposal_section(String proposaltab) {
	testContextUI.getProposalPage().proposaltab(proposaltab);
}
@When("Enter the Project Title {string}")
public void enter_the_project_title(String projecttitle) {
	testContextUI.getProposalPage().projecttitle(projecttitle);
	
}

@When("Select the Start Date {string} {string} {string}")
public void select_the_start_date(String date, String month, String year) {
	testContextUI.getProposalPage().selectStartDate(date, month, year);
}

@When("Select the End Date {string} {string} {string}")
public void select_the_end_date(String date, String month, String year) {
	testContextUI.getProposalPage().selectEndDate(date, month, year);
}

@When("Enter the Project Description {string}")
public void enter_the_project_description(String projectdescription) {
	testContextUI.getProposalPage().projectdescription(projectdescription);
}

@When("Select the Activity {string}")
public void select_the_activity(String activity) {
	testContextUI.getProposalPage().activity(activity);
}

@When("Select Target Market {string}")
public void select_target_market(String target) {
	testContextUI.getProposalPage().selectTarget(target);
    
}

@When("Select Is this the first time you are expanding into a target market outside Singapore? {string}")
public void select_is_this_the_first_time_you_are_expanding_into_a_target_market_outside_singapore(String option) {
	testContextUI.getProposalPage().click_proposal_radio(option);
}


@Given("Navigates to Declare & Review section {string}")
public void navigates_to_declare_review_section(String declarereview) {
	testContextUI.getDeclarePage().declarereviewtab(declarereview);   
}

@When("Click on option for each question in Declare & Review section as Yes\\/No")
public void click_on_option_for_each_question_in_declare_review_section_as_yes_no(DataTable dataTable) {
	List<String> questionoption = dataTable.asList(String.class);
	testContextUI.getDeclarePage().verifyQuestionsoption(questionoption); 
}

@When("Select Consent & Acknowledgement")
public void select_consent_acknowledgement() {
	testContextUI.getDeclarePage().selectcheckbox();   
}

@Then("Click on Review")
public void click_on_review() {
	testContextUI.getDeclarePage().clickreview(); 
}

@Given("Navigates to Business impact section {string}")
public void navigates_to_business_impact_section(String businessImpactTab) {
	testContextUI.getBusinessImpactPage().selectedBusinessImpactTab(businessImpactTab);
}

@When("Select FY end date {string} {string} {string}")
public void select_fy_end_date(String date, String month, String year) throws Throwable {
	testContextUI.getBusinessImpactPage().selectFYEndDate(date, month, year);
}

@When("Enter overseas sales")
public void enter_overseas_sales(DataTable dataTable) {
    List<String> inputList = dataTable.asList(String.class);
    testContextUI.getBusinessImpactPage().enterOverseasSales(inputList);
}

@When("Enter overseas investments")
public void enter_overseas_investments(DataTable dataTable) {
	List<String> inputList = dataTable.asList(String.class);
    testContextUI.getBusinessImpactPage().enterOverseasInvestments(inputList);
}

@When("Enter rationale for projections {string}")
public void enter_rationale_for_projections(String input) {
	testContextUI.getBusinessImpactPage().enterRationaleProj(input);
}

@When("Non tangible benefits {string}")
public void non_tangible_benefits(String input) {
	testContextUI.getBusinessImpactPage().enterTangibleBenefits(input);
}

@Given("Navigates to Cost section {string}")
public void navigates_to_cost_section(String input) {
	testContextUI.getCostPage().selectedCostTab(input);
}

@When("Click expand button")
public void click_expand_button() {
	testContextUI.getCostPage().clickExpandVendor();
	testContextUI.getCostPage().addNewItem();
}

@When("Select radio button for vendor registration check {string}")
public void select_radio_button_for_vendor_registration_check(String option) {
	testContextUI.getCostPage().clickCostRadio(option);
}

@When("Enter vendor name {string}")
public void enter_vendor_name(String input) {
	testContextUI.getCostPage().enterVendorInput(input);
}

@When("Upload supporting document {string}")
public void upload_supporting_document(String input) throws Throwable {
	testContextUI.getCostPage().uploadFile(input);
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@When("Enter vendor cost {string}")
public void enter_vendor_cost(String input) {
	testContextUI.getCostPage().enterVendorCost(input);
}

@Then("Verify saved values for eligibility section")
public void verify_saved_values_for_eligibility_section(DataTable dataTable) {
    List<String> eligibilityList = dataTable.asList(String.class);
    testContextUI.getReviewPage().verifyEligibilityPage(eligibilityList);
}

@Then("Verify the saved contact details")
public void verify_the_saved_contact_details(DataTable dataTable) {
    List<String> eligibilityList = dataTable.asList(String.class);
    testContextUI.getReviewPage().verifyContactValues(eligibilityList);
}

@Then("Verify saved values for proposal section")
public void verify_saved_values_for_proposal_section(DataTable dataTable) {
	List<String> proposalList = dataTable.asList(String.class);
    testContextUI.getReviewPage().verifyProposalPage(proposalList);
}

@Then("Verify saved values for business impact section")
public void verify_saved_values_for_business_impact_section(DataTable dataTable) {
    List<List<String>> businessImpactList = dataTable.asLists(String.class);
    testContextUI.getReviewPage().verifyBusinessImpactPage(businessImpactList);
}

@Then("Verify saved values for cost section")
public void verify_saved_values_for_cost_section(DataTable dataTable) {
	List<String> costList = dataTable.asList(String.class);
    testContextUI.getReviewPage().verifyCostPage(costList);
}

@Then("Verify saved values for declare & review")
public void verify_saved_values_for_declare_review(DataTable dataTable) {
	List<String> declareList = dataTable.asList(String.class);
    testContextUI.getReviewPage().verifyDeclarePage(declareList);
}

@Then("Select the Consent and Acknowledgement checkbox")
public void select_the_consent_and_acknowledgement_checkbox() {
	testContextUI.getReviewPage().clickDisclaimer();
    
}

@Then("Click on Submit button")
public void click_on_submit_button() {
	testContextUI.getReviewPage().submitReviewForm();
    
}

@Then("Verify the Application submitted message")
public void verify_the_application_submitted_message() {
	testContextUI.getReviewPage().verifySubmissionDetails();
}

@Then("Verify mandatory fields {string}")
public void verify_mandatory_fields(String option)  {
	testContextUI.getDeclarePage().verifyMandatoryField(option);
}

}
