package testCases;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.TestDataProvider;

public class ValidateAndNavigateMenu extends BaseClass{


	public String xlFile = "MenuData.xls";
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		intialization(browser);
		homePage = new HomePage(driver);
	    			
	}
	
    @Test(description = "Validating and navigating menu options and more menu options")
    public void validateAndNavigateMenu() throws Exception {

        homePage=new HomePage(driver);
             
        //Top Menu existence,order and Navigation
        List<String> mainMenuList = homePage.menuOptionsList();
        verifyExistanceAndNavigationOfMenuOptions(mainMenuList,xlFile,0,"main");

                     
        // Menu options (more) existence, order, navigation 
        List<String> moreMenuList = homePage.moreSubMenuOption();
        verifyExistanceAndNavigationOfMenuOptions(moreMenuList,xlFile,1,"more");
       
              
    }
    
    /**
     * Verifying existence and navigation of menu options and mouse hover to moremenu and validating sub menus 
     * 
     * @param actualMenuList
     * @param xlFile
     * @param sheetNum
     * @param menuType
     */
    
	public void verifyExistanceAndNavigationOfMenuOptions(List<String> actualMenuList, String xlFile, int sheetNum,
			String menuType){
		           
		 for(int i=0;i<actualMenuList.size();i++) {
			 String expectedMenuOption = TestDataProvider.getData(xlFile, sheetNum, i, 0);
			 assertThat(actualMenuList.get(i),containsString(expectedMenuOption));
			 
			 homePage.clickOnOptionsBasedOnMenuType(menuType,actualMenuList.get(i));
			 Assert.assertTrue(homePage.isNavigatedToPage(expectedMenuOption.toLowerCase()),"Navigation is not as expected");
			 
			 navigateBackToApplication(driver,baseURL);
		  }
		
	}
}
