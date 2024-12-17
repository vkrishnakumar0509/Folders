package org.pojo;

import java.util.List;

import org.base.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePojo extends BaseMethods {

	public HomePagePojo() {

		PageFactory.initElements(driver, this);
	}

	// Quick access

	@FindBy(xpath = "//h3[text()=' Quick access ']")
	private WebElement quickaccessText;

	public WebElement getQuickaccessText() {
		return quickaccessText;
	}

	@FindBy(xpath = "//div[@id='trialBanner']")
	private WebElement trialbanner;

	@FindBy(xpath = "//img[@class='img-fluid']")
	private WebElement homepageLOGO;

	@FindBy(xpath = "//a[text()=' Favorites']")
	private WebElement favLM;

	@FindBy(xpath = "(//span[@class='small-footer']) [1]")
	private WebElement QA1stElemnt;

	@FindBy(xpath = "(//div[@class='small-box smallbox-hover'])[4]")
	private WebElement QAcardhover4;

	@FindBy(xpath = "(//i[@class='fa-regular fa-circle-xmark']) [4]")
	private WebElement QAcardclose4;

	@FindBy(xpath = "(//div[@class='pull-right']) [1]//child::button")
	private WebElement QAEdit;

	@FindBy(xpath = "//input[@value='Favorites']")
	private WebElement Pop_fav;

	@FindBy(xpath = "//input[@value='Q&A Dashboard']")
	private WebElement Pop_Askme;

	@FindBy(xpath = "//input[@value='Marketing Mix Model']")
	private WebElement Pop_mmm;

	@FindBy(xpath = "//input[@value='User Analytics']")
	private WebElement Pop_userAnly;

	@FindBy(xpath = "//input[@value='Marketplace']")
	private WebElement Pop_marketplace;

	@FindBy(xpath = "//button[@class='btn1']")
	private WebElement Pop_cancelbtn;

	public WebElement getPop_Askme() {
		return Pop_Askme;
	}

	public WebElement getPop_cancelbtn() {
		return Pop_cancelbtn;
	}

	public WebElement getPop_mmm() {
		return Pop_mmm;
	}

	public WebElement getPop_userAnly() {
		return Pop_userAnly;
	}

	public WebElement getPop_marketplace() {
		return Pop_marketplace;
	}

	@FindBy(xpath = "//span[text()='Apply']")
	private WebElement PopApplybtn;

	@FindBy(xpath = "(//div[@class='row uarow mt-1']) [1]")
	private List<WebElement> QAlist;

	@FindAll({ @FindBy(xpath = "(//div[@class='inner2 modal-inner'])[1]"),
			@FindBy(xpath = "(//div[@class='inner2'])[1]") })
	private WebElement Pop_card;

	public WebElement getPop_card() {
		return Pop_card;
	}

	public List<WebElement> getQAlist() {
		return QAlist;
	}

	public WebElement getPop_fav() {
		return Pop_fav;
	}

	public WebElement getPopApplybtn() {
		return PopApplybtn;
	}

	public WebElement getQAcardhover4() {
		return QAcardhover4;
	}

	public WebElement getQAcardclose4() {
		return QAcardclose4;
	}

	public WebElement getQAEdit() {
		return QAEdit;
	}

	public WebElement getTrialbanner() {
		return trialbanner;
	}

	public WebElement getHomepageLOGO() {
		return homepageLOGO;
	}

	public WebElement getQA1stElemnt() {
		return QA1stElemnt;
	}

	public WebElement getFavLM() {
		return favLM;
	}

//Recently viewed

	@FindBy(xpath = "//h3[text()=' Recently viewed']")
	private WebElement recentlyviewedtext;


	@FindBy(xpath = "(//div[@class='row uarow mt-1']) [2]")
	private List<WebElement> RVlist;

	public WebElement getRecentlyviewedtext() {
		return recentlyviewedtext;
	}

	public List<WebElement> getRVlist() {
		return RVlist;
	}
	
	@FindBy(xpath = "(//div[@class='row uarow mt-1']) [2]/child::div[1]")
	private WebElement rv1stelement;
	
	@FindBy(xpath = "//a[text()=' Marketplace']")
	private WebElement marketplaceLM;

	public WebElement getRv1stelement() {
		return rv1stelement;
	}

	public WebElement getMarketplaceLM() {
		return marketplaceLM;
	}
	
	//Dashboard history
	
	
	@FindBy(xpath = "//h3[text()=' Dashboard history']")
	private WebElement dashboardHitrytext;
	
	@FindBy(xpath = "(//div[@class='col-md-2 topbox col']) [1]")
	private WebElement DH1stdashboard;

	public WebElement getDashboardHitrytext() {
		return dashboardHitrytext;
	}

	public WebElement getDH1stdashboard() {
		return DH1stdashboard;
	}
	
	public WebElement getArrow1() {
		return arrow1;
	}

	public WebElement getArrow2() {
		return arrow2;
	}

	@FindBy(xpath = "//span[@class='arrow']/child::img")
	private WebElement arrow1;
	
	@FindBy(xpath = "//span[@class='arrow1']/child::img")
	private WebElement arrow2;
	
	@FindBy(xpath = "//div[@id='gridView']")
	private List<WebElement> listDashboards;

	public List<WebElement> getListDashboards() {
		return listDashboards;
	}
	
	@FindBy(xpath = "//a[text()='Click here to connect with our team']")
	private WebElement trialbannerSupport;

	public WebElement getTrialbannerSupport() {
		return trialbannerSupport;
	}
	
	
}
