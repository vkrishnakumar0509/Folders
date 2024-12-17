package org.stepdefinition;
import org.base.BaseMethods;
import org.junit.AfterClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseMethods {

	@Before
	public void preReq() {

		launchbrowser();
		maxbrowser();

	}

	@After
	public void postReq() throws InterruptedException {
	
		Thread.sleep(3000);
		driver.close();
	}
	

}
