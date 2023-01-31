package testCases;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.EuropePage;
import pageObjects.HomePage;
import pageObjects.MiddleEastPage;
import pageObjects.WorldPage;

public class ValidateWorldPage extends BaseClass {

	String worldUrl = "https://edition.cnn.com/world";

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		intialization(browser);
		homePage = new HomePage(driver);
		worldPage = new WorldPage(driver);
		middleEastPage = new MiddleEastPage(driver);
		europePage = new EuropePage(driver);

	}

	@Test(description = "Validating and navigating Middle East page articles")
	public void validateAndNavigateMiddleEastPage() throws Exception {

		worldPage = homePage.navigateToWorld("World");
		Assert.assertTrue(worldPage.isSectionDisplayed("Middle East"), "Section is not dispalyed");
		
		List<String> middleEastSectionContent = worldPage.getSectionContentLinks("30/middleeast");
		
		middleEastPage = worldPage.navigateToMiddleEast("Middle East");
		Assert.assertTrue(middleEastPage.isVisible());
	
	  validatingContentAndNavigation(middleEastSectionContent,middleEastPage.getMiddleEastPageArticles(),"30/middleeast");

	}
	
	@Test(description = "Validating and navigating Europe page articles")
	public void validateAndNavigateEuropePage() throws Exception {

		worldPage = homePage.navigateToWorld("World");
		Assert.assertTrue(worldPage.isSectionDisplayed("Europe"), "Section is not dispalyed");
		
		List<String> europeSectionContent = worldPage.getSectionContentLinks("30/europe");
		 
		europePage = worldPage.navigateToEurope("Europe");
		Assert.assertTrue(europePage.isVisible());
		
	   validatingContentAndNavigation(europeSectionContent,europePage.getEuropePageArticles(),"30/europe");

	}
	

	private void validatingContentAndNavigation(List<String> expectedArticle,List<String> actualArticle, String sectionLink) throws Exception {
		           
		
		 for(int i=0;i<actualArticle.size();i++) {
				 assertThat(actualArticle.get(i), Matchers.containsString(expectedArticle.get(i)));
				String sectionText = worldPage.getSectionLinkTextAndClick(sectionLink);
				 navigateBackToApplication(driver,worldUrl);
				 Assert.assertTrue(worldPage.isArticlesNavigated(sectionText));
				  
	        }
		
	}

}
