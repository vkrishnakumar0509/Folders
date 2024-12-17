package org.pojo;

import org.base.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseMethods{

	
	//1.Non-parameterized constructor
	public LoginPojo() {

	PageFactory.initElements(driver, this);
	}
	
	//Login web elements- Setting up
	
	@FindBy(id="email")
	private WebElement txtboxemail;
	
	@FindBy(id="password")
	private WebElement textboxpassword;
	
	@FindBy (xpath="(//button[@type='submit']) [1]")
	private WebElement Signinbutn;
	
	@FindBy (xpath="//button[text()=' Sign in with Google ']")
	private WebElement Signingoogle;
	
	@FindBy (xpath="//button[text()=' Sign in with LinkedIn ']")
	private WebElement Signinlinkedin;
	
	@FindBy (xpath="//button[text()=' Sign in with Microsoft ']")
	private WebElement Signinmicrosoft;
	
	@FindBy (xpath="//span[text()='Next']")
	private WebElement googleNext;
	
	@FindBy (xpath="(//span[@class='VfPpkd-vQzf8d'] ) [2]")
	private WebElement googleNexttwo;
	
	@FindBy (xpath="//strong[text()='Terms of use']")
	private WebElement termsofuse;

	@FindBy (xpath="//strong[text()='Privacy policy']")
	private WebElement Privacypolicy;
	
	@FindBy (xpath="//a[text()='MADTechAI LLC']")
	private WebElement madtechllc;
	
	@FindBy (xpath="//a[text()=' Sign up for free trial ']")
	private WebElement Signupfree;
	
	@FindBy (xpath="//small[text()='Forgot your password?']")
	private WebElement forgotpassbtn;
	
	@FindBy (xpath="(//input[@id='email']) [2]")
	private WebElement fgtpasstextbox;
	
	@FindBy (xpath="//button[text()=' Cancel ']")
	private WebElement fgtpasscancel;
	
	@FindBy (xpath="//button[text()=' Submit ']")
	private WebElement fgtpasssubmit;
	
	@FindBy (xpath="//a[@class='close pull-right closeModal']")
	private WebElement fgtpasscloseicon;
	
	@FindBy (xpath="//span[@class='input-group-text']/child::i")
	private WebElement logineyeicon;
	
	@FindBy (xpath="//input[@id='remember_me']")
	private WebElement remembermecheckbox;
	
	@FindBy (xpath="//div[@class='col-md-12 p-t-2 text-center']/child::img")
	private WebElement loginLogo;
	
	@FindBy (xpath="//input[@id='identifierId']")
	private WebElement googleEmailTextbox;
	
	@FindBy (xpath="//input[@name='Passwd']")
	private WebElement googlePwdTextbox;
	
	@FindBy (xpath="(//div[@class='d-flex align-items-center'])[2]/child::div[1]")
	private WebElement profileIcon;
	
	@FindBy (xpath="//a[text()=' Sign Out']")
	private WebElement signoutbtn;
	

	public WebElement getTxtboxemail() {
		return txtboxemail;
	}

	public WebElement getTextboxpassword() {
		return textboxpassword;
	}

	public WebElement getSigninbutn() {
		return Signinbutn;
	}

	public WebElement getSigningoogle() {
		return Signingoogle;
	}

	public WebElement getSigninlinkedin() {
		return Signinlinkedin;
	}

	public WebElement getSigninmicrosoft() {
		return Signinmicrosoft;
	}

	public WebElement getGoogleNext() {
		return googleNext;
	}

	
	public WebElement getGoogleNexttwo() {
		return googleNexttwo;
	}

	public WebElement getTermsofuse() {
		return termsofuse;
	}

	public WebElement getPrivacypolicy() {
		return Privacypolicy;
	}

	public WebElement getMadtechllc() {
		return madtechllc;
	}

	public WebElement getSignupfree() {
		return Signupfree;
	}

	public WebElement getForgotpassbtn() {
		return forgotpassbtn;
	}

	public WebElement getFgtpasstextbox() {
		return fgtpasstextbox;
	}

	public WebElement getFgtpasscancel() {
		return fgtpasscancel;
	}

	public WebElement getFgtpasssubmit() {
		return fgtpasssubmit;
	}

	public WebElement getFgtpasscloseicon() {
		return fgtpasscloseicon;
	}

	public WebElement getLogineyeicon() {
		return logineyeicon;
	}

	public WebElement getRemembermecheckbox() {
		return remembermecheckbox;
	}

	public WebElement getLoginLogo() {
		return loginLogo;
	}

	public WebElement getGoogleEmailTextbox() {
		return googleEmailTextbox;
	}

	public WebElement getGooglePwdTextbox() {
		return googlePwdTextbox;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	
// custom domain WebElements
	
	@FindBy (xpath="//a[text()=' Sign up ']")
	private WebElement dcsignup;


	public WebElement getDcsignup() {
		return dcsignup;
	}
	
	
}
