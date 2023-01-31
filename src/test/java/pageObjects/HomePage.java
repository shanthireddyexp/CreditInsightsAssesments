package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class HomePage{

    WebDriver driver;

    By menuOptions = By.xpath(" //*[@id='header-nav-container']//div[2]/nav/ul/li/a");
    By moreMainMenu = By.xpath("//div[@data-test='moreMenu']");
    By moreSubMenu = By.xpath("//div[@data-test='moreMenu']//a");
     
        
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    /**
     * Method to get top menu list
     * 
     * @return List<String>
     */
    public List<String> menuOptionsList(){
    	List<WebElement> menuOptionsList = driver.findElements(menuOptions);
    	return getList(menuOptionsList);
    	
    }
    
    /**
     * Method to click on top menu options
     * 
     * @param menuOption
     */    
    public void clickOnMenuOption(String menuOption) {
    	driver.findElement(By.xpath("//a[contains(text(),'"+menuOption+"')] ")).click();
    }
    
     /**
     * Method to verify the page navigated or not
     * 
     * @param expectedUrl
     * @return boolean
     */
    public boolean isNavigatedToPage(String expectedUrl){
    	    return 	driver.getCurrentUrl().contains(expectedUrl) &&
    	    		isPageDisplayed();
    	    }
    
    /**
     * Method to check whether the page is displayed or not
     * 
     * @return boolean
     */
    private boolean isPageDisplayed() {
    	try {
    		return driver.findElement(By.cssSelector("footer#pageFooter")).isDisplayed();
    	}catch(Exception e) {
    		return driver.findElement(By.cssSelector("footer#footer-nav-container")).isDisplayed();
    		}
    }
    
      /**
        * Method to mouse hover on more menu and get more menu options
        * 
        * @return moreMenuList
        * 
        */  
       public List<String> moreSubMenuOption() {
    	   moreOptionMouseHover();
    	   List<WebElement> subOptions= driver.findElements(moreSubMenu);
    	   return getList(subOptions);
    	
       }
       
       /**
        * Method to click on more menu options
        * 
        * @param menuOption
        */    
       public void clickOnMoreMenuOption(String menuOption) {
    	   moreOptionMouseHover();
       	driver.findElement(By.xpath("//div[@data-test='moreMenu']//a[contains(text(),'"+menuOption+"')] ")).click();
       }
       
       
       /**
        * Method to click on options based on menu type
        * 
        * @param menuType
        * @param menuOption
        */ 
       public void clickOnOptionsBasedOnMenuType(String menuType, String menuOption) {
    	   
    	   switch(menuType)
    	   {
    	   case "main": 
    		   clickOnMenuOption(menuOption);
    		   break;
    	   case "more":
    		   clickOnMoreMenuOption(menuOption);
    		   break;
    	   }
       }
              
       /**
        * Method to navigate to the world page 
        *  
        * @param menuOption
        * @return WorldPage
        */
       public WorldPage navigateToWorld(String menuOption) {
          clickOnMenuOption(menuOption);
          return new WorldPage(driver);
       }
       
       /**
        * Method to mouse hover on more menu
        * 
        */  
          private void moreOptionMouseHover() {
       	   Actions actions = new Actions(driver);
       	   actions.moveToElement(driver.findElement(moreMainMenu)).build().perform();
       }
       
       /**
        * Method to get list
        * 
        * @param List<WebElement>
        * @return List<String>
        */
       private List<String> getList(List<WebElement> menuOptionsList){
       	List<String> list = new ArrayList<>();
       	for(int i=0;i<menuOptionsList.size();i++ ) {
       		list.add(menuOptionsList.get(i).getText());
       		
       	}
       	
       	return list;
       	
       }
     
}