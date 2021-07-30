package StepDefinitions;

import context.TestContextUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GrantSteps {
	
	TestContextUI testContextUI;
	public GrantSteps(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Given("Navigates to my grants page {string}")
	public void navigates_to_my_grants_page(String title) {
		testContextUI.getGrantPage().verifyGrantsPage(title);
	}

	@When("Click on Get New Grant")
	public void click_on_get_new_grant() {
		testContextUI.getGrantPage().clickNewGrant();
	}

	@When("Select sector for business {string}")
	public void select_sector_for_business(String sector) {
		testContextUI.getGrantPage().selectSector(sector);
	}

	@When("Select a development area {string}")
	public void select_a_development_area(String devarea) {
		testContextUI.getGrantPage().selectDevarea(devarea);
	}
	

	@When("Select a functional area {string}")
	public void select_a_functional_area(String funcarea) {
		testContextUI.getGrantPage().selectFuncarea(funcarea);
	}

	@Then("Draft form should be created successfully {string}")
	public void draft_form_should_be_created_successfully(String formName) {
		testContextUI.getGrantPage().clickApply();
		testContextUI.getGrantPage().verifyDraftPage(formName);
	}

	@When("Click on proceed button")
	public void click_on_proceed_button() {
		testContextUI.getGrantPage().clickProceed();
	}

	@Then("Verify all sections in the form {int}")
	public void verify_all_sections_in_the_form(int sectionCount) {
		testContextUI.getGrantPage().checkSections(sectionCount);
	}
	
	@When("Select the subitem in the sector {string}")
	public void select_the_subitem_in_the_sector(String selectsubitem) {
		if(!selectsubitem.equals(""))
			testContextUI.getGrantPage().selectsubitem(selectsubitem);
	}
	    

}
