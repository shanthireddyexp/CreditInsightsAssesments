package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorldPage {

	WebDriver driver;

	public WorldPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to check whether the section is displayed or not
	 * 
	 * @param expectedSection
	 * @return
	 */

	public boolean isSectionDisplayed(String expectedSection) {
		return driver.findElement(By.xpath("//h2[contains(text(),'" + expectedSection + "')]")).isDisplayed();
	}

	/**
	 * Method to click on sub menu section
	 * 
	 * @param sectionOption
	 */
	public void clickOnSection(String sectionOption) {
		driver.findElement(By.xpath("//div[@class='header__nav-item']/a[contains(text(),'" + sectionOption + "')]"))
				.click();
	}

	/**
	 * Method to get WebElement from expected section
	 * 
	 * @param expectedSection
	 * @return
	 */
	private List<WebElement> getSectionWebElement(String expectedSection) {
		return driver.findElements(By.cssSelector("a[href*='" + expectedSection + "']"));
	}

	/**
	 * Method to get section links from expected section
	 * 
	 * @param expectedSectionTitle
	 * @return
	 */
	public List<String> getSectionContentLinks(String expectedSection) {
		List<WebElement> MEContent = getSectionWebElement(expectedSection);
		List<String> content = new ArrayList<>();
		for (WebElement contentData : MEContent) {
			content.add(contentData.getAttribute("href"));
		}
		return content;
	}
	
	/**
	 * Method to navigate to Middle East section
	 * 
	 * @param menuOption
	 * @return
	 */
	public MiddleEastPage navigateToMiddleEast(String menuOption) {
		clickOnSection(menuOption);
		return new MiddleEastPage(driver);

	}

	/**
	 * Method to navigate to Europe section
	 * 
	 * @param menuOption
	 * @return
	 */
	public EuropePage navigateToEurope(String menuOption) {
		clickOnSection(menuOption);
		return new EuropePage(driver);

	}

	/**
	 * Method to scroll into element
	 * 
	 * 
	 */
	public void scrollToElement(WebElement elementIntoView) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", elementIntoView);

	}

	/**
	 * Method to get section link text and click
	 * 
	 * @param sectionOption
	 */
	public String getSectionLinkTextAndClick(String sectionLink) {
		List<WebElement> secLink = getSectionWebElement(sectionLink);
		String sectionText = null;
		for (WebElement section : secLink) {
			if (section.getAttribute("href").contains(sectionLink)) {
				scrollToElement(section);
				sectionText=section.getText();
				clickOnLinks(sectionText);
			}
		}
		return sectionText;

	}
	
	/**
	 * Method to click on section links
	 * 
	 * @param sectionOption
	 * @throws InterruptedException 
	 */
	private void clickOnLinks(String sectionLinkText) {
		driver.findElement(By.partialLinkText(sectionLinkText)).click();
	}

	/**
	 * Method to check whether article is navigated or not
	 * 
	 * @return boolean
	 */
	public boolean isArticlesNavigated(String expecetedHeaderContent) {
		return driver.findElement(By.cssSelector("h1#maincontent")).getText().contains(expecetedHeaderContent);
	}

}
