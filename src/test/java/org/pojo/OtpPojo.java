package org.pojo;

import org.base.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtpPojo extends BaseMethods {

	public OtpPojo() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement verify;
	

	@FindBy(xpath = "//button[text()=' Back to Sign up ']")
	private WebElement rtnSignup;

	@FindBy(xpath = "//a[text()=' Resend verification code ']")
	private WebElement verificationCode;
	

	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement rtnSignin;
	

	@FindBy(xpath = "//input[@class='custom-otp-input otp-input ng-valid ng-touched ng-dirty']")
	private WebElement txtboxotp;


	@FindBy(xpath = "//h1[text()='Get Started with ']/child::img")
	private WebElement logo;


	@FindBy(xpath = "//h1[text()='Thanks for Signing Up!']/following::div[1]/child::span")
	private WebElement maskedEmail;
	
	public WebElement getMaskedEmail() {
		return maskedEmail;
	}


	public WebElement getLogo() {
		return logo;
	}


	public WebElement getVerify() {
		return verify;
	}


	public WebElement getRtnSignup() {
		return rtnSignup;
	}


	public WebElement getVerificationCode() {
		return verificationCode;
	}


	public WebElement getRtnSignin() {
		return rtnSignin;
	}


	public WebElement getTxtboxotp() {
		return txtboxotp;
	}

}
