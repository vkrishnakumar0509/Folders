package org.pojo;

import java.util.List;

import org.base.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalSearch extends BaseMethods{
	
	public GlobalSearch() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@type='search']) [1]")
	private WebElement GlobalSearch;
	
	@FindBy(xpath = "//input[@id='search-box']")
	private WebElement TextBoxGS;

	@FindBy(xpath = "//p[text()='Sources']")
	private WebElement SourcesGS;

	@FindBy(xpath = "//p[text()='Mappings']")
	private WebElement MappingsGS;
	
	@FindBy(xpath = "//p[text()='Dashboards']")
	private WebElement DashboardsGS;
	
	@FindBy(xpath = "//p[text()='Marketing Mix Model']")
	private WebElement mmmGS;
	
	@FindBy(xpath = "//p[text()='Ask Me']")
	private WebElement askmeGS;
	
	@FindBy(xpath = "//p[text()='Favorites']")
	private WebElement favoriteGS;
	
	public WebElement getGlobalSearch() {
		return GlobalSearch;
	}

	public WebElement getTextBoxGS() {
		return TextBoxGS;
	}

	public WebElement getSourcesGS() {
		return SourcesGS;
	}

	public WebElement getMappingsGS() {
		return MappingsGS;
	}

	public WebElement getDashboardsGS() {
		return DashboardsGS;
	}

	public WebElement getMmmGS() {
		return mmmGS;
	}

	public WebElement getAskmeGS() {
		return askmeGS;
	}

	public WebElement getFavoriteGS() {
		return favoriteGS;
	}

	public WebElement getMarketplaceGS() {
		return marketplaceGS;
	}

	public WebElement getClientAdminConsoleGS() {
		return ClientAdminConsoleGS;
	}

	public WebElement getUserAnalyticsGS() {
		return userAnalyticsGS;
	}

	public WebElement getSettingsGS() {
		return settingsGS;
	}

	public WebElement getNewrequestGS() {
		return newrequestGS;
	}

	public WebElement getFeedbackGS() {
		return feedbackGS;
	}

	public WebElement getSupportGS() {
		return supportGS;
	}

	@FindBy(xpath = "//p[text()='Marketplace']")
	private WebElement marketplaceGS;
	
	@FindBy(xpath = "//p[text()='Client Admin Console']")
	private WebElement ClientAdminConsoleGS;
		
	@FindBy(xpath = "//p[text()='User Analytics']")
	private WebElement userAnalyticsGS;
	
	@FindBy(xpath = "//p[text()='Settings']")
	private WebElement settingsGS;

	@FindBy(xpath = "//p[text()='New Request']")
	private WebElement newrequestGS;
	
	@FindBy(xpath = "//p[text()='Feedback']")
	private WebElement feedbackGS;

	@FindBy(xpath = "//p[text()='Support']")
	private WebElement supportGS;
	
	@FindBy(xpath = "//h3[text()='No results found']")
	private WebElement validationGS;

	public WebElement getValidationGS() {
		return validationGS;
	}
	
	@FindBy(xpath = "//img[@class='portalChild']")
	private List<WebElement> iconsGS;

	public List<WebElement> getIconsGS() {
		return iconsGS;
	}

	@FindBy(xpath = "//p[@class='childDesc']")
	private List<WebElement> descriptionGS;

	public List<WebElement> getDescriptionGS() {
		return descriptionGS;
	}
	
	@FindBy(xpath = "//li[@class='list-group-item']")
	private List<WebElement> parentChildlistGS;

	public List<WebElement> getParentChildlistGS() {
		return parentChildlistGS;
	}
	
	
}
