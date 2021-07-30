package StepDefinitions;

import java.util.List;



import context.TestContextUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Userstory1Steps {
	
	TestContextUI testContextUI;
	public Userstory1Steps(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Given("Navigates to Eligibility section {string}")
	public void navigates_to_eligibility_section(String section) {
		testContextUI.getEligibilityPage().selectedTab(section);
	}

	@Then("Verify the title displayed with form name and eligibility section header {string}")
	public void verify_the_title_displayed_with_form_name_and_eligibility_section_header(String formname) {
		testContextUI.getEligibilityPage().formName(formname);
	}

	@Then("Verify the Eligibity hearders title {string}")
	public void verify_the_eligibity_hearders_title(String HeadersTitle) {
		testContextUI.getEligibilityPage().headersTitle(HeadersTitle);
	}

	@Then("Verify the count of questions displayed in the Eligibility section {int}")
	public void verify_the_count_of_questions_displayed_in_the_eligibility_section(int count) {
	    testContextUI.getEligibilityPage().questCount(count);
	}

	@Then("Verify the questions displayed in the Eligibility section")
	public void verify_the_questions_displayed_in_the_eligibility_section(DataTable dataTable) {
		List<String> questionList = dataTable.asList(String.class);
		testContextUI.getEligibilityPage().verifyQuestions(questionList);
	}

	@Then("Verify the options displayed for each question in the Eligibility section")
	public void verify_the_options_displayed_for_each_question_in_the_eligibility_section() {
	    testContextUI.getEligibilityPage().verifyOptions();
	}

	@When("Click on option Yes for all questions {string}")
	public void click_on_option_yes_for_all_questions(String option) {
	    testContextUI.getEligibilityPage().click_radio(option);
	}

	@When("Click on Save")
	public void click_on_save() {
		testContextUI.getEligibilityPage().clickSave();
		testContextUI.getEligibilityPage().handleAlert();
	}
	
	@Then("Verify the saved details once the page is refreshed {string}")
	public void verify_the_saved_details_once_the_page_is_refreshed(String option) {
		testContextUI.getEligibilityPage().verifySavedValues(option);   
	}

	@When("Click on option No for all questions {string}")
	public void click_on_option_no_for_all_questions(String option) {
		testContextUI.getEligibilityPage().click_radio(option);
	}

	@Then("Verify warning message is displayed when option no is selected {string}")
	public void verify_warning_message_is_displayed_when_option_no_is_selected(String warnMsg) {
	    testContextUI.getEligibilityPage().verifyWarnMsg(warnMsg);
		
	}
	
	@Then("Verify the option selected and verify warning message is displayed when option no is selected {string}")
	public void verify_the_option_selected_and_verify_warning_message_is_displayed_when_option_no_is_selected(String warnMsg) {
		testContextUI.getEligibilityPage().verifyWarnNoMsg(warnMsg);
	}


	@Then("Verify the link in the warning message")
	public void verify_the_link_in_the_warning_message() {
	    testContextUI.getEligibilityPage().clickWarnLink();
	}

	@Then("Verify that a website launched in new window when link is clicked {string}")
	public void verify_that_a_website_launched_in_new_window_when_link_is_clicked(String url) {
	    testContextUI.getEligibilityPage().verifyNewWindow(url);
	}
	
	@When("Click on option for each question as Yes\\/No")
	public void click_on_option_for_each_question_as_yes_no(DataTable dataTable) {
		List<String> questionoption = dataTable.asList(String.class);
		testContextUI.getEligibilityPage().verifyQuestionsoption(questionoption);
	    
	}
	
	

}
