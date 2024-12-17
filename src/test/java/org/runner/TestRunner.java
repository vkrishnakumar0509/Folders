package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefinition.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "org.stepdefinition", plugin={
		"html:AllReports/HTMLReport/html-report.html",
		"junit:AllReports/junit/junit-report.xml",
		"json:AllReports/json/json-report.json"
		},dryRun=false, tags="@smoke")

public class TestRunner {

	@AfterClass
	public static void cucumberReport() {
		
		JVMReport.generateReport(System.getProperty("user.dir")+"\\AllReports\\json\\json-report.json");

	}
}
