package com.step;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
WebDriver driver;

@Given("Launch Browser")
public void launch_Browser() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(); 
}

@Given("load the url")
public void load_the_url() {
	
	driver.get("https://www.ikea.com/in/en/");
   
}

@When("navigate through Pages")
public void navigate_through_Pages() throws InterruptedException {
	
	WebElement bed = driver.findElement(By.xpath("(//a[text() = \"Beds\"])[3]"));
	bed.click();
	String pwid = driver.getWindowHandle();
	Set<String> allid = driver.getWindowHandles();
   System.out.println(allid);
   
   Thread.sleep(3000); 
   List<String> li = new ArrayList<String>();
   li.addAll(allid);
   
   driver.switchTo().window(li.get(2));
  
   driver.findElement(By.xpath("//img[@alt=\"IKEA HAUGA Upholstered bed frame\"]")).click();
   Thread.sleep(3000);
   driver.findElement(By.xpath("//input[@id=\"input_pincode_del\"]")).sendKeys("500033");
   driver.findElement(By.xpath("//button[text()=\"Check\"]")).click();
   driver.findElement(By.xpath("//button[@name=\"Add to shopping cart\"]")).click();
   

}

@Then("add to cart page")
public void add_to_cart_page() throws InterruptedException {
	Thread.sleep(6000);
	driver.findElement(By.xpath("//a[text()=\"View your shopping cart\"]")).click();
	Thread.sleep(3000);
	WebElement sel = driver.findElement(By.xpath("//select[@title=\"Pick a store\"]"));
    Select se = new Select(sel);
    se.selectByIndex(1);
    driver.findElement(By.xpath("//input[@name=\"clickdeliver_postcode\"]")).sendKeys("500033");
    driver.findElement(By.xpath("//span[text()=\"Proceed\"]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[text()=\"No, I don't have one\"]")).click();
}

@Then("Delivery address")
public void delivery_address() throws InterruptedException {
	
	driver.findElement(By.xpath("//a[text()=\"Place order\"]")).click();
	Thread.sleep(3000);
    
}




	


}
