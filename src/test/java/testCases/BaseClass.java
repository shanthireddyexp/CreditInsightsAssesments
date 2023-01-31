package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;


import pageObjects.HomePage;
import pageObjects.MiddleEastPage;
import pageObjects.WorldPage;
import utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	 public HomePage homePage;
	 public WorldPage worldPage;
	 public MiddleEastPage middleEastPage;
		
	public WebDriver driver;
	


	public void intialization(String br) {
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		
		driver.get(readconfig.getApplicationURL());
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

	/**
	 * Navigating back to base Url 
	 * 
	 * @param driver
	 * @param baseUrl
	 */
	public void navigateBackToApplication(WebDriver driver, String baseUrl) {
		this.driver.navigate().to(baseUrl);  
	}
	
		
}
