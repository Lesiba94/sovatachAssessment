package testFuctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testRunner.test_runner;

public class launchSovetachURL extends test_runner{
	//public WebDriver driver;
	public String sovtechURL = "https://www.sovtech.co.za/contact-us/";

	public void LaunchSovetachpage(WebDriver driver){
	this.driver=driver;
	driver.get(sovtechURL);
	PageFactory.initElements(driver, this);
	}

}
