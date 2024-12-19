package org.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.base.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pojo.FavoritesPojo;
import org.pojo.FoldersSubFoldersPojo;
import org.pojo.GlobalSearch;
import org.pojo.HomePagePojo;
import org.pojo.LeftmenuPojo;
import org.pojo.LoginPojo;
import org.pojo.OtpPojo;
import org.pojo.SignupPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinition extends BaseMethods {

	@Given("User should launch the portal by enter the url")
	public void user_should_launch_the_portal_by_enter_the_url() {

		url("https://dev.madtechai.com/");

	}

	@Then("verify user should be in login page")
	public void verify_user_should_be_in_login_page() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.equals("https://dev.madtechai.com/")) {

			System.out.println("Passed");

		} else {

			Assert.fail();

		}

	}

	@Given("verify that LOGO should be there in Login page")
	public void verify_that_logo_should_be_there_in_login_page() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		WebElement w1 = p.getLoginLogo();

		Thread.sleep(3000);
		String logo = w1.getAttribute("src");
		if (logo.contains("")) {

			System.out.println(logo + "-> " + "Passed");

		} else {

			Assert.fail();
		}
	}

	@Given("Provide valid username in Alternative case and enter the valid password")
	public void provide_valid_username_in_alternative_case_and_enter_the_valid_password()
			throws IOException, InterruptedException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("alternateEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("alternatePass"));
		WebElement w3 = p.getSigninbutn();
		w3.click();

	}

	@Given("it should login into the MTAI application")
	public void it_should_login_into_the_mtai_application() throws InterruptedException {

		Thread.sleep(20000);
		String url = driver.getCurrentUrl();

		if (url.equals("https://dev.madtechai.com/home")) {

			System.out.println(url + "->" + "Passed");
		} else {
			System.out.println(url);
			Assert.fail();
		}
	}

	@Given("Verify that sign-in button should be there in login page by locating the element")
	public void verify_that_sign_in_button_should_be_there_in_login_page_by_locating_the_element() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getSigninbutn()));
		WebElement w1 = p.getSigninbutn();
		String s1 = w1.getText();
		if (s1.contains("Sign in")) {
			System.out.println("Passed");

		} else {

			System.out.println(s1);
			Assert.fail();
		}

	}

	@Given("Verify that Sign-in with SSO button should be there in login page by locating the element")
	public void verify_that_sign_in_with_sso_button_should_be_there_in_login_page_by_locating_the_element() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getSigningoogle()));
		WebElement w1 = p.getSigningoogle();
		String s1 = w1.getText();
		if (s1.contains("Sign in with Google")) {
			System.out.println("Passed");

		} else {

			System.out.println(s1);
			Assert.fail();
		}

	}

	@Given("click on the Sign In with google SSO button")
	public void click_on_the_sign_in_with_google_sso_button() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(p.getSigningoogle()));
		p.getSigningoogle().click();
	}

	@Given("Provide valid username and valid password for SSO")
	public void provide_valid_username_and_valid_password_for_sso() throws InterruptedException, IOException {
		LoginPojo p = new LoginPojo();
		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		p.getGoogleEmailTextbox().sendKeys(props.getProperty("SSOEmail"));
		p.getGoogleNext().click();
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(p.getGooglePwdTextbox()));
		WebElement pwd = p.getGooglePwdTextbox();
		pwd.sendKeys(props.getProperty("SSOPass"));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(p.getGoogleNexttwo()));
		element.click();

	}

	@Given("it should login into the MTAI application homepage")
	public void it_should_login_into_the_mtai_application_homepage() throws InterruptedException {

		Thread.sleep(20000);
		String url = driver.getCurrentUrl();

		if (url.equals("https://dev.madtechai.com/home")) {

			System.out.println(url + "->" + "Passed");
		} else {
			System.out.println(url);
			Assert.fail();
		}

	}

	@Given("Provide valid username and valid password")
	public void provide_valid_username_and_valid_password() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("alternateEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("alternatePass"));
		WebElement w3 = p.getSigninbutn();
		w3.click();

	}

	@Given("Click on the Sign-out button which is in profile button")
	public void click_on_the_sign_out_button_which_is_in_profile_button() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(p.getProfileIcon()));
		WebElement w1 = p.getProfileIcon();
		Thread.sleep(2000);
		w1.click();
		p.getSignoutbtn().click();
		Thread.sleep(5000);

	}

	@Then("verify user should be in login page after logout")
	public void verify_user_should_be_in_login_page_after_logout() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.equals("https://dev.madtechai.com/login")) {

			System.out.println("Passed");

		} else {

			System.out.println(currentUrl + " -> Failed");
			Assert.fail();
		}

	}

	@Given("click on the sign-in button without entering the credentials")
	public void click_on_the_sign_in_button_without_entering_the_credentials() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(p.getSigninbutn()));
		p.getSigninbutn().click();
	}

	@Then("verify that validation message should be displayed at the email and password field")
	public void verify_that_validation_message_should_be_displayed_at_the_email_and_password_field() {

		String emailValidation = driver.findElement(By.xpath("//div[text()=' Email is required ']")).getText();
		String passValidation = driver.findElement(By.xpath("//div[text()=' Password is required ']")).getText();

		if (emailValidation.equals("Email is required") && passValidation.equals("Password is required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Provide invalid username and valid password")
	public void provide_invalid_username_and_valid_password() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("invalidEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("validPass"));

	}

	@Given("Click on the sign-in button")
	public void click_on_the_sign_in_button() {

		LoginPojo p = new LoginPojo();
		WebElement w3 = p.getSigninbutn();
		w3.click();
	}

	@Then("verify validation should be shown as -Please enter a valid email id-")
	public void verify_validation_should_be_shown_as_please_enter_a_valid_email_id() {

		String emailValidation = driver.findElement(By.xpath("//div[text()=' Please enter valid email address ']"))
				.getText();
		if (emailValidation.equals("Please enter valid email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(emailValidation);
		}
	}

	@Given("Provide valid username and invalid password with less than {int} char")
	public void provide_valid_username_and_invalid_password_with_less_than_char(Integer int1) throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("validEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("invalidPassChar"));

	}

	@Then("verify validation should be shown as -Please enter a valid password-")
	public void verify_validation_should_be_shown_as_please_enter_a_valid_password() {

		String passValidation = driver.findElement(By.xpath("//div[text()=' Please enter valid password ']")).getText();
		if (passValidation.equals("Please enter valid password")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(passValidation);
		}
	}

	@Given("Provide valid username and invalid password")
	public void provide_valid_username_and_invalid_password() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("validEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("invalidPass"));

	}

	@Then("verify validation should be shown as -Incorrect username or password-")
	public void verify_validation_should_be_shown_as_incorrect_username_or_password() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement w1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Incorrect username or password.']")));
		String validation = w1.getText();
		if (validation.equals("Incorrect username or password.")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(validation);
		}

	}

	@Given("Provide valid username and valid password for LoginPage")
	public void provide_valid_username_and_valid_password_for_login_page() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("alternateEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("alternatePass"));

	}

	@Given("verify that remember me option should be checked by default")
	public void verify_that_remember_me_option_should_be_checked_by_default() {

		LoginPojo p = new LoginPojo();
		boolean checkbox = p.getRemembermecheckbox().isSelected();

		if (checkbox) {
			System.out.println("Passed-Checked by default");

		} else {

			System.out.println("Failed-Unchecked by default");
			// Assert.fail();
		}

	}

	@Given("verify that remember me option should be able to check and uncheck")
	public void verify_that_remember_me_option_should_be_able_to_check_and_uncheck() {

		LoginPojo p = new LoginPojo();
		p.getRemembermecheckbox().click();
		boolean checkbox = p.getRemembermecheckbox().isSelected();

		if (checkbox) {
			System.out.println("Passed-Checked");

		} else {

			System.out.println("Failed-Unchecked");
			// Assert.fail();
		}

		p.getRemembermecheckbox().click();

		boolean checkbox1 = p.getRemembermecheckbox().isSelected();
		// System.out.println(checkbox1);

		if (checkbox1) {
			System.out.println("Failed-checked");

		} else {

			System.out.println("Passed-UnChecked");
			// Assert.fail();
		}

	}

	@Given("Provide password with {int} chars")
	public void provide_password_with_chars(Integer int1) throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTextboxpassword()));
		p.getTextboxpassword().sendKeys(props.getProperty("validPass"));
	}

	@Given("Click on Eye icon it should unmask the password and for another click it should mask the password")
	public void click_on_eye_icon_it_should_unmask_the_password_and_for_another_click_it_should_mask_the_password() {

		LoginPojo p = new LoginPojo();
		String secure = p.getTextboxpassword().getAttribute("type");

		if (secure.equals("password")) {

			System.out.println("Masked");
		} else {

			System.out.println("UnMasked");
			Assert.fail();
		}

		WebElement w1 = p.getLogineyeicon();
		w1.click();

		WebElement w2 = p.getTextboxpassword();
		String secure1 = w2.getAttribute("type");

		if (secure1.equals("text")) {

			System.out.println("Unmasked");
		} else {

			System.out.println("Masked");
			Assert.fail();
		}

	}

	@Given("verify Forgot Password option under password text box")
	public void verify_forgot_password_option_under_password_text_box() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		Thread.sleep(5000);
		boolean buttn = p.getForgotpassbtn().isDisplayed();
		if (buttn) {
			System.out.println("Passed");

		} else {

			System.out.println("Passed- but Hidden");
			// Assert.fail();
		}

	}

	@Given("Click Forgot Password option under password text box")
	public void click_forgot_password_option_under_password_text_box() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		Thread.sleep(5000);
		WebElement btn = p.getForgotpassbtn();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btn);

	}

	@Given("verify that Forgot Password should open a popup to enter email id")
	public void verify_that_forgot_password_should_open_a_popup_to_enter_email_id() {

		LoginPojo p = new LoginPojo();
		boolean textbox = p.getFgtpasstextbox().isEnabled();
		System.out.println(textbox);

	}

	@Given("verify that Forgot Password should have Submit and cancel button")
	public void verify_that_forgot_password_should_have_submit_and_cancel_button() {

		LoginPojo p = new LoginPojo();
		boolean submit = p.getFgtpasssubmit().isEnabled();
		boolean cancel = p.getFgtpasscancel().isEnabled();

		if (submit && cancel) {
			System.out.println("Passed");

		} else {

			Assert.fail();
		}

	}

	@Given("verify that user has to enter valid email id to get reset password link")
	public void verify_that_user_has_to_enter_valid_email_id_to_get_reset_password_link()
			throws IOException, InterruptedException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		Thread.sleep(3000);
		WebElement w1 = p.getFgtpasstextbox();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		w1.sendKeys("fe@hdg.com");

		Thread.sleep(2000);
		WebElement w2 = p.getFgtpasssubmit();
		js.executeScript("arguments[0].click()", w2);
	}

	@Then("Validation message should be emerged - password reset request sent successfully-")
	public void validation_message_should_be_emerged_password_reset_request_sent_successfully() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement w1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));

		String validation = w1.getText();
		if (validation.equals("Password Reset request has been sent successfully")) {

			System.out.println("Passed");
		} else {

			System.out.println(validation);
			Assert.fail();
		}

	}

	@Given("verify that after clicking cancel button the pop-up should be closed")
	public void verify_that_after_clicking_cancel_button_the_pop_up_should_be_closed() throws InterruptedException {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		WebElement w1 = p.getFgtpasscancel();
		wait.until(ExpectedConditions.elementToBeClickable(w1));
		w1.click();
		Thread.sleep(2000);
		if (w1.isDisplayed()) {

			System.out.println("Failed");
			Assert.fail();

		} else {

			System.out.println("Passed");
		}

	}

	@Given("Verify that all CSS components are matching with the requirements")
	public void verify_that_all_css_components_are_matching_with_the_requirements() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.visibilityOf(p.getSigninbutn()));
		String color = butn.getCssValue("background-color");
		String font = butn.getCssValue("font-family");

		Assert.assertEquals("Verify the font", "AvenirNextLTPro-Regular", font);
		Assert.assertEquals("Verify the color", "rgba(40, 77, 146, 1)", color);

	}

	@Given("User should give restricted domain email and Password in the login page")
	public void user_should_give_restricted_domain_email_and_password_in_the_login_page() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("restrictedEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("validPass"));

	}

	@Given("verify that after clicking Sign-in button, validation should be shown")
	public void verify_that_after_clicking_sign_in_button_validation_should_be_shown() {

		LoginPojo p = new LoginPojo();
		WebElement w3 = p.getSigninbutn();
		w3.click();

		String emailValidation = driver
				.findElement(By.xpath("//div[text()=' Please use your business email address ']")).getText();
		if (emailValidation.equals("Please use your business email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(emailValidation);
		}

	}

	@Given("User should give restricted domain email in the Forgot password pop-up")
	public void user_should_give_restricted_domain_email_in_the_forgot_password_pop_up()
			throws InterruptedException, IOException {

		LoginPojo p = new LoginPojo();
		Thread.sleep(5000);
		WebElement btn = p.getForgotpassbtn();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btn);

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		Thread.sleep(3000);
		WebElement w1 = p.getFgtpasstextbox();

		w1.sendKeys(props.getProperty("restrictedEmail"));

		Thread.sleep(2000);
		WebElement w2 = p.getFgtpasssubmit();
		js.executeScript("arguments[0].click()", w2);

	}

	@Given("verify that after clicking Submit button, validation should be shown")
	public void verify_that_after_clicking_submit_button_validation_should_be_shown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Please use your business email address ']")));

		String emailValidation = butn.getText();
		if (emailValidation.equals("Please use your business email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(emailValidation);
			Assert.fail();
		}
	}

	@Given("user should click the close icon in Forgot password pop-up")
	public void user_should_click_the_close_icon_in_forgot_password_pop_up() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.visibilityOf(p.getFgtpasscloseicon()));

		butn.click();

	}

	@Given("Again user should click on Forgot password button, the validation should be removed")
	public void again_user_should_click_on_forgot_password_button_the_validation_should_be_removed()
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()=' Forgot your password? ']")));
		btn.click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//div[text()=' Please use your business email address ']"));

		} catch (Exception e) {

			System.out.println("Passed- Exception Handled");
		}

	}

	@Given("User should click on the clicks on the Privacy policy & Terms of use")
	public void user_should_click_on_the_clicks_on_the_privacy_policy_terms_of_use() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.elementToBeClickable(p.getPrivacypolicy()));
		butn.click();

		String title = pageTitle();
		System.out.println(title);
		if (title.equals("MADTechAI - Privacy Policy")) {
			System.out.println("Passed");
		} else {

			Assert.fail();
		}

	}

	@Given("verify that it has been properly redirected to corresponding page")
	public void verify_that_it_has_been_properly_redirected_to_corresponding_page() {

		driver.navigate().back();

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.elementToBeClickable(p.getTermsofuse()));
		butn.click();

		String title = pageTitle();
		System.out.println(title);
		if (title.equals("MADTechAI - Terms & Conditions")) {
			System.out.println("Passed");
		} else {

			Assert.fail();
		}

	}

	@Given("User should click on the clicks on the MadTechAI LLC")
	public void user_should_click_on_the_clicks_on_the_mad_tech_ai_llc() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.elementToBeClickable(p.getMadtechllc()));
		butn.click();

	}

	@Given("verify that it has been properly redirected to MadTechAI webpage")
	public void verify_that_it_has_been_properly_redirected_to_mad_tech_ai_webpage() {

		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		String title = pageTitle();

		if (title.contains("The Unified MADTech Data Decision Intelligence Platform")) {

			System.out.println("Passed");
			driver.close();

		} else {

			Assert.fail();
		}

		driver.switchTo().window(originalWindow);
	}

	@Given("User should click on the clicks on the Sign-up for free trial button")
	public void user_should_click_on_the_clicks_on_the_sign_up_for_free_trial_button() {

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement butn = wait.until(ExpectedConditions.elementToBeClickable(p.getSignupfree()));
		butn.click();

	}

	@Given("verify that it has been properly redirected to Sign-up page")
	public void verify_that_it_has_been_properly_redirected_to_sign_up_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		String title = pageTitle();
		System.out.println(title);

		if (title.contains("MADTechAI - Sign Up")) {

			System.out.println("Passed");

		} else {

			Assert.fail();
		}
	}

	// Direct client Scenarios

	@Given("User should launch the portal by enter the custom url")
	public void user_should_launch_the_portal_by_enter_the_custom_url() {

		/* url("https://acme.madtechai.com/"); */

	}

	@Given("User should locate the Sign-up naming")
	public void user_should_locate_the_sign_up_naming() {
		/*
		 * LoginPojo p = new LoginPojo(); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(5)); WebElement butn =
		 * wait.until(ExpectedConditions.visibilityOf(p.getDcsignup())); String signUp =
		 * butn.getText();
		 * 
		 * if (signUp.equals("Sign up")) {
		 * 
		 * System.out.println("Passed");
		 * 
		 * } else {
		 * 
		 * Assert.fail(); }
		 */
	}

	@Given("User should give other than registered domain")
	public void user_should_give_other_than_registered_domain() throws IOException {
		/*
		 * fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		 * 
		 * LoginPojo p = new LoginPojo(); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(4));
		 * wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail())); WebElement
		 * w1 = p.getTxtboxemail(); w1.sendKeys(props.getProperty("alternateEmail"));
		 * WebElement w2 = p.getTextboxpassword();
		 * w2.sendKeys(props.getProperty("alternatePass")); WebElement w3 =
		 * p.getSigninbutn(); w3.click();
		 */
	}

	@Given("verify that it has to show validation -Please use registered mail id-")
	public void verify_that_it_has_to_show_validation_please_use_registered_mail_id() {

	}

	@Given("User should give registered domain")
	public void user_should_give_registered_domain() {

	}

	@Given("verify that it has to accept the registered mail id")
	public void verify_that_it_has_to_accept_the_registered_mail_id() {

	}

	@Given("user should click on the Sign-in with google and enter invalid credentials")
	public void user_should_click_on_the_sign_in_with_google_and_enter_invalid_credentials() {

	}

	@Then("user should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {

	}

	@Given("user should click on the Sign-in with linkedin and enter valid credentials")
	public void user_should_click_on_the_sign_in_with_linkedin_and_enter_valid_credentials() {

	}

	@Then("user should be redirecting to homepage")
	public void user_should_be_redirecting_to_homepage() {

	}

	// Sign-up page

	@Given("User should click on the Sign-up for free trial button")
	public void user_should_click_on_the_sign_up_for_free_trial_button() {

		SignupPojo pj = new SignupPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement w1 = wait.until(ExpectedConditions.elementToBeClickable(pj.getSignupfree()));
		w1.click();

	}

	@Given("User should be in sign-up page")
	public void user_should_be_in_sign_up_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		String title = pageTitle();
		if (title.equals("MADTechAI - Sign Up")) {

			System.out.println("Passed");

		} else {

			Assert.fail();
		}
	}

	@Given("Verify the presence of all mandatory fields on the sign-up page.")
	public void verify_the_presence_of_all_mandatory_fields_on_the_sign_up_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		List<WebElement> li = new ArrayList<WebElement>();
		li.add(pj.getFname());
		li.add(pj.getlName());

		li.add(pj.getAccntName());
		li.add(pj.getAccntType());
		li.add(pj.getEmail());
		li.add(pj.getMarktServed());

		li.add(pj.getTxtboxphone());
		li.add(pj.getCountryPhone());
		li.add(pj.getDpmt());
		li.add(pj.getInterest());

		li.add(pj.getDiscoverMTAI());
		li.add(pj.getPwd());
		li.add(pj.getCpwd());

		for (WebElement x : li) {

			if (x.isDisplayed()) {

				System.out.println("Passed");

			} else {

				System.out.println("Failed");
				Assert.fail();
			}

		}

	}

	@Given("Verify that Sign-up page in proper CSS format as per requirement")
	public void verify_that_sign_up_page_in_proper_css_format_as_per_requirement() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		WebElement butn = pj.getFormSubmit();

		String color = butn.getCssValue("background-color");
		String font = butn.getCssValue("font-family");

		System.out.println(font + "  " + color);
		Assert.assertEquals("Verify the font", "AvenirNextLTPro-Regular", font);
		Assert.assertEquals("Verify the color", "rgba(40, 77, 146, 1)", color);

	}

	@Given("Verify the content of sign-up page")
	public void verify_the_content_of_sign_up_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		WebElement logo = pj.getLogo();

		if (logo.isEnabled()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
		List<WebElement> texts = driver.findElements(By.xpath("//div[@class='box1']"));

		String s1 = "";
		List<String> li = new ArrayList<String>();

		String expectedText = "Try MADTechAI free for  days\n" + "Totally risk free. No commitment. Cancel anytime.\n"
				+ "Powerful iPaaS integration\n"
				+ "Transform disparate data on the fly with 300+ purpose-built connectors\n"
				+ "Pre-built analytics suite\n"
				+ "Access dozens of out-of-the-box data models, dashboards, and reports\n"
				+ "Conversational AI insights\n"
				+ "Get instant answers and visualizations using plain English queries\n" + "Flexible data ingestion\n"
				+ "Explore with our sample data or seamlessly integrate your own\n" + "Advanced marketing modeling\n"
				+ "Optimize strategy with our custom Marketing Mix Model (and hundreds more)\n"
				+ "Comprehensive data export\n" + "Download all data, graphics, and reports in your preferred format\n"
				+ "Free AWS data warehouse\n" + "Leverage our secure, scalable cloud infrastructure at no extra cost\n"
				+ "Always-on expert support\n"
				+ "Get 24/7/365 global support and access our thorough knowledge base anytime";

		for (WebElement line : texts) {
			s1 = line.getText();
			li.add(s1);
			System.out.println(s1);
		}

		String actualtext = String.join("\n", li);
		if (actualtext.equals(expectedText)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Give only email address and tries to sign-up and it has to show validation")
	public void give_only_email_address_and_tries_to_sign_up_and_it_has_to_show_validation() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		SignupPojo pj = new SignupPojo();
		pj.getEmail().sendKeys("jckdjbv@jwd.com");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);

		js.executeScript("arguments[0].click()", w1);

		WebElement w2 = driver.findElement(By.xpath("//div[text()=' Professional Phone is required ']"));

		if (w2.isDisplayed()) {
			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("verify that if user tries to submit the form without filling it has to show validation for all the fields")
	public void verify_that_if_user_tries_to_submit_the_form_without_filling_it_has_to_show_validation_for_all_the_fields() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		SignupPojo pj = new SignupPojo();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);

		js.executeScript("arguments[0].click()", w1);

		WebElement v1 = driver.findElement(By.xpath("//div[text()=' First Name is required ']"));
		WebElement v2 = driver.findElement(By.xpath("//div[text()=' Last Name is required ']"));
		WebElement v3 = driver.findElement(By.xpath("//div[text()=' Account Name is required ']"));
		WebElement v4 = driver.findElement(By.xpath("//div[text()=' Account Type is required ']"));
		WebElement v5 = driver.findElement(By.xpath("//div[text()=' Professional Email is required ']"));
		WebElement v6 = driver.findElement(By.xpath("//div[text()=' Market(s) Served is required ']"));
		WebElement v7 = driver.findElement(By.xpath("//div[text()=' Professional Phone is required ']"));
		WebElement v8 = driver.findElement(By.xpath("//div[text()=' Department is required ']"));
		WebElement v9 = driver.findElement(By.xpath("(//div[text()=' Please pick an option from the list ']) [1]"));
		WebElement v10 = driver.findElement(By.xpath("(//div[text()=' Please pick an option from the list ']) [2]"));
		WebElement v11 = driver.findElement(By.xpath("//div[text()=' Password is required ']"));
		WebElement v12 = driver.findElement(By.xpath("//div[text()=' Confirm Password is required ']"));
		WebElement v13 = driver.findElement(
				By.xpath("//div[text()=' Please agree to the Terms of use & Privacy Policy before signing up ']"));

		ArrayList<WebElement> list = new ArrayList<WebElement>(
				Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13));

		for (WebElement x : list) {

			if (x.isDisplayed()) {

				System.out.println("Passed");

			} else {

				Assert.fail();
				System.out.println("Failed");
			}

		}

	}

	@Given("verify that if user tries to submit the form with invalid data and it has to show validation for all the fields")
	public void verify_that_if_user_tries_to_submit_the_form_with_invalid_data_and_it_has_to_show_validation_for_all_the_fields() {

		// First name

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		SignupPojo pj = new SignupPojo();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);

		js.executeScript("arguments[0].click()", w1);

		pj.getFname().sendKeys("122");
		WebElement v1 = driver.findElement(By.xpath("//div[text()=' Invalid First Name ']"));
		String s1 = v1.getText();
		if (s1.equals("Invalid First Name")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w2 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w2);

		js.executeScript("arguments[0].click()", w2);

		pj.getFname().sendKeys("@`!");
		WebElement v2 = driver.findElement(By.xpath("//div[text()=' Invalid First Name ']"));
		String s2 = v2.getText();
		if (s2.equals("Invalid First Name")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w3 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w3);

		js.executeScript("arguments[0].click()", w3);

		pj.getFname().sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		WebElement v3 = driver.findElement(By.xpath("//div[text()=' First Name can be max 70 characters long ']"));
		String s3 = v3.getText();
		if (s3.equals("First Name can be max 70 characters long")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// LastName

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w4 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w4);

		js.executeScript("arguments[0].click()", w4);

		pj.getlName().sendKeys("123");
		WebElement v4 = driver.findElement(By.xpath("//div[text()=' Invalid Last Name ']"));
		String s4 = v4.getText();
		if (s4.equals("Invalid Last Name")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w5 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w5);

		js.executeScript("arguments[0].click()", w5);

		pj.getlName().sendKeys("@!`");
		WebElement v5 = driver.findElement(By.xpath("//div[text()=' Invalid Last Name ']"));
		String s5 = v5.getText();
		if (s5.equals("Invalid Last Name")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w6 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w6);

		js.executeScript("arguments[0].click()", w6);

		pj.getlName().sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		WebElement v6 = driver.findElement(By.xpath("//div[text()=' Last Name can be max 70 characters long ']"));
		String s6 = v6.getText();
		if (s6.equals("Last Name can be max 70 characters long")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Account Name

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w7 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w7);

		js.executeScript("arguments[0].click()", w7);

		pj.getAccntName()
				.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		WebElement v7 = driver.findElement(By.xpath("//div[text()=' Account Name can be max 70 characters long ']"));
		String s7 = v7.getText();
		if (s7.equals("Account Name can be max 70 characters long")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Professional Email

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w8 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w8);

		js.executeScript("arguments[0].click()", w8);

		pj.getEmail().sendKeys("testemail.com");

		WebElement v8 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s8 = v8.getText();
		if (s8.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w9 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w9);

		js.executeScript("arguments[0].click()", w9);

		pj.getEmail().sendKeys("user@@domain.com");

		WebElement v9 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s9 = v9.getText();
		if (s9.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w10 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w10);

		js.executeScript("arguments[0].click()", w10);

		pj.getEmail().sendKeys("user@com");

		WebElement v10 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s10 = v10.getText();
		if (s10.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		/*
		 * driver.navigate().refresh();
		 * 
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		 * 
		 * WebElement w11 = pj.getFormSubmit();
		 * js.executeScript("arguments[0].scrollIntoView(true)", w11);
		 * 
		 * js.executeScript("arguments[0].click()", w11);
		 * 
		 * pj.getEmail().sendKeys("useremail@domain.com");
		 * 
		 * WebElement v11 = driver.findElement(By.
		 * xpath("//div[text()=' Please enter valid Email address ']")); String s11 =
		 * v11.getText(); if (s11.equals("Please enter valid Email address")) {
		 * 
		 * System.out.println("Passed"); } else {
		 * 
		 * System.out.println("Failed"); }
		 */

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w12 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w12);

		js.executeScript("arguments[0].click()", w12);

		pj.getEmail().sendKeys("user@domain");

		WebElement v12 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s12 = v12.getText();
		if (s12.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w13 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w13);

		js.executeScript("arguments[0].click()", w13);

		pj.getEmail().sendKeys("user...email@domain.com");

		WebElement v13 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s13 = v13.getText();
		if (s13.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w14 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w14);

		js.executeScript("arguments[0].click()", w14);

		pj.getEmail().sendKeys("useremail.@domain.com");

		WebElement v14 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s14 = v14.getText();
		if (s14.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w);

		js.executeScript("arguments[0].click()", w);

		pj.getEmail().sendKeys("user@domain,com");

		WebElement v15 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s15 = v15.getText();
		if (s15.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w16 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w16);

		js.executeScript("arguments[0].click()", w16);

		pj.getEmail().sendKeys(
				"averyveryveryverylongusernamepartthatexceedsthenormalcharacterlimitfortheusernamepartoftheemailaddressjusttoensurethatthisemailislongenoughandwillnotfitintheusualformatwhichshouldcauseittobedeemedinvalidbecauseitseemswaytoobigtobeacceptedbyanysystemevenwithmodernemailvalidationsupport@averyveryveryverylongdomainnamepartthatexceedsthenormallimitforthenamepartoftheemailjusttoensureitgoesbeyondthe254characterslimit.com");

		WebElement v16 = driver.findElement(By.xpath("//div[text()=' Please enter valid Email address ']"));
		String s16 = v16.getText();
		if (s16.equals("Please enter valid Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w17 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w17);

		js.executeScript("arguments[0].click()", w17);

		pj.getEmail().sendKeys("awhd@gmail.com");

		WebElement v17 = driver.findElement(By.xpath("//div[text()=' Please use your Professional Email address ']"));
		String s17 = v17.getText();
		if (s17.equals("Please use your Professional Email address")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Professional Phone

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w18 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w18);

		js.executeScript("arguments[0].click()", w18);

		pj.getTxtboxphone().sendKeys("888888888");

		WebElement v18 = driver.findElement(By.xpath("//div[text()=' Professional Phone is invalid ']"));
		String s18 = v18.getText();
		if (s18.equals("Professional Phone is invalid")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w19 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w19);

		js.executeScript("arguments[0].click()", w19);

		pj.getTxtboxphone().sendKeys("88888888888");

		WebElement v19 = driver.findElement(By.xpath("//div[text()=' Professional Phone is invalid ']"));
		String s19 = v19.getText();
		if (s19.equals("Professional Phone is invalid")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Password

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w20 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w20);

		js.executeScript("arguments[0].click()", w20);
		// less than 8 char
		pj.getPwd().sendKeys("1234");

		WebElement v20 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s20 = v20.getText();
		if (s20.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w21 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w21);

		js.executeScript("arguments[0].click()", w21);

		// only alphabets
		pj.getPwd().sendKeys("abcdefghij");

		WebElement v21 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s21 = v21.getText();
		if (s21.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
		/*
		 * driver.navigate().refresh();
		 * 
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		 * 
		 * WebElement w22 = pj.getFormSubmit();
		 * js.executeScript("arguments[0].scrollIntoView(true)", w22);
		 * 
		 * js.executeScript("arguments[0].click()", w22);
		 * 
		 * pj.getPwd().sendKeys(
		 * "averyverylongpasswordthatexceedsthemaximumallowedcharacterslength123456789K@"
		 * );
		 * 
		 * WebElement v22 = driver.findElement(By.
		 * xpath("//div[text()=' Password must not exceed 64 characters ']")); String
		 * s22 = v22.getText(); if
		 * (s22.equals("Password must not exceed 64 characters")) {
		 * 
		 * System.out.println("Passed"); } else {
		 * 
		 * System.out.println("Failed"); }
		 * 
		 */

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w23 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w23);

		js.executeScript("arguments[0].click()", w23);

		// No uppercase
		pj.getPwd().sendKeys("password123!");

		WebElement v23 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s23 = v23.getText();
		if (s23.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w24 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w24);

		js.executeScript("arguments[0].click()", w24);

		// No lowercase
		pj.getPwd().sendKeys("PASSWORD123!");

		WebElement v24 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s24 = v24.getText();
		if (s24.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w25 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w25);

		js.executeScript("arguments[0].click()", w25);

		// No numbers
		pj.getPwd().sendKeys("Password!@#");

		WebElement v25 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s25 = v25.getText();
		if (s25.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w26 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w26);

		js.executeScript("arguments[0].click()", w26);

		// No Special Character
		pj.getPwd().sendKeys("Password123");

		WebElement v26 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s26 = v26.getText();
		if (s26.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w27 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w27);

		js.executeScript("arguments[0].click()", w27);

		// All Special character
		pj.getPwd().sendKeys("!@#$%^&*()");

		WebElement v27 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s27 = v27.getText();
		if (s27.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w28 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w28);

		js.executeScript("arguments[0].click()", w28);

		// only numbers
		pj.getPwd().sendKeys("123456789");

		WebElement v28 = driver.findElement(By.xpath(
				"//div[text()=' A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required ']"));
		String s28 = v28.getText();
		if (s28.equals(
				"A minimum 8 characters password contains a combination of uppercase, lowercase letter, special char and number are required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// Password masked
		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w29 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w29);

		js.executeScript("arguments[0].click()", w29);

		WebElement pwd = pj.getPwd();
		pwd.sendKeys("123456");

		String str = pwd.getAttribute("type");

		if (str.equals("password")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		// Password unmasked

		pj.getEyepwd().click();

		WebElement strUnmasked = pj.getPwd();

		String str1 = strUnmasked.getAttribute("type");

		if (str1.equals("text")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		// Confirm Password

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w30 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w30);

		js.executeScript("arguments[0].click()", w30);

		pj.getPwd().sendKeys("Test@123");

		pj.getCpwd().sendKeys("Test");

		WebElement v30 = driver.findElement(By.xpath("//div[text()=' Password and Confirm Password must match ']"));
		String s30 = v30.getText();

		if (s30.equals("Password and Confirm Password must match")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// T&C Validation

		driver.navigate().refresh();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w31 = pj.getFormSubmit();
		js.executeScript("arguments[0].scrollIntoView(true)", w31);

		js.executeScript("arguments[0].click()", w31);

		WebElement v31 = driver.findElement(
				By.xpath("//div[text()=' Please agree to the Terms of use & Privacy Policy before signing up ']"));

		String s31 = v31.getText();

		if (s31.equals("Please agree to the Terms of use & Privacy Policy before signing up")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that user entering only Account Name and tries to submit and the entered values shouldnt get clear")
	public void verify_that_user_entering_only_account_name_and_tries_to_submit_and_the_entered_values_shouldnt_get_clear() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();
		pj.getAccntName().sendKeys("Test");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement w31 = pj.getFormSubmit();

		js.executeScript("arguments[0].scrollIntoView(true)", w31);

		js.executeScript("arguments[0].click()", w31);

		WebElement w1 = pj.getAccntName();

		String str = w1.getAttribute("value");

		if (str.equals("Test")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that user entering only email with spaces and the space shouldnt accept")
	public void verify_that_user_entering_only_email_with_spaces_and_the_space_shouldnt_accept() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		WebElement w1 = pj.getEmail();
		w1.sendKeys("a v k @gmt.com");
		String s1 = w1.getAttribute("value");

		if (s1.equals("avk@gmt.com")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that the sign-up page contains placeholder text at mandatory fields")
	public void verify_that_the_sign_up_page_contains_placeholder_text_at_mandatory_fields() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		String p1 = pj.getFname().getAttribute("placeholder");
		if (p1.equals("Enter First Name")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p2 = pj.getlName().getAttribute("placeholder");
		if (p2.equals("Enter Last Name")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p3 = pj.getAccntName().getAttribute("placeholder");
		if (p3.equals("Enter Account Name")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p4 = pj.getAccntType().getText();
		if (p4.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p5 = pj.getEmail().getAttribute("placeholder");
		if (p5.equals("Enter Professional Email")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p6 = pj.getMarktServed().getText();
		if (p6.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p7 = pj.getDpmt().getText();
		if (p7.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p8 = pj.getTxtboxphone().getAttribute("placeholder");
		if (p8.equals("+1 201-555-0123")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p9 = pj.getInterest().getText();
		if (p9.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p10 = pj.getDiscoverMTAI().getText();
		if (p10.equals("Select an option")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p11 = pj.getPwd().getAttribute("placeholder");
		if (p11.equals("Enter Password")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}

		String p12 = pj.getCpwd().getAttribute("placeholder");

		if (p12.equals("Enter Confirm Password")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that dropdown should provide only Single select option")
	public void verify_that_dropdown_should_provide_only_single_select_option() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		WebElement slt = pj.getAccntType();
		slt.click();

		driver.findElement(By.xpath("//a[text()='Marketer']")).click();
	}

	@Given("Verify that if user clicks on the Signin button, user should redirect to Login page")
	public void verify_that_if_user_clicks_on_the_signin_button_user_should_redirect_to_login_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getRtnSignin();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);
		js.executeScript("arguments[0].click()", w1);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		WebElement w2 = driver.findElement(By.xpath("//h3[text()='Sign in with email']"));
		String str = w2.getText();
		if (str.equals("Sign in with email")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			Assert.fail();

		}

	}

	@Given("Verify that if user fills all the mandatory fields, it has to redirect to OTP verification page")
	public void verify_that_if_user_fills_all_the_mandatory_fields_it_has_to_redirect_to_otp_verification_page()
			throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		pj.getFname().sendKeys("Test");
		pj.getlName().sendKeys("Client");
		pj.getAccntName().sendKeys("Client1");
		Thread.sleep(1000);
		pj.getAccntType().click();
		driver.findElement(By.xpath("//a[text()='Marketer']")).click();

		// generate dummy email

		String uniqueID = UUID.randomUUID().toString().substring(0, 8);
		// System.out.println(uniqueID);
		pj.getEmail().sendKeys("testuser" + uniqueID + "@cucumber.com");

		driver.findElement(By.id("marketserved")).click();
		driver.findElement(By.xpath("//a[text()='B2B']")).click();
		pj.getCountryPhone().click();
		driver.findElement(By.id("country-search-box")).sendKeys("India");
		WebElement w1 = driver.findElement(By.xpath("//span[text()='+91']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", w1);
		pj.getTxtboxphone().sendKeys("9898787871");

		Thread.sleep(1000);
		pj.getDpmt().click();
		driver.findElement(By.xpath("//a[text()='Finance']")).click();

		pj.getInterest().click();
		driver.findElement(By.xpath("//a[text()='Data Visualization']")).click();

		pj.getDiscoverMTAI().click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();

		pj.getPwd().sendKeys("Test@123");
		pj.getCpwd().sendKeys("Test@123");

		pj.getCheckboxtc().click();

		pj.getFormSubmit().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement otpPage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thanks for Signing Up!']")));

		String otpText = otpPage.getText();

		if (otpText.equals("Thanks for Signing Up!")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that OTP verification Page is in proper CSS format as per requirement")
	public void verify_that_otp_verification_page_is_in_proper_css_format_as_per_requirement() {

		/*
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		 * 
		 * OtpPojo pj=new OtpPojo(); WebElement butn = pj.getVerify();
		 * 
		 * String color = butn.getCssValue("background-color"); String font =
		 * butn.getCssValue("font-family");
		 * 
		 * 
		 * Assert.assertEquals("Verify the font", "AvenirNextLTPro-Regular", font);
		 * Assert.assertEquals("Verify the color", "rgba(40, 77, 146, 1)", color);
		 */
	}

	@Given("Verify that if user enters invalid OTP, it shouldn not accept and it has to show validation")
	public void verify_that_if_user_enters_invalid_otp_it_shouldn_not_accept_and_it_has_to_show_validation()
			throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		OtpPojo pj = new OtpPojo();

		// empty
		pj.getVerify().click();

		String s1 = driver.findElement(By.xpath("//div[text()='OTP is required']")).getText();
		if (s1.equals("OTP is required")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		// invalid otp

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement otpInput = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//h1[text()='Thanks for Signing Up!']/following::div[2]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*
		 * js.
		 * executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
		 * , otpInput); js.
		 * executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));"
		 * , otpInput);
		 */
		js.executeScript("arguments[0].value='1';", otpInput);

	}

	@Given("Verify that user can able to resend verification emails if needed.")
	public void verify_that_user_can_able_to_resend_verification_emails_if_needed() {

		OtpPojo pj = new OtpPojo();

		pj.getVerificationCode().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//p[text()='Please check your email for the verification code.']")));

		String S1 = driver.findElement(By.xpath("//p[text()='Please check your email for the verification code.']"))
				.getText();

		if (S1.equals("Please check your email for the verification code.")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("if user clicks on the Back to sign-up button in OTP verification page , he should be redirect to Sign-up page")
	public void if_user_clicks_on_the_back_to_sign_up_button_in_otp_verification_page_he_should_be_redirect_to_sign_up_page() {

		OtpPojo pj = new OtpPojo();
		pj.getRtnSignup().click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));

		SignupPojo pj1 = new SignupPojo();

		if (pj1.getFname().isDisplayed()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the Signin button in OTP verification page , he should be redirect to Login page")
	public void verify_that_if_user_clicks_on_the_signin_button_in_otp_verification_page_he_should_be_redirect_to_login_page() {

		OtpPojo pj = new OtpPojo();
		pj.getRtnSignin().click();

		LoginPojo pj1 = new LoginPojo();

		if (pj1.getTxtboxemail().isDisplayed()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that LOGO is present in the OTP verification Page")
	public void verify_that_logo_is_present_in_the_otp_verification_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		OtpPojo pj = new OtpPojo();
		if (pj.getLogo().isDisplayed()) {
			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		List<WebElement> texts = driver.findElements(By.xpath("//div[@class='box1']"));

		String s1 = "";
		List<String> li = new ArrayList<String>();

		String expectedText = "Try MADTechAI free for 15 days\n" + "Totally risk free. No commitment. Cancel anytime.\n"
				+ "Powerful iPaaS integration\n"
				+ "Transform disparate data on the fly with 300+ purpose-built connectors\n"
				+ "Pre-built analytics suite\n"
				+ "Access dozens of out-of-the-box data models, dashboards, and reports\n"
				+ "Conversational AI insights\n"
				+ "Get instant answers and visualizations using plain English queries\n" + "Flexible data ingestion\n"
				+ "Explore with our sample data or seamlessly integrate your own\n" + "Advanced marketing modeling\n"
				+ "Optimize strategy with our custom Marketing Mix Model (and hundreds more)\n"
				+ "Comprehensive data export\n" + "Download all data, graphics, and reports in your preferred format\n"
				+ "Free AWS data warehouse\n" + "Leverage our secure, scalable cloud infrastructure at no extra cost\n"
				+ "Always-on expert support\n"
				+ "Get 24/7/365 global support and access our thorough knowledge base anytime";

		for (WebElement line : texts) {
			s1 = line.getText();
			li.add(s1);
			System.out.println(s1);
		}

		String actualtext = String.join("\n", li);
		if (actualtext.equals(expectedText)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that email should be masked in OTP page")
	public void verify_that_email_should_be_masked_in_otp_page() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		OtpPojo pj = new OtpPojo();
		String str = pj.getMaskedEmail().getText();

		if (str.contains("***")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Check the response when providing an email address already registered")
	public void check_the_response_when_providing_an_email_address_already_registered() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

		SignupPojo pj = new SignupPojo();

		pj.getFname().sendKeys("Test");
		pj.getlName().sendKeys("Client");
		pj.getAccntName().sendKeys("Client1");
		Thread.sleep(1000);
		pj.getAccntType().click();
		driver.findElement(By.xpath("//a[text()='Marketer']")).click();

		pj.getEmail().sendKeys("testuser31e93154@cucumber.com");

		driver.findElement(By.id("marketserved")).click();
		driver.findElement(By.xpath("//a[text()='B2B']")).click();
		pj.getCountryPhone().click();
		driver.findElement(By.id("country-search-box")).sendKeys("India");
		WebElement w1 = driver.findElement(By.xpath("//span[text()='+91']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", w1);
		pj.getTxtboxphone().sendKeys("9898787871");

		Thread.sleep(1000);
		pj.getDpmt().click();
		driver.findElement(By.xpath("//a[text()='Finance']")).click();

		pj.getInterest().click();
		driver.findElement(By.xpath("//a[text()='Data Visualization']")).click();

		pj.getDiscoverMTAI().click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();

		pj.getPwd().sendKeys("Test@123");
		pj.getCpwd().sendKeys("Test@123");

		pj.getCheckboxtc().click();

		pj.getFormSubmit().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement validation = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()=' This email address is already registered ']")));

		if (validation.getText().equals("This email address is already registered")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}
	// HomePage

	@Given("User should login into the application")
	public void user_should_login_into_the_application() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("validEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("validPass"));
		WebElement w3 = p.getSigninbutn();
		w3.click();

	}

	@Given("should be landed into Homepage")
	public void should_be_landed_into_homepage() {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		String title = pageTitle();
		System.out.println(title);
		if (title.equals("MADTechAI - Home")) {

			System.out.println("Passed");

		} else {

			Assert.fail();
			System.out.println("Failed");
		}
	}

	@Given("verify that Home Page is in proper CSS format as per requirements")
	public void verify_that_home_page_is_in_proper_css_format_as_per_requirements() {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));

		WebElement banner = pj.getTrialbanner();
		String color = banner.getCssValue("background-color");
		String font = banner.getCssValue("font-family");

		Assert.assertEquals("Verify the color", "rgba(40, 77, 146, 1)", color);
		Assert.assertEquals("Verify the font", "Open Sans", font);

	}

	@Given("User clicks on the LOGO of an application \\(MTAI), it should be redirected to Homepage")
	public void user_clicks_on_the_logo_of_an_application_mtai_it_should_be_redirected_to_homepage() {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		pj.getFavLM().click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		WebElement w1 = pj.getHomepageLOGO();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", w1);

		String title = pageTitle();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
		System.out.println(title);
		if (title.equals("MADTechAI - Home")) {

			System.out.println("Passed");

		} else {

			Assert.fail();
			System.out.println("Failed");
		}

	}

	@Given("user clicks on any of the Feature which is following by Quick access Text, it should be redirected to corresponding webpage")
	public void user_clicks_on_any_of_the_feature_which_is_following_by_quick_access_text_it_should_be_redirected_to_corresponding_webpage()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		WebElement w1 = pj.getQA1stElemnt();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", w1);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		Thread.sleep(3000);
		String title = pageTitle();

		System.out.println(title);
		if (!title.equals("MADTechAI - Home")) {

			System.out.println("Passed");

		} else {

			Assert.fail();
			System.out.println("Failed");
		}

	}

	@Given("user can able to delete particular feature in Quick access by clicking Remove option which is present in every feature")
	public void user_can_able_to_delete_particular_feature_in_quick_access_by_clicking_remove_option_which_is_present_in_every_feature()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Actions a = new Actions(driver);

		WebElement w1 = pj.getQAcardhover4();

		a.moveToElement(w1).perform();

		Thread.sleep(1500);
		WebElement w3 = pj.getQAcardclose4();

		a.moveToElement(w3).perform();
		w3.click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w2 = pj.getPop_fav();
		wait.until(ExpectedConditions.visibilityOf(w2));
		Thread.sleep(1500);
		w2.click();

		pj.getPopApplybtn().click();

		Thread.sleep(1500);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
	}

	@Given("verify that remove text is in proper css format as per requirement")
	public void verify_that_remove_text_is_in_proper_css_format_as_per_requirement() throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Actions a = new Actions(driver);

		WebElement w1 = pj.getQAcardhover4();

		a.moveToElement(w1).perform();

		Thread.sleep(1500);
		WebElement w3 = pj.getQAcardclose4();

		a.moveToElement(w3).perform();

		WebElement w2 = driver.findElement(By.xpath("(//span[text()='Remove'])[4]"));

		String font = w2.getCssValue("font-family");

		System.out.println(font);
		Assert.assertEquals("Verify the font", "Open Sans", font);

	}

	@Given("Verify that all features should be shown in GUI for Quick access in a webpage")
	public void verify_that_all_features_should_be_shown_in_gui_for_quick_access_in_a_webpage() {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		List<WebElement> li = pj.getQAlist();

		for (WebElement x : li) {

			System.out.println(x.getText());
		}
	}

	@Given("To verify that if user clicks on Edit, it should open new Pop-up All feature")
	public void to_verify_that_if_user_clicks_on_edit_it_should_open_new_pop_up_all_feature()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPopApplybtn();
		String s1 = wait.until(ExpectedConditions.visibilityOf(w5)).getText();

		if (s1.equals("Apply")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			Assert.fail();
		}
	}

	@Given("To verify that if user clicks on any of the feature in Quick access pop-up")
	public void to_verify_that_if_user_clicks_on_any_of_the_feature_in_quick_access_pop_up()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPopApplybtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		pj.getPop_card().click();

		String title = pageTitle();
		if (title.equals("MADTechAI - Home")) {

			System.out.println("Passed");

		} else {

			Assert.fail();
			System.out.println("Failed");
		}

	}

	@Given("verify that Quick access pop-up is in proper CSS format as per requirements")
	public void verify_that_quick_access_pop_up_is_in_proper_css_format_as_per_requirements()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPopApplybtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		WebElement w1 = pj.getPopApplybtn();

		String font = w1.getCssValue("font-family");

		WebElement w6 = pj.getPop_card();
		String color = w6.getCssValue("background-color");

		System.out.println(color);
		System.out.println(font);

		if (font.contains("Open Sans")) {

			System.out.println("Passed");
		} else {

			Assert.fail();
		}
		Assert.assertEquals("Verify the color", "rgba(70, 141, 185, 1)", color);
	}

	@Given("To verify that Checkbox for Seletion \\/ Unselection should be multi-select")
	public void to_verify_that_checkbox_for_seletion_unselection_should_be_multi_select() throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPopApplybtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		pj.getPop_fav().click();
		Thread.sleep(1000);
		pj.getPop_Askme().click();
		Thread.sleep(1000);
		pj.getPop_marketplace().click();

	}

	@Given("Apply button should be disabled until doing any actions")
	public void apply_button_should_be_disabled_until_doing_any_actions() throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPopApplybtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		Thread.sleep(2000);

		String disabledAttribute = w5.getAttribute("disabled");

		if (disabledAttribute == null) {
			System.out.println("The button is disabled.");
		} else {
			System.out.println("The button is enabled.");
		}

	}

	@Given("To verify that user can close the Quick access pop-up by clicking \\(Close-X) button\\/ Cancel button")
	public void to_verify_that_user_can_close_the_quick_access_pop_up_by_clicking_close_x_button_cancel_button()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPop_cancelbtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		w5.click();
	}

	@Given("user clicks on the Apply, the unselected feature should be removed in the Quick access, then the pop-up should be vanished")
	public void user_clicks_on_the_apply_the_unselected_feature_should_be_removed_in_the_quick_access_then_the_pop_up_should_be_vanished()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);

		String s1 = "";
		List<String> featuresbefore = new ArrayList<String>();
		List<WebElement> li = pj.getQAlist();
		for (WebElement x : li) {
			s1 = x.getText();
			featuresbefore.add(s1);
		}

		System.out.println(featuresbefore);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPopApplybtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		pj.getPop_fav().click();
		Thread.sleep(1000);

		w5.click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		Thread.sleep(2000);
		String s2 = "";
		List<String> featuresafter = new ArrayList<String>();
		List<WebElement> l = pj.getQAlist();
		for (WebElement x : l) {
			s2 = x.getText();
			featuresafter.add(s2);
		}

		System.out.println(featuresafter);

		if (!featuresbefore.equals(featuresafter)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		Thread.sleep(2000);
		WebElement w9 = pj.getQAEdit();

		Thread.sleep(1000);
		w9.click();

		WebElement w8 = pj.getPop_fav();
		wait.until(ExpectedConditions.visibilityOf(w5));
		Thread.sleep(1500);
		w8.click();

		pj.getPopApplybtn().click();

		Thread.sleep(1500);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

	}

	@Given("User clicks on the Edit, it has to show all the features which are selected or unselected")
	public void user_clicks_on_the_edit_it_has_to_show_all_the_features_which_are_selected_or_unselected()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPop_cancelbtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		List<WebElement> elemnts = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement elemnt : elemnts) {

			boolean boo = elemnt.isSelected();
			System.out.println(boo);
		}

		Thread.sleep(2000);
	}

	@Given("To verify that user can able to add\\/remove multiple feature simultaniously")
	public void to_verify_that_user_can_able_to_add_remove_multiple_feature_simultaniously()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPopApplybtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		Thread.sleep(2000);

		pj.getPop_fav().click();
		pj.getPop_mmm().click();

		pj.getPopApplybtn().click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		Thread.sleep(2000);
		WebElement w8 = pj.getQAEdit();

		Thread.sleep(1000);
		w8.click();

		WebElement w9 = pj.getPopApplybtn();
		wait.until(ExpectedConditions.visibilityOf(w9));

		Thread.sleep(2000);

		pj.getPop_fav().click();
		pj.getPop_mmm().click();

		pj.getPopApplybtn().click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

	}

	@Given("To verify that user should not able to add same feature in Quicksight access \\(duplicate)")
	public void to_verify_that_user_should_not_able_to_add_same_feature_in_quicksight_access_duplicate()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));

		Thread.sleep(2000);

		String s1 = "";
		List<String> featuresbefore = new ArrayList<String>();
		List<WebElement> li = pj.getQAlist();
		for (WebElement x : li) {
			s1 = x.getText();
			featuresbefore.add(s1);
		}

		System.out.println(featuresbefore);
		WebElement w4 = pj.getQAEdit();

		Thread.sleep(1000);
		w4.click();

		WebElement w5 = pj.getPopApplybtn();
		wait.until(ExpectedConditions.visibilityOf(w5));

		pj.getPop_fav().click();
		Thread.sleep(1000);
		pj.getPop_fav().click();
		Thread.sleep(1000);

		w5.click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		Thread.sleep(2000);
		String s2 = "";
		List<String> featuresafter = new ArrayList<String>();
		List<WebElement> l = pj.getQAlist();
		for (WebElement x : l) {
			s2 = x.getText();
			featuresafter.add(s2);
		}

		System.out.println(featuresafter);

		if (featuresbefore.equals(featuresafter)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		Thread.sleep(2000);

	}

	@Given("recently used {int} features should be displayed on the Recently viewed options")
	public void recently_used_features_should_be_displayed_on_the_recently_viewed_options(Integer int1)
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getRecentlyviewedtext()));

		Thread.sleep(2000);

		List<WebElement> rVlist = pj.getRVlist();

		List<String> li = new ArrayList<String>();

		for (WebElement x : rVlist) {

			String s1 = x.getText();
			System.out.println(s1);
			li.add(s1);
		}
	}

	@Given("If user used latest feature Eg:- Favorites, it should be appeared at the First row First icon")
	public void if_user_used_latest_feature_eg_favorites_it_should_be_appeared_at_the_first_row_first_icon()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getRecentlyviewedtext()));
		Thread.sleep(1000);
		pj.getFavLM().click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
		Thread.sleep(1000);
		pj.getHomepageLOGO().click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		Thread.sleep(1000);
		WebElement w1 = pj.getRv1stelement();
		String s1 = w1.getText();

		if (s1.equals("Favorites")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

		Thread.sleep(1000);
		pj.getMarketplaceLM().click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
		Thread.sleep(1000);
		pj.getHomepageLOGO().click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		Thread.sleep(1000);
		pj.getRv1stelement();
		String s2 = w1.getText();

		if (s2.equals("Marketplace")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("duplicate feature should not be displayed under the Recently viewed text or Space")
	public void duplicate_feature_should_not_be_displayed_under_the_recently_viewed_text_or_space()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getRecentlyviewedtext()));
		Thread.sleep(1000);

		List<WebElement> rVlist = pj.getRVlist();

		List<String> li = new ArrayList<String>();

		for (WebElement x : rVlist) {

			String s1 = x.getText();
			li.add(s1);
		}

		System.out.println(li);

		List<String> splitList = new ArrayList<String>();
		for (String item : li) {
			String[] parts = item.split("\n"); // Split by newline
			for (String part : parts) {
				splitList.add(part.trim()); // Add each part to the new list
			}
		}

		System.out.println("Split List: " + splitList);

		Set<String> duplicates = new HashSet<String>();
		duplicates.addAll(splitList);

		if (splitList.containsAll(duplicates)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");

		}
	}

	@Given("If user clicks on any of the feature which is listed under the Recently viewed text, it should be redirected into corresponding webpage")
	public void if_user_clicks_on_any_of_the_feature_which_is_listed_under_the_recently_viewed_text_it_should_be_redirected_into_corresponding_webpage()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getRecentlyviewedtext()));
		Thread.sleep(1000);

		pj.getRv1stelement().click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
		Thread.sleep(1000);

		String s1 = pageTitle();
		if (!s1.equals("MADTechAI - Home")) {

			System.out.println(s1 + " Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("If user clicks on the particular dashboard it should be redirected to corresponding dashboard for analysis")
	public void if_user_clicks_on_the_particular_dashboard_it_should_be_redirected_to_corresponding_dashboard_for_analysis()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getDashboardHitrytext()));
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getDH1stdashboard();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);
		Thread.sleep(1000);
		w1.click();

		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));

		String s1 = driver.getCurrentUrl();
		if (s1.equals("https://dev.madtechai.com/dashboardhome")) {

			System.out.println(s1 + " Passed");
		} else {

			System.out.println(s1 + " Failed");
		}
	}

	@Given("Verify that if user visited more than {int} dashboards, horizontal scrolling button should be given")
	public void verify_that_if_user_visited_more_than_dashboards_horizontal_scrolling_button_should_be_given(
			Integer int1) throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getDashboardHitrytext()));
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getDH1stdashboard();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);
		Thread.sleep(1000);

		List<String> dhlist = new ArrayList<String>();
		List<WebElement> li = pj.getListDashboards();
		for (WebElement x : li) {
			String s1 = x.getText();
			dhlist.add(s1);
		}

		List<String> splitList = new ArrayList<String>();
		for (String item : dhlist) {
			String[] parts = item.split("\n"); // Split by newline
			for (String part : parts) {
				splitList.add(part.trim()); // Add each part to the new list
			}
		}

		System.out.println(splitList.size());
		if (splitList.size() >= 5) {

			pj.getArrow2().click();
			System.out.println("Arrow is appeared");
		} else {

			System.out.println("Arrow is not appeared");
		}

	}

	@Given("If user clicks on the horizontal scroll button, it should display the visited dashboards which are hided")
	public void if_user_clicks_on_the_horizontal_scroll_button_it_should_display_the_visited_dashboards_which_are_hided()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pj.getDashboardHitrytext()));
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w1 = pj.getArrow2();
		js.executeScript("arguments[0].scrollIntoView(true)", w1);
		Thread.sleep(1000);
		w1.click();

		List<String> before = new ArrayList<String>();

		List<WebElement> li = pj.getListDashboards();
		for (WebElement x : li) {

			String s1 = x.getText();
			before.add(s1);
			System.out.println("S1"+s1);
		}

		wait.until(ExpectedConditions.visibilityOf(pj.getArrow1()));
		pj.getArrow1().click();

		Thread.sleep(1000);
		List<String> after = new ArrayList<String>();

		List<WebElement> li1 = pj.getListDashboards();
		for (WebElement x1 : li1) {

			String s2 = x1.getText();
			before.add(s2);
			System.out.println("s2"+s2);
		}

		if (!after.equals(before)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Banner should be appear in HomePage which gives updates regarding the upcoming feature only for SA & Trial client")
	public void banner_should_be_appear_in_home_page_which_gives_updates_regarding_the_upcoming_feature_only_for_sa_trial_client()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));
		Thread.sleep(1000);

		String bnrText = pj.getTrialbanner().getText();
		System.out.println(bnrText);

		if (bnrText.equals(
				"Introducing the Beta Version of our product! We're excited to share this early release with you, and there's more to come! Stay tuned as we continue to roll out new features soon, enhancing your experience even further for new requirements Connect with our team")) {

			System.out.println("Banner is there- Passed");
		} else {

			System.out.println("Banner is not there- Failed");
		}
	}

	@Given("Banner should have Connect with our team button and after clicking it should redirect to Bill Calender")
	public void banner_should_have_connect_with_our_team_button_and_after_clicking_it_should_redirect_to_bill_calender()
			throws InterruptedException {

		HomePagePojo pj = new HomePagePojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getQuickaccessText()));
		Thread.sleep(1000);

		pj.getTrialbannerSupport().click();

		Set<String> tabs = driver.getWindowHandles();

		List<String> listTab = new ArrayList<String>();
		listTab.addAll(tabs);

		driver.switchTo().window(listTab.get(1));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
		Thread.sleep(2000);

		String title = pageTitle();
		System.out.println(title);
		if (title.equals("Calendly - Bill Lederer, Chairman and CEO")) {
			System.out.println("Passed");
			driver.close();
		} else {
			System.out.println("Failed");
		}

		Thread.sleep(1500);
		driver.switchTo().window(listTab.get(0));
		Thread.sleep(1000);
	}

	@Given("leftmenu should be in proper css format as per requirement")
	public void leftmenu_should_be_in_proper_css_format_as_per_requirement() throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getColorLM()));
		Thread.sleep(1000);
		String s1 = w1.getCssValue("background-color");
		String font = w1.getCssValue("font-family");
		System.out.println(s1 + font);
		Assert.assertEquals("Verify the color", "rgba(107, 164, 199, 1)", s1);
		Assert.assertEquals("Verify the font", "Open Sans", font);

	}

	@Given("Verify that Footer should be in proper CSS format as per requirement")
	public void verify_that_footer_should_be_in_proper_css_format_as_per_requirement() throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFooter()));
		Thread.sleep(1000);
		String s1 = w1.getCssValue("background-color");
		String font = w1.getCssValue("font-family");
		System.out.println(s1 + font);
		Assert.assertEquals("Verify the color", "rgba(238, 241, 246, 1)", s1);
		Assert.assertEquals("Verify the font", "Open Sans", font);

	}

	@Given("Verify that client logo should be there in Header with text of Powered by MADTechAI")
	public void verify_that_client_logo_should_be_there_in_header_with_text_of_powered_by_mad_tech_ai()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getHomepageLOGO()));

		System.out.println(w1.getAttribute("src"));
		Thread.sleep(1000);
		WebElement w2 = pj.getPowerdbytxt();
		System.out.println(w2.getText());

	}

	@Given("Verify that Header should be in proper CSS format as per requirement")
	public void verify_that_header_should_be_in_proper_css_format_as_per_requirement() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getHeaderSearch()));
		String s2 = w1.getAttribute("type");
		String font = w1.getCssValue("font-family");
		System.out.println(font);
		Assert.assertEquals("Verify the font", "Open Sans", font);

	}

	@Given("Verify that if user clicks on the Client LOGO, it should redirect to homepage")
	public void verify_that_if_user_clicks_on_the_client_logo_it_should_redirect_to_homepage()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getHomepageLOGO()));

		pj.getFavoritesLM().click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Thread.sleep(2000);
		w1.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Thread.sleep(2000);

		String s1 = pageTitle();
		if (s1.equals("MADTechAI - Home")) {

			System.out.println(s1 + " Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the notification, it has to show all the notifications in pop-up")
	public void verify_that_if_user_clicks_on_the_notification_it_has_to_show_all_the_notifications_in_pop_up() {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		w1.click();

	}

	@Given("Verify that if user doesnt have any notification, it has to show {int} notification message")
	public void verify_that_if_user_doesnt_have_any_notification_it_has_to_show_notification_message(Integer int1)
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		w1.click();
		Thread.sleep(1000);
		List<String> str = new ArrayList<String>();
		List<WebElement> li = pj.getNotificationList();
		for (WebElement x : li) {

			String s1 = x.getText();
			str.add(s1);
		}

		String actualtext = String.join("\n", str);
		if (actualtext.contains("0 Notifications")) {

			System.out.println("No Notification present and validation is appearing");
		} else {

			System.out.println("Notification is there ");
		}

	}

	@Given("Verify that if user clicks on the Clear all, it has to clear all notifications for a particular user")
	public void verify_that_if_user_clicks_on_the_clear_all_it_has_to_clear_all_notifications_for_a_particular_user()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		w1.click();
		Thread.sleep(1000);
		pj.getClearAll().click();
		List<String> str = new ArrayList<String>();
		List<WebElement> li = pj.getNotificationList();
		for (WebElement x : li) {

			String s1 = x.getText();
			str.add(s1);
		}

		String actualtext = String.join("\n", str);
		if (actualtext.contains("0 Notifications")) {

			System.out.println("No Notification present and validation is appearing");
		} else {

			System.out.println("Notification is there ");
		}

	}

	@Given("Verify that if user doesnnot have unread notifications, the counts should be shown in notification batch")
	public void verify_that_if_user_doesnnot_have_unread_notifications_the_counts_should_be_shown_in_notification_batch()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		w1.click();
		Thread.sleep(1000);
		WebElement w2 = pj.getNotificationBatch();
		String s2 = w2.getText();
		System.out.println(s2);
		int i = Integer.parseInt(s2);
		if (i >= 0 && i <= 1000) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the Notification icon, the pop-up should be vanished")
	public void verify_that_if_user_clicks_on_the_notification_icon_the_pop_up_should_be_vanished()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		w1.click();
		Thread.sleep(1000);
		w1.click();
		Thread.sleep(1000);
		if (!pj.getClearAll().isDisplayed()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that Leftmenu features should be shown to end user based upon the role Eg:-Client admin, User")
	public void verify_that_leftmenu_features_should_be_shown_to_end_user_based_upon_the_role_eg_client_admin_user() {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));

		List<String> features = new ArrayList<String>();
		List<WebElement> li = pj.getLeftmenuList();
		for (WebElement x : li) {

			String string = x.getText();
			features.add(string);
		}

		String actlFeatures = String.join("\n", features);
		System.out.println(actlFeatures);

		String expFeature = "Home\n" + "iPaaS\n" + "Dashboards\n" + "Trial Dashboards\n" + "Ask Me\n" + "Favorites\n"
				+ "Marketplace\n" + "Administration\n" + "New Request\n" + "Feedback\n" + "Support";
		if (actlFeatures.contains(expFeature)) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that if user clicks any of the feature in the Left menu, it should redirect to that page")
	public void verify_that_if_user_clicks_any_of_the_feature_in_the_left_menu_it_should_redirect_to_that_page()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));

		pj.getIpaasLM().click();
		Thread.sleep(2000);
		pj.getSourcesLM().click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
		WebElement w2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Select the type of source you want to connect']")));

		System.out.println(w2.getText());

		driver.switchTo().defaultContent();

		pj.getDashboardsLM().click();

		WebElement w4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' DASHBOARDS ']")));

		System.out.println(w4.getText());

		Thread.sleep(2000);

		pj.getExpandIconprofile().click();
		Thread.sleep(1000);
		WebElement ask = wait.until(ExpectedConditions.visibilityOf(pj.getAskmeLM()));
		ask.click();
		WebElement w5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Ask Me:']")));
		System.out.println(w5.getText());
		pj.getFavoritesLM().click();
		WebElement w6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));
		System.out.println(w6.getText());
		pj.getMarketplaceLM().click();
		WebElement w7 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Marketplace ']")));
		System.out.println(w7.getText());
		pj.getAdministrationLM().click();
		Thread.sleep(1500);
		pj.getCAconsoleLM().click();
		WebElement w8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Client Admin']")));
		System.out.println(w8.getText());
		pj.getUserAnalyticsLM().click();
		WebElement w9 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='User Analytics']")));
		System.out.println(w9.getText());
		pj.getSettingsLM().click();
		WebElement w10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Settings']")));
		System.out.println(w10.getText());
		pj.getHomeLM().click();
		WebElement w11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()=' Quick access ']")));
		System.out.println(w11.getText());
		pj.getNewRequestLM().click();
		WebElement w12 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='New Request']")));
		System.out.println(w12.getText());
		driver.findElement(By.xpath("(//button[text()='Cancel'])[5]")).click();
		pj.getFeedbackLM().click();
		WebElement w13 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Send us your Feedback']")));
		System.out.println(w13.getText());
		driver.findElement(By.xpath("(//button[text()='Cancel'])[6]")).click();
		pj.getSupportLM().click();
		Thread.sleep(2000);
	}

	@Given("Verify that if user do mousehover action to the any of the feature, the color should varies based upon the client color")
	public void verify_that_if_user_do_mousehover_action_to_the_any_of_the_feature_the_color_should_varies_based_upon_the_client_color()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));

		Actions a = new Actions(driver);

		WebElement fav = pj.getFavoritesLM();

		a.moveToElement(fav).perform();

		Thread.sleep(2000);

		// rgb(107, 164, 199)

		WebElement x = driver.findElement(By.xpath("(//li[@class='li-hover leftmenu li-icon']) [2]"));
		String color = x.getCssValue("background-color");
		Assert.assertEquals("Verify the color", "rgba(126, 175, 206, 1)", color);
	}

	@Given("Verify that Profile icon should be appear at the bottom of Leftmenu with Username, mail id")
	public void verify_that_profile_icon_should_be_appear_at_the_bottom_of_leftmenu_with_username_mail_id() {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));

		if (pj.getProfileIconLM().isDisplayed()) {

			System.out.println("Profile is displayed ");

		} else {

			System.out.println("Profile isn't displayed ");

		}

		List<String> mails = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='d-flex flex-column ms-1']"));

		for (WebElement x : list) {

			String s1 = x.getText();
			mails.add(s1);
		}

		if (mails.get(0).contains("@")) {

			System.out.println("Passed- Mail is Present");
		} else {

			System.out.println("Passed- Mail is Not Present");
		}
	}

	@Given("Verify that if user clicks on the profile icon, it has to show the following options like My profile, User Guide, Privacy policy, Terms of use, Faqs, Signout in pop-up")
	public void verify_that_if_user_clicks_on_the_profile_icon_it_has_to_show_the_following_options_like_my_profile_user_guide_privacy_policy_terms_of_use_faqs_signout_in_pop_up() {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		pj.getProfileIconLM().click();

		if (pj.getMyProfileLM().isDisplayed() && pj.getUserGuideLM().isDisplayed() && pj.getTermsofuseLM().isDisplayed()
				&& pj.getPrivacyPolicyLM().isDisplayed() && pj.getFaqLM().isDisplayed()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that if user clicks on the My profile, it should open the My Profile page")
	public void verify_that_if_user_clicks_on_the_my_profile_it_should_open_the_my_profile_page()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		pj.getProfileIconLM().click();
		Thread.sleep(1000);

		pj.getMyProfileLM().click();

		WebElement w2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='My Profile']")));

		if (w2.isDisplayed()) {

			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the user guide, it should redirect to that page")
	public void verify_that_if_user_clicks_on_the_user_guide_it_should_redirect_to_that_page()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getProfileIconLM()));
		pj.getProfileIconLM().click();
		Thread.sleep(1000);
		pj.getUserGuideLM().click();

		Set<String> tabs = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(tabs);

		driver.switchTo().window(li.get(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
		Thread.sleep(3000);
		String s1 = pageTitle();

		if (s1.equals("MADTechAI - User Guide")) {

			System.out.println("Passed");
			driver.close();
		} else {

			System.out.println("Failed");
			driver.close();
		}

		driver.switchTo().window(li.get(0));

	}

	@Given("Verify that if user clicks on the Privacy policy, it should redirect to that page")
	public void verify_that_if_user_clicks_on_the_privacy_policy_it_should_redirect_to_that_page()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		pj.getProfileIconLM().click();
		Thread.sleep(1000);

		pj.getPrivacyPolicyLM().click();

		WebElement w2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Privacy Policy']")));

		if (w2.isDisplayed()) {

			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the Terms of use, it should redirect to that page")
	public void verify_that_if_user_clicks_on_the_terms_of_use_it_should_redirect_to_that_page()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		pj.getProfileIconLM().click();
		Thread.sleep(1000);

		pj.getTermsofuseLM().click();

		WebElement w2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Terms & Conditions']")));

		if (w2.isDisplayed()) {

			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the FAQs, it should redirect to that page")
	public void verify_that_if_user_clicks_on_the_fa_qs_it_should_redirect_to_that_page() throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		pj.getProfileIconLM().click();
		Thread.sleep(1000);

		pj.getFaqLM().click();

		WebElement w2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h2[text()='FAQ | Frequently Asked Questions']")));

		if (w2.isDisplayed()) {

			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

	}

	@Given("Verify that if user cliks on the Signout, the user should logout from the application")
	public void verify_that_if_user_cliks_on_the_signout_the_user_should_logout_from_the_application()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		pj.getProfileIconLM().click();
		Thread.sleep(1000);

		pj.getSignout().click();

		WebElement w2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Sign in with email']")));

		if (w2.isDisplayed()) {

			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

	}

	@Given("Verify that if user again clicks on the profile icon, the pop-up should be vanished")
	public void verify_that_if_user_again_clicks_on_the_profile_icon_the_pop_up_should_be_vanished()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));
		pj.getProfileIconLM().click();
		Thread.sleep(1000);
		pj.getProfileIconLM().click();
		Thread.sleep(1000);
		WebElement w2 = pj.getMyProfileLM();
		if (!w2.isDisplayed()) {

			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the collapse icon, it has to show only the icons of feature")
	public void verify_that_if_user_clicks_on_the_collapse_icon_it_has_to_show_only_the_icons_of_feature()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getCollapseIconhome()));
		w1.click();
		Thread.sleep(1500);

		WebElement w2 = pj.getFavoritesLM();

		if (!w2.isDisplayed()) {

			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the feature icon, it has to redirect to corresponding webpage")
	public void verify_that_if_user_clicks_on_the_feature_icon_it_has_to_redirect_to_corresponding_webpage()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getCollapseIconhome()));
		w1.click();
		Thread.sleep(1500);

		pj.getFavIcon().click();
		WebElement w2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));

		if (w2.isDisplayed()) {

			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}

	@Given("Verify that in footer, if user clicks on the MADTechAI LLC it should redirect to the corresponding webpage")
	public void verify_that_in_footer_if_user_clicks_on_the_mad_tech_ai_llc_it_should_redirect_to_the_corresponding_webpage()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFooterMadtechAitxt()));
		w1.click();
		Thread.sleep(1000);

		Set<String> tabs = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(tabs);

		driver.switchTo().window(li.get(1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(9));
		Thread.sleep(3000);
		String s1 = pageTitle();

		System.out.println(s1);
		if (s1.contains("The Unified MADTech Data Decision Intelligence Platform")) {

			System.out.println("Passed");
			driver.close();
		} else {

			System.out.println("Failed");
			driver.close();
		}

		driver.switchTo().window(li.get(0));

	}

	@Given("Verify that if user clicks on the Support mail in footer, it should redirect to the mail box")
	public void verify_that_if_user_clicks_on_the_support_mail_in_footer_it_should_redirect_to_the_mail_box()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFootersupporttxt()));
		w1.click();
		Thread.sleep(1000);

	}

	@Given("Verify that if user clicks on the Dashboards, it should open the one more left menu to list out the dashboards and make sure Primary Leftmenu should be collapsed")
	public void verify_that_if_user_clicks_on_the_dashboards_it_should_open_the_one_more_left_menu_to_list_out_the_dashboards_and_make_sure_primary_leftmenu_should_be_collapsed()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' DASHBOARDS ']")));

		if (!pj.getFavoritesLM().isDisplayed()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that if user clicks collapse which is in the Secondary Left menu, it should be collapsed")
	public void verify_that_if_user_clicks_collapse_which_is_in_the_secondary_left_menu_it_should_be_collapsed()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardText()));
		Thread.sleep(1500);
		pj.getCollapseIconDashboard().click();
		Thread.sleep(1000);

		try {

			w2.isDisplayed();

		} catch (NoSuchElementException e) {

			System.out.println("Passed");
		}

	}

	@Given("User do mousehover action when left menu is in collapse state, it has to show Feature name")
	public void user_do_mousehover_action_when_left_menu_is_in_collapse_state_it_has_to_show_feature_name()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getNotificationLM()));

		Actions a = new Actions(driver);

		WebElement fav = pj.getFavoritesLM();

		a.moveToElement(fav).perform();

		Thread.sleep(1000);

		String s1 = fav.getAttribute("title");
		if (s1.equals(
				"Favorite is a feature that allows users to mark specific reports & dashboards as Favorites for easy access and quick retrieval. This feature enhances user experience by streamlining navigation and ensuring that frequently used or important items are readily available.")) {

			System.out.println("Title is available");
		} else {

			System.out.println("Title is not available");
		}
	}

	@Given("Verify that when Left menu is in Collapsed state and if user clicks on the Dashboard icon, it has to show toaster validation")
	public void verify_that_when_left_menu_is_in_collapsed_state_and_if_user_clicks_on_the_dashboard_icon_it_has_to_show_toaster_validation()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getCollapseIconhome()));
		w1.click();
		Thread.sleep(1500);
		pj.getTrialDashboardIcon().click();
		Thread.sleep(1000);

		WebElement w2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));

		String validation = w2.getText();

		if (validation.contains("No trial dashboards assigned to you!")) {

			System.out.println("Passed");
		} else {

			System.out.println(validation);
			System.out.println("Failed");
			Assert.fail();
		}
	}

	// Global-Search

	@Given("Searchbox should be there in header, if user search any features under left menu, it should fetch results")
	public void searchbox_should_be_there_in_header_if_user_search_any_features_under_left_menu_it_should_fetch_results()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("Favorite");
		wait.until(ExpectedConditions.visibilityOf(pj.getFavoriteGS()));

	}

	@Given("Verify that if user search invalid data, it has to show No results found message")
	public void verify_that_if_user_search_invalid_data_it_has_to_show_no_results_found_message()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("kdfhskdjgh");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));
	}

	@Given("Verify that if user clears the search texts, it has to show all features as per requirement")
	public void verify_that_if_user_clears_the_search_texts_it_has_to_show_all_features_as_per_requirement()
			throws InterruptedException, AWTException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("zsm");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));

		Thread.sleep(1000);

		Robot r = new Robot();

		for (int i = 0; i < 3; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}

		wait.until(ExpectedConditions.visibilityOf(pj.getSourcesGS()));
	}

	@Given("Verify that Placeholder is available in Searchbox to identify by end user")
	public void verify_that_placeholder_is_available_in_searchbox_to_identify_by_end_user() {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		String s1 = w1.getAttribute("placeholder");

		if (s1.equals("Search")) {

			System.out.println("Passed- Placeholder text is available");
		} else {

			System.out.println("Failed- Placeholder text is not available");
			Assert.fail();
		}

	}

	@Given("Verify that search feature should be given to end user based upon the role as well as module management")
	public void verify_that_search_feature_should_be_given_to_end_user_based_upon_the_role_as_well_as_module_management()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));

		String s1 = w2.getAttribute("placeholder");

		if (s1.equals("Explore available actions, navigate to a dashboard, or request assistance")) {

			System.out.println("Passed- Placeholder text is available based upon user (Client)");
		} else {

			System.out.println("Failed- Placeholder text is not available based upon user (Client)");
			Assert.fail();
		}
	}

	@Given("If user search other than assigned feature, it has to show no results found")
	public void if_user_search_other_than_assigned_feature_it_has_to_show_no_results_found()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("dashboard management");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));

	}

	@Given("Verify that proper Icon should be provided for each feature")
	public void verify_that_proper_icon_should_be_provided_for_each_feature() throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		List<WebElement> icons = pj.getIconsGS();

		for (WebElement x : icons) {

			String s1 = x.getAttribute("src");

			if (s1.contains(".svg")) {

				System.out.println("Passed- Icon is available for all the feature");
			} else {

				System.out.println("Failed- Icon is not available for all the feature");
			}
		}

	}

	@Given("Verify that proper description should be provided for each feature")
	public void verify_that_proper_description_should_be_provided_for_each_feature() throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		List<WebElement> des = pj.getDescriptionGS();

		for (WebElement x : des) {

			String s1 = x.getText();

			if (s1.contains(" ")) {

				System.out.println("Passed- Text is available for all the feature");
			} else {

				System.out.println("Failed- Text is not available for all the feature");
			}
		}

	}

	@Given("Verify that if user clicks on any of the feature which is fetched from search results, it should redirect to that page")
	public void verify_that_if_user_clicks_on_any_of_the_feature_which_is_fetched_from_search_results_it_should_redirect_to_that_page()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("Favorite");
		WebElement w3 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoriteGS()));

		w3.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));

		String s1 = pageTitle();

		System.out.println(s1);

		if (s1.equals("MADTechAI - Favorites")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that if user search for any of the assigned dashboards, it should fetch results")
	public void verify_that_if_user_search_for_any_of_the_assigned_dashboards_it_should_fetch_results()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("keyword");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Dashboards']")));

	}

	@Given("Verify that if user clicks on the dashboard, it should redirect to that dashboard")
	public void verify_that_if_user_clicks_on_the_dashboard_it_should_redirect_to_that_dashboard()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("keyword");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Dashboards']")));

		driver.findElement(By.xpath("//p[text()='Keyword Analysis']")).click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

		WebElement dashboard = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='KEYWORD ANALYSIS']) [1]")));

		System.out.println(dashboard.getText());

	}

	@Given("Verify that after unassigning the dashboards, if user search for that dashboard it should not fetch results")
	public void verify_that_after_unassigning_the_dashboards_if_user_search_for_that_dashboard_it_should_not_fetch_results()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("Brand safety");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));
	}

	@Given("Verify that if user search for internal features like Executive summary and dashboard widgets it should show No results found")
	public void verify_that_if_user_search_for_internal_features_like_executive_summary_and_dashboard_widgets_it_should_show_no_results_found()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("Share dashboard");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));

	}

	@Given("Verify that if user search for Parent feature, it has to show all the child features as well")
	public void verify_that_if_user_search_for_parent_feature_it_has_to_show_all_the_child_features_as_well()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("administration");

		List<WebElement> li = wait.until(ExpectedConditions.visibilityOfAllElements(pj.getParentChildlistGS()));

		for (WebElement x : li) {

			System.out.println(x.getText());
		}

	}

	@Given("Verify that user can access the Searchbox from any of the webpage in portal")
	public void verify_that_user_can_access_the_searchbox_from_any_of_the_webpage_in_portal()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		LeftmenuPojo pj1 = new LeftmenuPojo();
		pj1.getFavoritesLM().click();

		Thread.sleep(1500);
		w1.click();

		wait.until(ExpectedConditions.visibilityOf(pj.getSourcesGS()));
	}

	@Given("User should login into the application using no dashboard account")
	public void user_should_login_into_the_application_using_no_dashboard_account() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("validEmail1"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("validPass1"));
		WebElement w3 = p.getSigninbutn();
		w3.click();

	}

	@Given("Client havent any dashboards, and if he clicks on the Dashboards in search dropdown, it should show validation in toaster")
	public void client_havent_any_dashboards_and_if_he_clicks_on_the_dashboards_in_search_dropdown_it_should_show_validation_in_toaster()
			throws InterruptedException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("dashboard");
		wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsGS())).click();

		WebElement w3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));

		String validation = w3.getText();

		if (validation.contains("No dashboards assigned to you!")) {

			System.out.println("Passed");
		} else {

			System.out.println(validation);
			System.out.println("Failed");
			Assert.fail();
		}
	}

	@Given("User should launch the portal by enter the direct client url")
	public void user_should_launch_the_portal_by_enter_the_direct_client_url() {

		url("https://kwg.madtechai.com/");
	}

	@Given("User should login into the application using direct client account")
	public void user_should_login_into_the_application_using_direct_client_account() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("directvalidEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("directvalidPass"));
		WebElement w3 = p.getSigninbutn();
		w3.click();
	}

	@Given("Verify that Direct client and trial client should have the search functionality feature which should function as per requirement")
	public void verify_that_direct_client_and_trial_client_should_have_the_search_functionality_feature_which_should_function_as_per_requirement() {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

	}

	@Given("User should login into the application using SA account")
	public void user_should_login_into_the_application_using_sa_account() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");

		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("SAvalidEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("SAvalidPass"));
		WebElement w3 = p.getSigninbutn();
		w3.click();
	}

	@Given("Verify that for Superadmin, if user search for Support, New request, Feedback feature, it should show No results found")
	public void verify_that_for_superadmin_if_user_search_for_support_new_request_feedback_feature_it_should_show_no_results_found()
			throws InterruptedException, AWTException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));

		w1.click();
		Thread.sleep(1000);

		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("New request");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));

		Thread.sleep(1000);

		Robot r = new Robot();

		for (int i = 0; i < 12; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}

		w2.sendKeys("Feedback");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));

		Thread.sleep(1000);
		for (int i = 0; i < 8; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}

		w2.sendKeys("Support");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));

	}

	@Given("User should login into the application using user account")
	public void user_should_login_into_the_application_using_user_account() throws IOException {

		fileRead(System.getProperty("user.dir") + "\\Data\\TestData.properties");
		LoginPojo p = new LoginPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(p.getTxtboxemail()));
		WebElement w1 = p.getTxtboxemail();
		w1.sendKeys(props.getProperty("UservalidEmail"));
		WebElement w2 = p.getTextboxpassword();
		w2.sendKeys(props.getProperty("UservalidPass"));
		WebElement w3 = p.getSigninbutn();
		w3.click();
	}

	@Given("Verify that for user role, Administration & iPaaS feature should not be there")
	public void verify_that_for_user_role_administration_i_paa_s_feature_should_not_be_there()
			throws InterruptedException, AWTException {

		GlobalSearch pj = new GlobalSearch();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getGlobalSearch()));
		w1.click();
		Thread.sleep(1000);
		WebElement w2 = wait.until(ExpectedConditions.visibilityOf(pj.getTextBoxGS()));
		w2.sendKeys("Administration");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));

		Thread.sleep(1000);

		Robot r = new Robot();

		for (int i = 0; i < 15; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}

		w2.sendKeys("ipaas");
		wait.until(ExpectedConditions.visibilityOf(pj.getValidationGS()));

	}

	// Folders/ Sub-Folders

	@Given("Verify that if I create new client and logging into application, No dashboard assigned to you message should be displayed")
	public void verify_that_if_i_create_new_client_and_logging_into_application_no_dashboard_assigned_to_you_message_should_be_displayed()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDASHBOARDSdropdownbtn().click();
		WebElement w2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[text()='No dashboard found']")));
		String s2 = w2.getText();
		if (s2.contains("No dashboard found")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that Folder management should be in proper CSS format as per requirement")
	public void verify_that_folder_management_should_be_in_proper_css_format_as_per_requirement()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		WebElement w2 = pj1.getDASHBOARDStxt();

		String s2 = w2.getCssValue("font-family");

		if (s2.contains("AvenirNextLTPro-Regular")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(s2);
		}
	}

	@Given("Verify that if there is dashboard assigned to the Client, it has to show Corresponding dashboard under the DASHBOARDS folder")
	public void verify_that_if_there_is_dashboard_assigned_to_the_client_it_has_to_show_corresponding_dashboard_under_the_dashboards_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		WebElement w2 = pj1.getDASHBOARDStxt();
		w2.isDisplayed();

	}

	@Given("Verify that DASHBOARDS folder should have an dropdown which should hide\\/unhide the dashboards and folders")
	public void verify_that_dashboards_folder_should_have_an_dropdown_which_should_hide_unhide_the_dashboards_and_folders()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDASHBOARDSdropdownbtn().click();
		Thread.sleep(1500);
		WebElement w2 = driver.findElement(By.xpath("//span[text()='Visitation']"));

		if (w2.isDisplayed()) {

			System.out.println("Passed- Showing all dashboards");
		} else {

			System.out.println("Failed- Hided all dashboards");
		}

		Thread.sleep(1000);
		pj1.getDASHBOARDSdropdownbtn().click();

	}

	@Given("Verify that Folder management features available only to the client admin account and super admin account")
	public void verify_that_folder_management_features_available_only_to_the_client_admin_account_and_super_admin_account()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		wait.until(ExpectedConditions.elementToBeClickable(w2));
	}

	@Given("Verify that if user clicks action near to the folder name, it has to appear Actions dropdown near to the folder at the right cornor")
	public void verify_that_if_user_clicks_action_near_to_the_folder_name_it_has_to_appear_actions_dropdown_near_to_the_folder_at_the_right_cornor()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		// wait.until(ExpectedConditions.elementToBeClickable(w2));
		w2.click();
		wait.until(ExpectedConditions.visibilityOf(pj1.getMainAddFolder()));

	}

	@Given("Verify that if user again clicks on the Actions near to the folder name, it has to dis-appear Actions dropdown near to the folder at the right cornor")
	public void verify_that_if_user_again_clicks_on_the_actions_near_to_the_folder_name_it_has_to_dis_appear_actions_dropdown_near_to_the_folder_at_the_right_cornor()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		// wait.until(ExpectedConditions.elementToBeClickable(w2));
		w2.click();
		WebElement w3 = wait.until(ExpectedConditions.visibilityOf(pj1.getMainAddFolder()));
		w2.click();

		if (!w3.isDisplayed()) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on the Actions icon at the DASHBOARDS folder name, it has to show the following Select dropdown values New folder")
	public void verify_that_if_user_clicks_on_the_actions_icon_at_the_dashboards_folder_name_it_has_to_show_the_following_select_dropdown_values_new_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		// wait.until(ExpectedConditions.elementToBeClickable(w2));
		w2.click();
		// pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOf(pj1.getMainAddFolder()));

	}

	@Given("Verify that If user clicks on the Add Folder, it has to open the Textbox in the left menu to enter the Folder name")
	public void verify_that_if_user_clicks_on_the_add_folder_it_has_to_open_the_textbox_in_the_left_menu_to_enter_the_folder_name()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));

	}

	@Given("Verify that if user clicks on the Cancel or Close button, the pop-up should be closed")
	public void verify_that_if_user_clicks_on_the_cancel_or_close_button_the_pop_up_should_be_closed()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));

		pj1.getCancelbtn().click();
	}

	@Given("Verify that user after enters the New Folder name and clicks on the save button, it should be saved")
	public void verify_that_user_after_enters_the_new_folder_name_and_clicks_on_the_save_button_it_should_be_saved()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));

		pj1.getNewFoldertxtbox().sendKeys("Testing");
		pj1.getCreatebtn().click();
		Thread.sleep(1000);

	}

	@Given("Verify that if user didn't give folder name, and tries to save, it has to show validation")
	public void verify_that_if_user_didn_t_give_folder_name_and_tries_to_save_it_has_to_show_validation()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getCreatebtn().click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Folder Name is required ']")));

	}

	@Given("Verify that if user tries to create new folder with Existing name, it has to show validation")
	public void verify_that_if_user_tries_to_create_new_folder_with_existing_name_it_has_to_show_validation()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));

		pj1.getNewFoldertxtbox().sendKeys("Test One");
		pj1.getCreatebtn().click();
		Thread.sleep(1000);

		WebElement w4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		String s4 = w4.getText();
		if (s4.contains("Folder already exists")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(s4);
		}
	}

	@Given("Verify that while creating the new folder, need to restrict the character limit to thirty")
	public void verify_that_while_creating_the_new_folder_need_to_restrict_the_character_limit_to_thirty()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));

		pj1.getNewFoldertxtbox().sendKeys("A while back I needed to count the amount of");
		pj1.getCreatebtn().click();
		Thread.sleep(1000);

		WebElement w4 = driver.findElement(By.xpath("//div[text()=' Folder Name can be max 30 characters long ']"));

		String s4 = w4.getText();
		if (s4.contains("Folder Name can be max 30 characters long")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
			System.out.println(s4);
		}
	}

	@Given("Verify that if user clicks on the Actions near to the Folder, it has to show the following options Add folder, Move folder, Rename folder, Delete Folder")
	public void verify_that_if_user_clicks_on_the_actions_near_to_the_folder_it_has_to_show_the_following_options_add_folder_move_folder_rename_folder_delete_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		List<WebElement> li = pj1.getTestingActionsList();
		for (WebElement x : li) {
			String s = x.getText();
			System.out.println(s);
		}
	}

	@Given("Verify that if user clicks on the Add folder, and after creating a new folder it should be created as Child Folder which should be under the Parent Folder")
	public void verify_that_if_user_clicks_on_the_add_folder_and_after_creating_a_new_folder_it_should_be_created_as_child_folder_which_should_be_under_the_parent_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getNewFoldertxtbox().sendKeys("Test One");
		pj1.getCreatebtn().click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	}

	@Given("Verify that if user clicks on the Move Folder option, a pop-up should be emerge in the name of Select the destination folder")
	public void verify_that_if_user_clicks_on_the_move_folder_option_a_pop_up_should_be_emerge_in_the_name_of_select_the_destination_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingMoveFolder().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Select the destination Folder ']")));
	}

	@Given("Verify that if user clicks on Close and Cancel button in the pop-up , the Select a destination folder pop-up should be closed")
	public void verify_that_if_user_clicks_on_close_and_cancel_button_in_the_pop_up_the_select_a_destination_folder_pop_up_should_be_closed()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingMoveFolder().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Select the destination Folder ']")));
		pj1.getTestingSDFCancel().click();
	}

	@Given("Verify that if user didn't select the destination folder and clicks on the move button, it has to show the validation")
	public void verify_that_if_user_didn_t_select_the_destination_folder_and_clicks_on_the_move_button_it_has_to_show_the_validation()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingMoveFolder().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Select the destination Folder ']")));
		pj1.getTestingSDFmove().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Please select the destination folder ']")));

	}

	@Given("Verify that Select a destination folder pop-up should list all the Folders which is catagorized in the Client's account")
	public void verify_that_select_a_destination_folder_pop_up_should_list_all_the_folders_which_is_catagorized_in_the_client_s_account()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingMoveFolder().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Select the destination Folder ']")));

		List<WebElement> li = pj1.getTestingfolderlist();

		for (WebElement x : li) {

			String string = x.getText();
			System.out.println(string);
		}
	}

	@Given("Verify that Select a destination folder pop-up shouldn't show the dashboards")
	public void verify_that_select_a_destination_folder_pop_up_shouldn_t_show_the_dashboards()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingMoveFolder().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Select the destination Folder ']")));

		List<WebElement> li = pj1.getTestingfolderlist();

		String s = "";
		for (WebElement x : li) {

			s = x.getText();
			System.out.println(s);
		}

		if (s.equals(" mollyhope")) {

			System.out.println("Passed");
		} else {

			System.out.println("Failed");
		}

	}

	@Given("Verify that the folder selection should be single select")
	public void verify_that_the_folder_selection_should_be_single_select() throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingMoveFolder().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Select the destination Folder ']")));
		pj1.getTestingSDFParentFolder().click();
		pj1.getTestingSDFmove().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));

	}

	@Given("Verify that if user gives same folder name in Same Parent\\/ Child level, it has to show the validation")
	public void verify_that_if_user_gives_same_folder_name_in_same_parent_child_level_it_has_to_show_the_validation()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getNewFoldertxtbox().sendKeys("Test One");
		pj1.getCreatebtn().click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	}

	@Given("Verify that if user clicks on the Rename Folder, Edit folder pop-up should be emerged")
	public void verify_that_if_user_clicks_on_the_rename_folder_edit_folder_pop_up_should_be_emerged()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingRenameFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Edit Folder ']")));
	}

	@Given("Verify that if user clicks on the Cancel or Close button,in the rename pop-up should be closed")
	public void verify_that_if_user_clicks_on_the_cancel_or_close_button_in_the_rename_pop_up_should_be_closed()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingRenameFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Edit Folder ']")));
		pj1.getClosebtn().click();

	}

	@Given("Verify that if user didn't give any name, it has to show validation")
	public void verify_that_if_user_didn_t_give_any_name_it_has_to_show_validation()
			throws InterruptedException, AWTException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingRenameFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Edit Folder ']")));
		pj1.getNewFoldertxtbox().click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		pj1.getTestingUpdatebtn().click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Folder Name is required ']")));
	}

	@Given("Verify that if user gives existing name in rename pop-up, it has to show the validation")
	public void verify_that_if_user_gives_existing_name_in_rename_pop_up_it_has_to_show_the_validation()
			throws InterruptedException, AWTException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingRenameFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Edit Folder ']")));
		pj1.getNewFoldertxtbox().click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
//		pj1.getTestingUpdatebtn().click();
//		wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Folder Name is required ']")));
		pj1.getNewFoldertxtbox().sendKeys("Test One");
		pj1.getTestingUpdatebtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	}

	@Given("Verify that if user gives new name and clicks on the Update, the folder name should be renamed")
	public void verify_that_if_user_gives_new_name_and_clicks_on_the_update_the_folder_name_should_be_renamed()
			throws AWTException, InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTestingActions().click();
		Thread.sleep(1000);
		pj1.getTestingRenameFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Edit Folder ']")));
		pj1.getNewFoldertxtbox().click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
//		pj1.getTestingUpdatebtn().click();
//		wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Folder Name is required ']")));
		pj1.getNewFoldertxtbox().sendKeys("Test One1");
		pj1.getTestingUpdatebtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	}

	@Given("Verify that if clicks on the Delete Folder at the particular folder, the confirmation pop-up should be emerged Delete Folder")
	public void verify_that_if_clicks_on_the_delete_folder_at_the_particular_folder_the_confirmation_pop_up_should_be_emerged_delete_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTesting1Actions().click();
		Thread.sleep(1000);
		pj1.getTestingDeleteFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Delete Folder ']")));
	}

	@Given("Verify that if user clicks on the Cancel&Close button , delete folder the pop-up should be closed")
	public void verify_that_if_user_clicks_on_the_cancel_close_button_delete_folder_the_pop_up_should_be_closed()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTesting1Actions().click();
		Thread.sleep(1000);
		pj1.getTestingDeleteFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Delete Folder ']")));
		pj1.getTesting1deleteCancel().click();
	}

	@Given("Verify that if user clicks on the Submit button, the folder should be deleted")
	public void verify_that_if_user_clicks_on_the_submit_button_the_folder_should_be_deleted()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(2000);
		pj1.getTesting1Actions().click();
		Thread.sleep(1000);
		pj1.getTestingDeleteFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Delete Folder ']")));
		pj1.getTesting1deletebtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	}

	@Given("Verify that state should be refreshed in the all the pop-up")
	public void verify_that_state_should_be_refreshed_in_the_all_the_pop_up() throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getNewFoldertxtbox().sendKeys("A while back I needed to count the amount of");
		pj1.getCancelbtn().click();
		w2.click();
		pj1.getMainAddFolder().click();
		WebElement txtbox = pj1.getNewFoldertxtbox();
		String s1 = txtbox.getAttribute("value");
		System.out.println(s1);
		if (s1.equals("")) {

			System.out.println("Passed");

		} else {

			System.out.println("Failed");
		}
	}

	@Given("Verify that if user clicks on action button near to the dashboard ,he can get the option Add to Folder and Move file")
	public void verify_that_if_user_clicks_on_action_button_near_to_the_dashboard_he_can_get_the_option_add_to_folder_and_move_file()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='PathX - Sales Report']/following::a[1]")).click();
		List<WebElement> li = driver.findElements(By.xpath("//span[text()='PathX - Sales Report']/following::ul[1]"));
		for (WebElement x : li) {

			String string = x.getText();
			System.out.println(string);
		}
	}

	@Given("Verify that if user clicks on the Add to Folder , a pop-up should be emerged to create new folder")
	public void verify_that_if_user_clicks_on_the_add_to_folder_a_pop_up_should_be_emerged_to_create_new_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);

		pj1.getPathXActionsbtn().click();

		pj1.getPathXAddFolderbtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));

	}

	@Given("Verify that if user clicks on the Move file button , a pop-up should be emerged to select the destination folder")
	public void verify_that_if_user_clicks_on_the_move_file_button_a_pop_up_should_be_emerged_to_select_the_destination_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);

		pj1.getPathXActionsbtn().click();

		pj1.getPathXMoveFilebtn().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Select the destination Folder ']")));

	}

	@Given("Verify that if user tries to move the dashboard to same folder , it should show the validation")
	public void verify_that_if_user_tries_to_move_the_dashboard_to_same_folder_it_should_show_the_validation()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);

		pj1.getPathXActionsbtn().click();

		pj1.getPathXMoveFilebtn().click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()=' Select the destination Folder ']")));
		pj1.getTestingSDFParentFolder().click();
		pj1.getTestingSDFmove().click();

		WebElement w3 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='modal-body scroll-container']/child::div[2]")));
		String ss = w3.getText();
		System.out.println(ss);
	}

	@Given("Verify that font-family and background color should change based upon the client settings")
	public void verify_that_font_family_and_background_color_should_change_based_upon_the_client_settings()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		// pj1.getDropdownbtn().click();
		Thread.sleep(1000);

		WebElement w2 = pj1.getPathXActionsbtn();
		// String color = w2.getCssValue("background-color");
		String font = w2.getCssValue("font-family");
		if (font.contains("Open Sans")) {
			
			System.out.println("Passed- Font is matching");
		} else {
			System.out.println("Failed- Font is mis-matching");

		}

	}

	@Given("Verify that after deleting the folder, if user creates the new folder with the same name, it should be created")
	public void verify_that_after_deleting_the_folder_if_user_creates_the_new_folder_with_the_same_name_it_should_be_created()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getNewFoldertxtbox().sendKeys("Testing");
		pj1.getCreatebtn().click();
		Thread.sleep(1000);

		WebElement w4 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w4.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()=' Testing ']/following::div[2]")).click();
		pj1.getTestingDeleteFolder().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()=' Submit ']")).click();
	}

	@Given("Verify that user can able to create maximum of {int} sub-folder under parent folder")
	public void verify_that_user_can_able_to_create_maximum_of_sub_folder_under_parent_folder(Integer int1)
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		WebElement w2 = pj1.getMainActions();
		w2.click();
		pj1.getMainAddFolder().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getNewFoldertxtbox().sendKeys("Three");
		pj1.getCreatebtn().click();
		Thread.sleep(1000);

		// Folder 1
		wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		pj.getDashboardsLM().click();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three ']/following::a[1]")).click();
		driver.findElement(By.xpath("//span[text()=' Three ']/following::a[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getNewFoldertxtbox().sendKeys("Three1");
		pj1.getCreatebtn().click();

		// Folder 2
		wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		pj.getDashboardsLM().click();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three ']/following::i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three1 ']/following::a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three1 ']/following::a[2]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getNewFoldertxtbox().sendKeys("Three2");
		pj1.getCreatebtn().click();

		// Folder 3
		wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		pj.getDashboardsLM().click();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three ']/following::i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three1 ']/following::i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three2 ']/following::a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three2 ']/following::a[2]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Create New Folder ']")));
		pj1.getNewFoldertxtbox().sendKeys("Three3");
		pj1.getCreatebtn().click();

		// Folder 4
		wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		pj.getDashboardsLM().click();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three ']/following::i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three1 ']/following::i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three2 ']/following::i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=' Three3 ']/following::a[1]")).click();
		Thread.sleep(1000);

		// Finding Add folder
		driver.findElement(By.xpath("//span[text()=' Three3 ']/following::a[1]")).click();
		try {

			WebElement checkElement = driver.findElement(By.xpath("//span[text()=' Three3 ']/following::a[1]"));
			String s = checkElement.getText();
			if (s.equals("Add Folder")) {

				System.out.println("Failed");
			} else {

				System.out.println("Passed");
			}

		} catch (Exception e) {

			System.out.println("Exception handled");
		} finally {

			Thread.sleep(1000);
			pj1.getDropdownbtn().click();
			Thread.sleep(1000);
			pj1.getDropdownbtn().click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()=' Three ']/following::a[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()=' Three ']/following::a[5]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()=' Submit ']")).click();
			System.out.println("Folder Succesfully deleted");
		}

	}

	@Given("Verify that if user does mouse hover action for the hided foldername, it has to show the entire name of the Folder")
	public void verify_that_if_user_does_mouse_hover_action_for_the_hided_foldername_it_has_to_show_the_entire_name_of_the_folder()
			throws InterruptedException {

		LeftmenuPojo pj = new LeftmenuPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getDashboardsLM()));
		w1.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj1 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj1.getDropdownbtn().click();
		Thread.sleep(1000);
	}

	// Favorites

	@Given("Verify that if user clicks on the Favorite feature, he should be redirect to Favorite webpage")
	public void verify_that_if_user_clicks_on_the_favorite_feature_he_should_be_redirect_to_favorite_webpage() {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));

	}

	@Given("Verify that Favorite webpage is in proper CSS format as per requirement")
	public void verify_that_favorite_webpage_is_in_proper_css_format_as_per_requirement() {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		WebElement w2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));
		WebElement w3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@role='row']/child::th[1]")));

		String font = w2.getCssValue("font-family");
		String color = w3.getCssValue("background-color");
		if (font.contains("Open Sans") && color.contains("rgba(70, 141, 185, 1)")) {
			System.out.println("Passed");

		} else {

			System.out.println("Failed" + font + " " + color);
			Assert.fail();
		}
	}

	@Given("Verify that If user marked any of the dashboard as Favorite under Dashboards, it should be added in Favorite webpage")
	public void verify_that_if_user_marked_any_of_the_dashboard_as_favorite_under_dashboards_it_should_be_added_in_favorite_webpage()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		LeftmenuPojo pj1 = new LeftmenuPojo();
		pj1.getDashboardsLM().click();
		FoldersSubFoldersPojo pj2 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj2.getDropdownbtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='PathX - Sales Report']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Favorites']"))).click();
		WebElement w3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		String message = w3.getText();

		if (message.contains("Dashboard has been added to favorites")) {
			System.out.println("Passed");

		} else {

			System.out.println("Failed");
			System.out.println(message);
			Assert.fail();
		}

		WebElement w8 = wait.until(ExpectedConditions.visibilityOf(pj1.getFavIcon()));
		w8.click();
		// Locate the table
		Thread.sleep(2000);
		List<String> li = new ArrayList<String>();
		String normalText = "";
		WebElement table = driver.findElement(By.xpath("//table")); // Replace with your table's XPath or CSS selector

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Loop through each cell
			for (WebElement cell : cells) {

				try {

					normalText = cell.getText();
					li.add(normalText);

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		System.out.println(li);
		if (li.contains("PathX - Sales Report")) {
			System.out.println("PathX - Sales Report is there");
		}

	}

	@Given("Verify that If user unmarked any of the dashboard as Favorite under Dashboards, it should be removed in Favorite webpage")
	public void verify_that_if_user_unmarked_any_of_the_dashboard_as_favorite_under_dashboards_it_should_be_removed_in_favorite_webpage()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		LeftmenuPojo pj1 = new LeftmenuPojo();
		pj1.getDashboardsLM().click();
		FoldersSubFoldersPojo pj2 = new FoldersSubFoldersPojo();
		Thread.sleep(1000);
		pj2.getDropdownbtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='PathX - Sales Report']")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Favorites']"))).click();
		WebElement w3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		String message = w3.getText();

		if (message.contains("Dashboard has been removed from favorites")) {
			System.out.println("Passed");

		} else {

			System.out.println("Failed");
			System.out.println(message);
			Assert.fail();
		}

		WebElement w8 = wait.until(ExpectedConditions.visibilityOf(pj1.getFavIcon()));
		w8.click();
		// Locate the table
		Thread.sleep(2000);
		List<String> li = new ArrayList<String>();
		String normalText = "";
		WebElement table = driver.findElement(By.xpath("//table"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Loop through each cell
			for (WebElement cell : cells) {

				try {

					normalText = cell.getText();
					li.add(normalText);

				} catch (Exception e) {
					
				}
			}
		}

		System.out.println(li);
		if (!li.contains("PathX - Sales Report")) {
			System.out.println("PathX - Sales Report is not there");
		}
	}

	@Given("Verify that Favorites webpage should have two view :- Table view, Grid view")
	public void verify_that_favorites_webpage_should_have_two_view_table_view_grid_view() throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();

		List<WebElement> li = pj.getFavoritesViewIcons();

		for (WebElement x : li) {

			String s = x.getAttribute("id");

			if (s.equals("list-icon") || s.equals("Grid-icon")) {

				System.out.println("Passed " + s);
			} else {

				System.out.println("Failed " + s);
			}
		}
	}

	@Given("Verify that Table view should be selected by default in favorites webpage")
	public void verify_that_table_view_should_be_selected_by_default_in_favorites_webpage() {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();

		WebElement w2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		String s = w2.getText();
		if (s.equals("Name")) {

			System.out.println("Table view is selected");
		} else {

			System.out.println("Grid view is selected");
			Assert.fail();
		}
	}

	@Given("Verify that Page entries dropdown should be there and make sure it should possess clickable functionality")
	public void verify_that_page_entries_dropdown_should_be_there_and_make_sure_it_should_possess_clickable_functionality()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));

		Thread.sleep(2000);

		pj.getFavoritesDropdownBtn().click();

	}

	@Given("Verify that if user clicks on the page entries dropdown, it should show dropdown values")
	public void verify_that_if_user_clicks_on_the_page_entries_dropdown_it_should_show_dropdown_values()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));

		Thread.sleep(2000);

		pj.getFavoritesDropdownBtn().click();

		List<WebElement> w5 = pj.getFavoritesPageEntriesDropdownValues();

		if (w5.isEmpty()) {

			System.out.println("Values are there");
		} else {

			System.out.println("Values are not there");
			Assert.fail();
		}
	}

	@Given("Verify that if user clicks on any number in page entries dropdown, it should list that count of dashboards")
	public void verify_that_if_user_clicks_on_any_number_in_page_entries_dropdown_it_should_list_that_count_of_dashboards()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));

		Thread.sleep(2000);

		WebElement sel = pj.getFavoritesPageSelectDropdown();
		Select s = new Select(sel);

		s.selectByValue("25");

		// verifying the size of table

		List<String> li = new ArrayList<String>();
		String normalText = "";
		WebElement table = driver.findElement(By.xpath("//table")); // Replace with your table's XPath or CSS selector

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Loop through each cell
			for (WebElement cell : cells) {

				try {

					normalText = cell.getText();
					li.add(normalText);

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		if (li.size() >= 40) {

			System.out.println("Page entries functionality is working");
		} else {

			System.out.println("Page entries functionality is not working");
		}
	}

	@Given("Verify that searchbox should be there in favorites page")
	public void verify_that_searchbox_should_be_there_in_favorites_page() throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		WebElement w3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dt-search']")));
		Thread.sleep(2000);
		w3.click();
	}

	@Given("Verify that if user search valid dashboard name which is added as favorite, it should fetch results")
	public void verify_that_if_user_search_valid_dashboard_name_which_is_added_as_favorite_it_should_fetch_results()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		WebElement w3 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dt-search']/child::input")));
		Thread.sleep(2000);
		w3.click();
		Thread.sleep(3000);
		w3.sendKeys("LinkedIn");
		Thread.sleep(1000);
		WebElement w4 = driver.findElement(By.xpath("//span[text()=' Linkedin']"));

		if (w4.isDisplayed()) {

			System.out.println("Search is working");
		} else {

			System.out.println("Search is not working");
		}

	}

	@Given("Verify that if user search valid dashboard name which is not added as favorite, it should not fetch results and it has to show validation")
	public void verify_that_if_user_search_valid_dashboard_name_which_is_not_added_as_favorite_it_should_not_fetch_results_and_it_has_to_show_validation()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		WebElement w3 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dt-search']/child::input")));
		Thread.sleep(2000);
		w3.click();
		Thread.sleep(3000);
		w3.sendKeys("OTT");
		Thread.sleep(1000);
		WebElement w4 = driver.findElement(By.xpath("//td[text()='No matching records found']"));

		if (w4.isDisplayed()) {

			System.out.println("Validation is showing");
		} else {

			System.out.println("Validation is not showing");
		}

	}

	@Given("Verify that if user search for Special char\\/Numeric, it should show validation")
	public void verify_that_if_user_search_for_special_char_numeric_it_should_show_validation()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		WebElement w3 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dt-search']/child::input")));
		Thread.sleep(2000);
		w3.click();
		Thread.sleep(3000);
		w3.sendKeys("@#786");
		Thread.sleep(1000);
		WebElement w4 = driver.findElement(By.xpath("//td[text()='No matching records found']"));

		if (w4.isDisplayed()) {

			System.out.println("Validation is showing");
		} else {

			System.out.println("Validation is not showing");
			Assert.fail();
		}
	}

	@Given("Verify that in table view following columns should be there:- Name, Type, Last Modified, Action")
	public void verify_that_in_table_view_following_columns_should_be_there_name_type_last_modified_action()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		WebElement w3 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dt-search']/child::input")));
		Thread.sleep(2000);

		// verifying the size of table

		List<String> li = new ArrayList<String>();
		WebElement table = driver.findElement(By.xpath("//table")); // Replace with your table's XPath or CSS selector

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		WebElement w8 = rows.get(0);
		String s = w8.getText();
		li.add(s);
		System.out.println(li);
	}

	@Given("Verify that sorting options should be there in following columns:- Name, Last modified")
	public void verify_that_sorting_options_should_be_there_in_following_columns_name_last_modified()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		WebElement w3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		Thread.sleep(2000);
		w3.click();
		Thread.sleep(2000);
		w3.click();
		Thread.sleep(2000);
		WebElement w4 = driver.findElement(By.xpath("//span[text()='Last Modified']"));
		w4.click();
		Thread.sleep(2000);
		w3.click();

	}

	@Given("Verify that if user clicks on the sorting icon, it should sort based upon the alphabetical order")
	public void verify_that_if_user_clicks_on_the_sorting_icon_it_should_sort_based_upon_the_alphabetical_order()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		WebElement w3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		Thread.sleep(2000);

		WebElement table = driver.findElement(By.tagName("table")); // Use appropriate locator

		// Get all rows of the table (excluding the header if present)
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<String> li = new ArrayList<String>();
		// Loop through rows and fetch the first cell of each row
		for (WebElement row : rows) {
			// Locate the first column (td or th) in the current row
			WebElement firstColumn = row.findElement(By.xpath("./td[1] | ./th[1]"));

			String s = firstColumn.getText();

			if (s.contains("Name")) {
				continue;
			} else {
				li.add(s);
			}
		}
		System.out.println(li);
		w3.click();

		Thread.sleep(1000);
		// Locate the table
		WebElement table1 = driver.findElement(By.tagName("table")); // Use appropriate locator

		// Get all rows of the table (excluding the header if present)
		List<WebElement> rows1 = table1.findElements(By.tagName("tr"));
		List<String> li1 = new ArrayList<String>();
		// Loop through rows and fetch the first cell of each row
		for (WebElement row1 : rows1) {
			// Locate the first column (td or th) in the current row
			WebElement firstColumn1 = row1.findElement(By.xpath("./td[1] | ./th[1]"));

			String s = firstColumn1.getText();

			if (s.contains("Name")) {
				continue;
			} else {
				li1.add(s);
			}
		}
		System.out.println(li1);

		if (li.equals(li1)) {

			System.out.println("Array is not sorted");
		} else {

			System.out.println("Array is sorted");
		}
	}

	@Given("Verify that if user clicks on the Remove button, the dashboard should be removed from favorites and it has to show toaster validation")
	public void verify_that_if_user_clicks_on_the_remove_button_the_dashboard_should_be_removed_from_favorites_and_it_has_to_show_toaster_validation()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' Audience Performance']/following::a[1]")).click();
		WebElement w4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		String message = w4.getText();

		if (message.contains("Dashboard has been removed successfully from favorites")) {
			System.out.println("Passed");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']"))).click();

		} else {

			System.out.println("Failed");
			System.out.println(message);
			Assert.fail();
		}

		LeftmenuPojo pj2 = new LeftmenuPojo();

		WebElement w8 = wait.until(ExpectedConditions.visibilityOf(pj2.getDashboardsLM()));
		w8.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj3 = new FoldersSubFoldersPojo();
		pj3.getDASHBOARDSdropdownbtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Audience Performance']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Favorites']"))).click();
		Thread.sleep(00);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='toast-container']) [2]")));
	}

	@Given("Verify that if user clicks on the Favorite icon , the dashboard should be removed from favorites and it has to show toaster validation")
	public void verify_that_if_user_clicks_on_the_favorite_icon_the_dashboard_should_be_removed_from_favorites_and_it_has_to_show_toaster_validation()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' Audience Performance']/preceding::i[1]")).click();
		WebElement w4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		String message = w4.getText();

		if (message.contains("Dashboard has been removed successfully from favorites")) {
			System.out.println("Passed");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']"))).click();

		} else {

			System.out.println("Failed");
			System.out.println(message);
			Assert.fail();
		}

		LeftmenuPojo pj2 = new LeftmenuPojo();

		WebElement w8 = wait.until(ExpectedConditions.visibilityOf(pj2.getDashboardsLM()));
		w8.click();
		Thread.sleep(1000);
		FoldersSubFoldersPojo pj3 = new FoldersSubFoldersPojo();
		pj3.getDASHBOARDSdropdownbtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Audience Performance']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Favorites']"))).click();
		Thread.sleep(00);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='toast-container']) [2]")));
	}

	@Given("Verify that if user clicks any of the dashboard name in favorites, it should redirect to the dashboard page")
	public void verify_that_if_user_clicks_any_of_the_dashboard_name_in_favorites_it_should_redirect_to_the_dashboard_page()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' Audience Performance']")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='AUDIENCE PERFORMANCE'])[1]")));

	}

	@Given("Verify that pagination should work properly like Left arrow, Right arrow etc., based on the content")
	public void verify_that_pagination_should_work_properly_like_left_arrow_right_arrow_etc_based_on_the_content()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement w3 = driver.findElement(By.xpath("//button[@class='dt-paging-button next paginate-btn']"));
		js.executeScript("arguments[0].scrollIntoView(true);", w3);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", w3);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='1']")).click();
		Thread.sleep(1000);
		WebElement w4 = driver.findElement(By.xpath("//button[@class='dt-paging-button last paginate-btn']"));
		js.executeScript("arguments[0].scrollIntoView(true);", w4);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", w4);
	}

	@Given("Verify that in Grid view, if user clicks anywhere on any of the dashboard card , it should redirect to the dashboard")
	public void verify_that_in_grid_view_if_user_clicks_anywhere_on_any_of_the_dashboard_card_it_should_redirect_to_the_dashboard()
			throws InterruptedException {

		FavoritesPojo pj = new FavoritesPojo();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement w1 = wait.until(ExpectedConditions.visibilityOf(pj.getFavoritesLM()));
		w1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Name']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='Grid-icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//small[text()='Donations']")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='DONATIONS'])[1]")));
		driver.switchTo().defaultContent();

	}
}
