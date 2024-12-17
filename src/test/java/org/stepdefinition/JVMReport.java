package org.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {

	public static void generateReport(String jsonfile){
		
		File f= new File(System.getProperty("user.dir")+"\\AllReports\\JVMReport");
		
		Configuration con=new Configuration(f, "MTAI");
		
		con.addClassifications("Environment", "DEV");
		
		List<String> li=new ArrayList<String>();
		li.add(jsonfile);
		
		ReportBuilder builder =new ReportBuilder(li, con);
		
		builder.generateReports();
	}
}
