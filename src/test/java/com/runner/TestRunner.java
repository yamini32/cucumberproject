package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.JVMreport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\FeaturesFolder\\ikea.feature"}, glue= {"com.step"},
dryRun = false, plugin = {"json:src\\test\\resources\\Reports\\cucumber.json"})


public class TestRunner {
	
	
	@AfterClass
	public static void aftertestRunner() {
		
       JVMreport.generateJVMreport(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\cucumber.json");
	}

}
