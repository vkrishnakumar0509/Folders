package org.pojo;

import org.base.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPojo extends BaseMethods {

	public SignupPojo() {

		PageFactory.initElements(driver, this);
	}

	// Sign-up page

	@FindBy(xpath = "//a[text()=' Sign up for free trial ']")
	private WebElement Signupfree;
	
	@FindBy(xpath = "//input[@id='fname']")
	private WebElement fname;
	
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lName;
	
	@FindBy(xpath = "//input[@id='lname']")
	private WebElement AccntName;
	
	@FindBy(xpath = "(//button[text()=' Select an option ']) [1]")
	private WebElement accntType;

	@FindBy(xpath = "//button[@id='marketserved']")
	private WebElement marktServed;
	
	@FindBy(xpath = "//button[@id='title']")
	private WebElement dpmt;

	@FindBy(xpath = "//button[@id='interest']")
	private WebElement interest;
	
	@FindBy(xpath = "//button[@id='aboutMadtech']")
	private WebElement discoverMTAI;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement txtboxphone;
	
	@FindBy(xpath = "//div[@class='iti__selected-flag dropdown-toggle']/child::div")
	private WebElement countryPhone;
	
	@FindBy(xpath = "//input[@id='pwd']")
	private WebElement pwd;
	
	@FindBy(xpath = "//input[@id='cpwd']")
	private WebElement cpwd;
	
	@FindBy(xpath = "(//i[@class='pass_img fa fa-eye-slash']) [1]")
	private WebElement eyepwd;

	@FindBy(xpath = "(//i[@class='pass_img fa fa-eye-slash']) [2]")
	private WebElement eyecpwd;
	
	@FindBy(xpath = "//input[@id='terms']")
	private WebElement checkboxtc;
	
	@FindBy(xpath = "//button[text()=' Sign up for free trial ']")
	private WebElement formSubmit;
	
	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement rtnSignin;
	
	@FindBy(xpath = "//h1[text()='Get Started with ']/child::img")
	private WebElement logo;

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getlName() {
		return lName;
	}

	public WebElement getAccntName() {
		return AccntName;
	}

	public WebElement getAccntType() {
		return accntType;
	}

	public WebElement getMarktServed() {
		return marktServed;
	}

	public WebElement getDpmt() {
		return dpmt;
	}

	public WebElement getInterest() {
		return interest;
	}

	public WebElement getDiscoverMTAI() {
		return discoverMTAI;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTxtboxphone() {
		return txtboxphone;
	}

	public WebElement getCountryPhone() {
		return countryPhone;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getCpwd() {
		return cpwd;
	}

	public WebElement getEyepwd() {
		return eyepwd;
	}

	public WebElement getEyecpwd() {
		return eyecpwd;
	}

	public WebElement getCheckboxtc() {
		return checkboxtc;
	}

	public WebElement getFormSubmit() {
		return formSubmit;
	}

	public WebElement getRtnSignin() {
		return rtnSignin;
	}

	public WebElement getSignupfree() {
		return Signupfree;


	}
}
