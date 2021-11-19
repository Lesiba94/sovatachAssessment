package testRunner;
import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testFuctionality.launchSovetachURL;

public class test_runner {
	public WebDriver driver;
	public String excel = "C:\\SovetechDemo\\sovetachDemoAsssessment\\TestData\\testData.xlsx";
	
	@Before()
	public void setup() throws Exception {
	if (driver == null)
	{
	System.setProperty("webdriver.chrome.driver", "C:\\SovetechDemo\\sovetachDemoAsssessment\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize(); System.out.println("**Chrome driver initiated**");
	} else {
	System.out.println("**Chrome driver already initiated**");
	}

	} public WebDriver getdriver()
	{
	if (driver == null)
	{
	return driver;
	} else {
	return driver;
	}
	
	} @Test()
	public void Launch_AutomationScript_URL(){
	launchSovetachURL page1 = PageFactory.initElements(driver,launchSovetachURL.class);
	page1.LaunchSovetachpage(driver);
	
	WebDriverWait Wait = new WebDriverWait(driver,10);
	driver.switchTo().frame(0);
	Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='your_name']")));
	WebElement name = driver.findElement(By.xpath("//input[@name='your_name']"));
	name.sendKeys("testing");
	
	WebElement workEmail = driver.findElement(By.xpath("//input[@type='email']"));
	workEmail.sendKeys("test@gail.com");

	WebElement mobileNo = driver.findElement(By.xpath("//input[@name='mobilephone']"));
	mobileNo.sendKeys("0794567365");

	WebElement companySize = driver.findElement(By.xpath("//select[@name='numemployees']"));
	companySize.click();
	Select Sel = new Select(companySize);
	Sel.selectByIndex(1);

	WebElement businessType = driver.findElement(By.xpath("(//select[@name])[2]"));
	businessType.click();
	Select BussinessT = new Select(businessType);
	BussinessT.selectByIndex(1);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("scroll(0, 800);");
	
	Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='message-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']")));
	WebElement mess = driver.findElement(By.xpath("//textarea[@id='message-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']"));
	mess.click();
	mess.sendKeys("I am writing test automation for Sovetech");

	WebElement check = driver.findElement(By.xpath("//input[@type='checkbox']"));
	check.click();
	
	WebElement submimit = driver.findElement(By.xpath("//input[@type='submit']"));
	submimit.click();
	
	if(Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Submission Successful']"))) !=null){
		
		String actualTitle = driver.findElement(By.xpath("//*[.='Submission Successful']")).getText();
		String expectedTitle = "Submission Successful";
		assertEquals(expectedTitle,actualTitle);
		
		System.out.println("Submission Successful text is present: ");
	}
	else{
		System.out.println("Submission Successful is not present: ");
	}
	
	driver.quit();
	}
	
}
