package com.base;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMreport {
	
	public static  void generateJVMreport(String jsonFile) {
		
		Configuration con = new  Configuration(new File (System.getProperty("user.dir")+ "\\src\\test\\resources\\Reports"), "HCL Project");
		
		con.addClassifications("Browser", "Chrome");
		con.addClassifications("Env", "Cucumber");

		List<String> li = new ArrayList<String>();
		li.add(jsonFile);
		
		ReportBuilder build = new ReportBuilder(li, con);
		build.generateReports();
		
	}
	
	

}
