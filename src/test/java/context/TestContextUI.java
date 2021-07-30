package context;

import org.openqa.selenium.WebDriver;

import pages.BusinessImpactPage;
import pages.ContactPage;
import pages.CostPage;
import pages.DeclareReviewPage;
import pages.EligibilityPage;
import pages.GrantsPage;
import pages.LoginPage;
import pages.Proposalpage;
import pages.ReviewPage;

public class TestContextUI {
	
	WebDriver driver;
	GrantsPage grantPage;
	LoginPage loginPage;
	EligibilityPage eligibilityPage;
	ContactPage contactPage;
	Proposalpage proposalPage;
	DeclareReviewPage declarePage;
	BusinessImpactPage businessImpactPage;
	CostPage costPage;
	ReviewPage reviewPage;

	public ReviewPage getReviewPage() {
		return reviewPage;
	}

	public void setReviewPage(ReviewPage reviewPage) {
		this.reviewPage = reviewPage;
	}

	public CostPage getCostPage() {
		return costPage;
	}

	public void setCostPage(CostPage costPage) {
		this.costPage = costPage;
	}

	public BusinessImpactPage getBusinessImpactPage() {
		return businessImpactPage;
	}

	public void setBusinessImpactPage(BusinessImpactPage businessImpactPage) {
		this.businessImpactPage = businessImpactPage;
	}

	public DeclareReviewPage getDeclarePage() {
		return declarePage;
	}

	public void setDeclarePage(DeclareReviewPage declarePage) {
		this.declarePage = declarePage;
	}

	public Proposalpage getProposalPage() {
		return proposalPage;
	}

	public void setProposalPage(Proposalpage proposalPage) {
		this.proposalPage = proposalPage;
	}

	public EligibilityPage getEligibilityPage() {
		return eligibilityPage;
	}

	public void setEligibilityPage(EligibilityPage eligibilityPage) {
		this.eligibilityPage = eligibilityPage;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(LoginPage loginPage) {
		this.loginPage = loginPage;
	}

	public GrantsPage getGrantPage() {
		return grantPage;
	}

	public void setGrantPage(GrantsPage grantPage) {
		this.grantPage = grantPage;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public ContactPage getContactPage() {
		return contactPage;
	}

	public void setContactPage(ContactPage contactPage) {
		this.contactPage = contactPage;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void initializePageObject(WebDriver driver) {
		grantPage = new GrantsPage(driver);
		loginPage = new LoginPage(driver);
		eligibilityPage = new EligibilityPage(driver);
		contactPage = new ContactPage(driver);
		proposalPage = new Proposalpage(driver);
		declarePage = new DeclareReviewPage(driver);
		businessImpactPage = new BusinessImpactPage(driver);
		costPage = new CostPage(driver);
		reviewPage = new ReviewPage(driver);
	}
	

}
