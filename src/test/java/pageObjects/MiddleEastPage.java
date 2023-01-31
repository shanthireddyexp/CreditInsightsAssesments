package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MiddleEastPage {
	
	WebDriver driver;
	
	By middleEastArticles = By.cssSelector("a[href*='middleeast']");

	public MiddleEastPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isVisible() {
		return driver.getCurrentUrl().contains("middle-east") &&
				driver.findElement(By.cssSelector("h1#maincontent")).getText().contains("Middle East");
	}

	public List<String> getMiddleEastPageArticles(){
		List<WebElement> contentList = driver.findElements(middleEastArticles);
		List<String> middleEastArticles = new ArrayList<>();
		for(WebElement contentData:contentList) {
			middleEastArticles.add(contentData.getAttribute("innerText"));
		}
		return middleEastArticles;
		
	}

}
