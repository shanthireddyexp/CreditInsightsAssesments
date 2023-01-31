package testCases;

import static org.hamcrest.MatcherAssert.assertThat;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MiddleEastPage;
import pageObjects.WorldPage;


public class ValidateWorldPage extends BaseClass {
	
	String worldUrl = "https://edition.cnn.com/world";
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		intialization(browser);
		homePage = new HomePage(driver);
		worldPage = new WorldPage(driver);
		middleEastPage = new MiddleEastPage(driver);
	    			
	}
	
	@Test(description = "Validating navigating World Page")
	 public void validateAndNavigateWorld() throws Exception {
		
		  worldPage =  homePage.navigateToWorld("World");
		  Assert.assertTrue(worldPage.isMiddleEastSectionDisplayed(),"Box and section are not as expected");
		 // List<String> middleEastSectionContent = worldPage.getMiddleEastSectionContent("middleeast");
		   Thread.sleep(5000);
		   
		 // System.out.println("1 "+worldPage.getMiddleEastSectionContent("middleeast"));
		   
		   middleEastPage = worldPage.navigateToMiddleEast("Middle East");
		   Assert.assertTrue(middleEastPage.isVisible());
		   Thread.sleep(5000);
		   //System.out.println("2 "+middleEastPage.getMiddleEastPageArticles());
		  // assertThat(middleEastSectionContent, hasItems(new MiddleEastPage(driver).getMiddleEastPageArticles()));
		   
		  // verifyNavigationOfMeArticles(middleEastSectionContent);
		  	 
	}
	
//	private void verifyNavigationOfMeArticles(List<String> actualArticle) throws Exception {
//		           
//		 for(int i=0;i<actualArticle.size();i++) {
//			//assertThat(new MiddleEastPage(driver).getMiddleEastPageArticles(), containsString(actualArticle.get(i)));
//			 worldPage.navigateToArticle(actualArticle.get(i));
//			Assert.assertTrue( worldPage.isNavigated(actualArticle.get(i)),"Navigation is not as expected");
//	        navigateBackToApplication(driver,worldUrl);
//	        }
//		
//	}
	

}
