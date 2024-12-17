package org.pojo;

import java.util.List;

import org.base.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftmenuPojo extends BaseMethods {

	public LeftmenuPojo() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' Home']")
	private WebElement homeLM;

	@FindBy(xpath = "//div[text()=' iPaaS ']")
	private WebElement ipaasLM;

	@FindBy(xpath = "//a[text()=' Sources']")
	private WebElement sourcesLM;

	@FindBy(xpath = "//a[text()=' Mappings']")
	private WebElement mappingsLM;

	@FindBy(xpath = "//div[text()=' Dashboards ']")
	private WebElement dashboardsLM;

	@FindBy(xpath = "//div[text()=' Trial Dashboards ']")
	private WebElement trialdashboardsLM;

	@FindBy(xpath = "//a[text()=' Ask Me']")
	private WebElement askmeLM;

	@FindBy(xpath = "//a[text()=' Favorites']")
	private WebElement favoritesLM;

	@FindBy(xpath = "//a[text()=' Marketplace']")
	private WebElement marketplaceLM;

	@FindBy(xpath = "//div[text()=' Administration ']")
	private WebElement administrationLM;

	@FindBy(xpath = "//a[text()=' Client Admin Console ']")
	private WebElement CAconsoleLM;

	@FindBy(xpath = "//a[text()=' User Analytics ']")
	private WebElement userAnalyticsLM;

	@FindBy(xpath = "//a[text()='Settings']")
	private WebElement settingsLM;

	@FindBy(xpath = "//a[text()=' New Request']")
	private WebElement newRequestLM;

	@FindBy(xpath = "//a[text()=' Feedback']")
	private WebElement feedbackLM;

	@FindBy(xpath = "//a[text()=' Support']")
	private WebElement supportLM;

	@FindBy(xpath = "(//div[@class='d-flex align-items-center'])[2]/child::div[1]")
	private WebElement profileIconLM;

	@FindBy(xpath = "//a[text()=' My Profile']")
	private WebElement myProfileLM;

	@FindBy(xpath = "//a[text()=' User Guide']")
	private WebElement userGuideLM;
	
	@FindBy(xpath = "//a[text()=' Privacy Policy']")
	private WebElement privacyPolicyLM;
	
	@FindBy(xpath = "//a[text()=' Terms of Use']")
	private WebElement termsofuseLM;
	
	public WebElement getHomeLM() {
		return homeLM;
	}

	public WebElement getIpaasLM() {
		return ipaasLM;
	}

	public WebElement getSourcesLM() {
		return sourcesLM;
	}

	public WebElement getMappingsLM() {
		return mappingsLM;
	}

	public WebElement getDashboardsLM() {
		return dashboardsLM;
	}

	public WebElement getTrialdashboardsLM() {
		return trialdashboardsLM;
	}

	public WebElement getAskmeLM() {
		return askmeLM;
	}

	public WebElement getFavoritesLM() {
		return favoritesLM;
	}

	public WebElement getMarketplaceLM() {
		return marketplaceLM;
	}

	public WebElement getAdministrationLM() {
		return administrationLM;
	}

	public WebElement getCAconsoleLM() {
		return CAconsoleLM;
	}

	public WebElement getUserAnalyticsLM() {
		return userAnalyticsLM;
	}

	public WebElement getSettingsLM() {
		return settingsLM;
	}

	public WebElement getNewRequestLM() {
		return newRequestLM;
	}

	public WebElement getFeedbackLM() {
		return feedbackLM;
	}

	public WebElement getSupportLM() {
		return supportLM;
	}

	public WebElement getProfileIconLM() {
		return profileIconLM;
	}

	public WebElement getMyProfileLM() {
		return myProfileLM;
	}

	public WebElement getUserGuideLM() {
		return userGuideLM;
	}

	public WebElement getPrivacyPolicyLM() {
		return privacyPolicyLM;
	}

	public WebElement getTermsofuseLM() {
		return termsofuseLM;
	}

	public WebElement getFaqLM() {
		return faqLM;
	}

	public WebElement getNotificationLM() {
		return notificationLM;
	}

	@FindBy(xpath = "//a[text()=' FAQs']")
	private WebElement faqLM;
	
	@FindBy(xpath = "//img[@id='notification']")
	private WebElement notificationLM;

	public WebElement getHomepageLOGO() {
		return homepageLOGO;
	}

	@FindBy(xpath = "//img[@class='img-fluid']")
	private WebElement homepageLOGO;

	@FindBy(xpath = "//img[@class='pull-right']")
	private WebElement collapseIconhome;
	
	@FindBy(xpath = "(//a[@title='Expand']) [1]")
	private WebElement expandIconhome;

	@FindBy(xpath = "(//a[@title='Expand']) [2]")
	private WebElement expandIconprofile;
	
	@FindBy(xpath = "(//a[@title='Collapse']) [2]")
	private WebElement collapseIconprofile;

	@FindBy(xpath = "//i[text()='Powered By MADTechAI']")
	private WebElement Powerdbytxt;

	@FindBy(xpath = "//a[text()='MADTechAI LLC']")
	private WebElement footerMadtechAitxt;

	@FindBy(xpath = "//small[text()=' Support: ']/child::a")
	private WebElement footersupporttxt;

	public WebElement getCollapseIconhome() {
		return collapseIconhome;
	}

	public WebElement getExpandIconhome() {
		return expandIconhome;
	}

	public WebElement getExpandIconprofile() {
		return expandIconprofile;
	}

	public WebElement getCollapseIconprofile() {
		return collapseIconprofile;
	}

	public WebElement getPowerdbytxt() {
		return Powerdbytxt;
	}

	public WebElement getFooterMadtechAitxt() {
		return footerMadtechAitxt;
	}

	public WebElement getFootersupporttxt() {
		return footersupporttxt;
	}
	
	@FindBy(xpath = "//i[@class='fa fa-angle-double-left']")
	private WebElement collapseIconDashboard;

	public WebElement getCollapseIconDashboard() {
		return collapseIconDashboard;
	}
	
	@FindBy(xpath = "//li[@class='li-hover leftmenu liHighlight li-icon']")
	private WebElement colorLM;

	public WebElement getColorLM() {
		return colorLM;
	}
	
	@FindBy(xpath = "//div[@class='row footer ms-3 mb-2']")
	private WebElement footer;

	public WebElement getFooter() {
		return footer;
	}
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement headerSearch;

	public WebElement getHeaderSearch() {
		return headerSearch;
	}
	
	@FindBy(xpath = "//ul[@id='alerts-drpdn']")
	private List<WebElement> notificationList;
	
	@FindBy(xpath = "//a[text()='Clear All']")
	private WebElement clearAll;

	public List<WebElement> getNotificationList() {
		return notificationList;
	}

	public WebElement getClearAll() {
		return clearAll;
	}
	
	@FindBy(xpath = "//span[@class='badge rounded-pill badge-notification bg-warning navbar-badge']")
	private WebElement notificationBatch;

	public WebElement getNotificationBatch() {
		return notificationBatch;
	}
	
	@FindBy(xpath = "//div[@class='leftSidebar width-none']")
	private List<WebElement> leftmenuList;

	public List<WebElement> getLeftmenuList() {
		return leftmenuList;
	}
	
	@FindBy(xpath = "//a[text()=' Sign Out']")
	private WebElement signout;

	public WebElement getSignout() {
		return signout;
	}
	
	@FindBy(xpath = "(//a[@routerlink='/favorites'])[2]")
	private WebElement favIcon;

	public WebElement getFavIcon() {
		return favIcon;
	}
	
	@FindBy(xpath = "//span[text()=' DASHBOARDS ']")
	private WebElement dashboardText;

	public WebElement getDashboardText() {
		return dashboardText;
	}
	
	@FindBy(xpath = "(//a[@title='Trial dashboard refers to a temporary, often limited, version of a dashboard that is provided to users during a free trial period of a software or platform. This allows users to experience and evaluate the features, functionalities, and usability of the dashboard before committing to a purchase or subscription. The purpose of a trial dashboard is to showcase the value of the platform and encourage users to become paying customers'])[2]")
	private WebElement trialDashboardIcon;

	public WebElement getTrialDashboardIcon() {
		return trialDashboardIcon;
	}
	
}
