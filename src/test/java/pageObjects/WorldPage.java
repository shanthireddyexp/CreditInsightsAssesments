package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorldPage {
	
  WebDriver driver;
  
  By aroundWorldSec = By.xpath("//section/div/div[2]/div/div[2]/div/div");
  By middleEastSec = By.xpath("//section/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]");
  By middleEastContent = By.xpath("//section/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]//a");
  By pageHeader = By.xpath("//*[@id='pageHeader']/div/div/div[1]");

	public WorldPage(WebDriver driver) {
		this.driver=driver;
	}
	

	public boolean isMiddleEastSectionDisplayed() {
		return driver.findElement(aroundWorldSec).isDisplayed() &&
				driver.findElement(middleEastSec).isDisplayed();
	}
	
	public void clickOnSectionOption(String sectionOption) {
		driver.findElement(By.xpath("//div[@class='header__nav-item']/a[contains(text(),'"+sectionOption+"')]"));
	}
	
	
	public List<String> getMiddleEastSectionContent(String expectedSectionTitle){
		List<WebElement> MEContent = driver.findElements(By.cssSelector("a[href*='"+expectedSectionTitle+"']"));
		List<String> content = new ArrayList<>();
		for(int i=0;i<MEContent.size();i++) {
			content.add(MEContent.get(i).getAttribute("innerText"));
			
		}
		return content;
	}
	
	public MiddleEastPage navigateToMiddleEast(String menuOption) {
		clickOnSectionOption(menuOption);
		return new MiddleEastPage(driver);
		
	}
	
	public void scrolIntoSection(String expectedArticleSection){
		WebElement articleSection = driver.findElement(By.xpath("//h2[contains(text(),'"+expectedArticleSection+"')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", articleSection);
	}
	
	 public boolean isNavigated(String article){
 	    return driver.findElement(By.xpath("//h1[contains(text(),'"+article+"')]")).isDisplayed();
 	
 	}
	
	

}
