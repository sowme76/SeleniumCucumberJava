package StepDefinitions;

import java.util.List;

import context.TestContextUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Userstory2Steps {
	
	TestContextUI testContextUI;
	public Userstory2Steps(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Given("Navigates to contacts section {string}")
	public void navigates_to_contacts_section(String section) {
		testContextUI.getContactPage().selectedTab(section);
	}

	@Then("Verify the title displayed with form name and contacts section header {string}")
	public void verify_the_title_displayed_with_form_name_and_contacts_section_header(String formname) {
		testContextUI.getContactPage().formName(formname);
	}

	@Then("Verify the contacts hearders title {string}")
	public void verify_the_contacts_hearders_title(String title) {
		testContextUI.getContactPage().headersTitle(title);
	}

	@Then("Verify the fields displayed in the contacts section")
	public void verify_the_fields_displayed_in_the_contacts_section(DataTable dataTable) {
		List<String> contactFieldsList = dataTable.asList(String.class);
		testContextUI.getContactPage().verifyContactFields(contactFieldsList);
	}
	
	@Then("Enter the field values displayed in the contacts section")
	public void enter_the_field_values_displayed_in_the_contacts_section(DataTable dataTable) {
		List<String> inputMap = dataTable.asList(String.class);
		testContextUI.getContactPage().inputContactFields(inputMap);
	}

	@When("Verify mailing section and Enter postal code in Mailing address {string} {string}")
	public void enter_postal_code_in_mailing_address(String mailingAddr, String postalCode) {
		testContextUI.getContactPage().verifyMailingSection(mailingAddr);
		testContextUI.getContactPage().enterPostalCode(postalCode);
	}

	@Then("Verify other fields in Mailing address details are auto populated")
	public void verify_other_fields_in_mailing_address_details_are_auto_populated() {
	    testContextUI.getContactPage().verifyMailAddrAutoPop();
	}

	@When("Click same as registered address option in mailing address section")
	public void click_same_as_registered_address_option_in_mailing_address_section() {
		testContextUI.getContactPage().clickMailingCheckbox();
	}

	@Then("Verify all fields in Mailing address details are auto populated")
	public void verify_all_fields_in_mailing_address_details_are_auto_populated() throws InterruptedException {
		testContextUI.getContactPage().verifyMailAddrAutoPopAll();
	}

	@Then("Verify Letter of offer addressee section {string}")
	public void verify_letter_of_offer_addressee_section(String lofasection) {
		testContextUI.getContactPage().verifyLetofferaddsection(lofasection);
	   
	}

	@Then("Check the fields displayed in Letter of offer section")
	public void check_the_fields_displayed_in_letter_of_offer_section(DataTable dataTable) {
		List<String> inputList = dataTable.asList(String.class);
		testContextUI.getContactPage().verifyLetterOfOfferSection(inputList);
	}

	@When("Click the Same as main contact person checkbox option")
	public void click_same_as_main_contact_person_checkbox_option_() {
		testContextUI.getContactPage().clickLOACheckbox();
	}

	@Then("Verify the fields in Letter of offer section gets auto populated from Main contact person section")
	public void verify_the_fields_in_letter_of_offer_section_gets_auto_populated_from_main_contact_person_section() {
		testContextUI.getContactPage().clickLOAAutoPop();
	}

	@When("Click on save")
	public void click_on_save() throws Throwable {
		testContextUI.getContactPage().click_save();
		testContextUI.getContactPage().handleAlert();
	}

	@Then("Verify the saved contact details once the page is refreshed")
	public void verify_the_saved_contact_details_once_the_page_is_refreshed(DataTable dataTable) {
		List<String> inputList = dataTable.asList(String.class);
		testContextUI.getContactPage().verifySavedValues(inputList);
	}
	@When("Navigates contacts section {string}")
	public void navigates_contacts_section(String contactpage) {
		testContextUI.getContactPage().contactpage(contactpage);
	}
}
