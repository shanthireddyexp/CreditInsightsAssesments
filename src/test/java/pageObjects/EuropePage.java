package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EuropePage {
	
WebDriver driver;
	
	By europeArticles = By.cssSelector("a[href*='30/europe']");

	public EuropePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Method to check whether page loaded or not
	 * 
	 * @return boolean
	 */	
	public boolean isVisible() {
		return driver.getCurrentUrl().contains("europe") &&
				driver.findElement(By.cssSelector("h1#maincontent")).getText().contains("Europe");
	}

	/**
	 * Method to get Europe page articles
	 * 
	 * @return
	 */
	public List<String> getEuropePageArticles(){
		List<WebElement> contentList = driver.findElements(europeArticles);
		List<String> europeArticles = new ArrayList<>();
		for(WebElement contentData:contentList) {
			europeArticles.add(contentData.getAttribute("href"));
		}
		return europeArticles;
		
	}


}
