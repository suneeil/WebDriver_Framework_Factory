package yahoo.toolbar.webDriver.apps.Bookmarks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;




import yahoo.toolbar.webDriver.util.CommonLibrary;
import static yahoo.toolbar.webDriver.util.Config.driver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Bookmarks extends CommonLibrary
{
	
	
	/**
	 * 
	 * Bookmark constructor used by factory class to create intl specific Test classes
	 *
	**/
	public Bookmarks(String intl)
	{
		System.out.println("Constructor");
		//initialize intl 
		this.intl=intl;
		//fetch intl specific strings from excel
		data=readExcel(intl,"Bookmark",4);
		//create URL
		URL="http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1"; 
		//initialize expected header status message  
		
		System.out.println(data);
	}
	
	
	/**
	 *
	 *Variable declaration section 
	 * 
	**/
	//intl to test
	String intl;
	//map containing intl specific strings
	private Map <String,String>data;
	//URL to test
	private String URL; 
   // public String app="boo";
    //public String uname="hafeez_tb13";
    //public String pwd="testing";
	
	/**
	 * 
	 * Common methods for Bookmarks
	 * @throws InterruptedException 
	 * 
	 * 
	**/
	 public void bookmarksCommon() throws InterruptedException
	 {
		// Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("hafeez_tb8","testing",true);
		  Thread.sleep(3000);
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		 //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
	 }
	
	 private Boolean isBooPresent_QuickList(String bookmarkName)
	 {
		  Boolean BooPresent = false;
		 try{
		     
			 String xpath1= getPath("Bookmark","List","quicklist");
			  List<WebElement> elements = driver.findElementsByXPath(xpath1);
			  System.out.println("Elements Size: " + elements.size());
			 
			 for(int i=0;i<elements.size();i++)
		       {
	       	    //Verify fossil text is present
		            if(elements.get(i).getText().contains(bookmarkName))
		            {
		            	System.out.println("Found: "+ bookmarkName);
		            	BooPresent = true;
		            	break;
		            }
		            else
		            {
		            	System.out.println(bookmarkName+ " Match not found");
		            	BooPresent = false;
		            }
		            
		       }
			  
		 }
		 catch(Exception e){
			 
		 }
		return BooPresent;
	 }
	 
	 private void click_QuickList(String bookmarkName)
	 {
		
		 try{
		     
			 String xpath1= getPath("Bookmark","List","quicklist");
			  List<WebElement> elements = driver.findElementsByXPath(xpath1);
			  System.out.println("Elements Size: " + elements.size());
			if(isBooPresent_QuickList(bookmarkName)) {
				//
				for(int i=0;i<elements.size();i++)
			       {
		       	    //Verify apple text is present
			            if(elements.get(i).getText().contains(bookmarkName))
			            {
			            	elements.get(i).click();
			            	break;
			            }
			            
			            
			       }
			}
			  
		 }
		 catch(Exception e){
			 System.out.println("Exception "+ e);
		 }
		
	 }
	 
	 
	 
	 private void deleteBoo(String booName)
	 {
		  try{
			    Actions builder = new Actions(driver);  //Creating a object of Actions class
				int i=0; 
				sleep(5000);
				//Get all elements from quicklist
				 List<WebElement> elements = driver.findElements(By.xpath("//*[@class='listbookmarks']/li"));//*[@class='listbookmarks']));  //  "//ul[@id='ymail_list']/li"
			     System.out.println("Element Size:------- "+elements.size());
			        
		         for(i=0;i<elements.size();i++)
			       {
		        	    String bmlist = elements.get(i).getText();
		        	    //Verify fossil text is present
			            if(bmlist.contains(booName))
			            {
			            	    System.out.println("MatchFound");
			                   
			                    System.out.println("+++"+elements.get(i+1).getText());
			                    WebElement xpath1 = elements.get(i+1).findElement(By.xpath("//*[@class='listbookmarks']/li["+(i+1)+"]")); 
			                    System.out.println("Xpath:=== "+xpath1.getAttribute("title"));
			                    sleep(2000);
			                   
			                   //Mouse over Jabong
			                    builder.moveToElement(xpath1).build().perform();
			                  //  builder.perform();
			                    sleep(5000);
			                    
			                 
			                   WebElement xpath1Element=driver.findElementByXPath("//li["+(i+1)+"]//div[@title='Edit Bookmark']");
			                   builder.moveToElement(xpath1Element).click().build().perform();
			                  
			                    sleep(5000);
			                    //Click on delete bookmarks
			    	    	    driver.findElementByXPath(getPath("Bookmark","Delete","BMName")).click();
			    	    	    sleep(5000);
			    	    	    //Click on home icon
			    	    	    driver.findElementByXPath(getPath("Bookmark","Home","home")).click();
			    	    	    sleep(5000);
			    	    	    //Verify if the deleted bookmarks is present
			    	    	    Assert.assertFalse(elements.contains(booName), booName+" bookmark not present");
			                    break;
				    	    
			            }
			          }
			       
		  }
		         catch(Exception e)
		 		{
		 			System.out.println(e);
		 		}
			       
		  }
    
	/*	public void singleSignon(String uname, String pwd, String app) throws InterruptedException
		{
			
			//driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
			logout();
			sleep(5000);
			driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=3.0.0&modid=ytframe&bid="+app+"&debug=1");
			waitForElementPresent(By.xpath("//*[@class='boo-signin']"),5000);
			Set<String> windowids = driver.getWindowHandles();
			Iterator<String> itr = windowids.iterator();
			Assert.assertTrue(isElementPresent(By.xpath("//*[@class='boo-signin']")));
			//Click on sign in link
			driver.findElement(By.xpath(getPath("Bookmark","SignIn","signIn"))).click();
			windowids = driver.getWindowHandles();
			itr = windowids.iterator();
			String mainWindowId = itr.next();
			String newWindowId = itr.next(); 
			sleep(5000);
			System.out.println("^^^ "+newWindowId);
			driver.switchTo().window(newWindowId);
			System.out.println("-----"+driver.findElement(By.xpath("//input[@id='username']")).isDisplayed());
			Assert.assertTrue(isElementPresent(By.xpath("//input[@id='username']")), "User Name edit box not Presenet"); //getPath("Bookmark","UserName","username")
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);// getPath("Bookmark","UserName","username")
			Assert.assertTrue(isElementPresent(By.xpath("//input[@id='passwd']")), "User Name edit box not Presenet");//getPath("Bookmark","Password","passwd")
			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(Keys.ENTER);
			driver.switchTo().window(mainWindowId);
			Thread.sleep(3000);
			driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid="+(app)+"&debug=1");
			driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid="+(app)+"&debug=1");
			
		}*/
	 
	 /**
	  *  
	  *  Test methods section
	  * 
	 **/
	
	/**
	 * 
	 * Test to verify Bookmarks UI Signout
	 * 
	 * 
	**/
		@Test(groups={"Smoke","Regression"})
	public void bookmarksUISignOut() throws InterruptedException
	{ 
        logout();	
        Thread.sleep(3000);
	 	driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=3.0.1&modid=ytframe&bid=boo&debug=1&minified=1");
	 	Thread.sleep(3000);
	 	waitForElementPresent(By.className("boo-no-acct"),5000);
	 	//Verify the bookmarks welcome text, image, sign in and sign up link
	 	Assert.assertTrue(driver.findElementByXPath(getPath("Bookmark","Welcome","welcomeTitle")).getText().equals(data.get("App title")),"("+intl+")"+"Text :"+data.get("App title")+ "not present");
		Assert.assertTrue(driver.findElementByXPath(getPath("Bookmark","Welcome","welcomeText")).getText().equals(data.get("Welcome Text")),"("+intl+")"+"Text :"+data.get("Welcome Text")+ "not present");
	    Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","BMImage","bmimage"))));
	    Assert.assertTrue(driver.findElementByXPath(getPath("Bookmark","Button","signin")).getText().equals(data.get("Sign in")),"("+intl+")"+"Text :"+data.get("Sign in")+ "not present");
	    Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Button","signup"))));	   
		
	}
	
	/**
	 * 
	 * Test to verify Welcome Screen
	 *
	 * 
	**/
	
	@Test(groups={"NOTSmoke"})
	public void bookmarksWelcomeScreen() throws InterruptedException
	{
		 
		// Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("tbtest891","123456",true);
		  Thread.sleep(3000);
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		 //Wait for the Add button to appear
		  Thread.sleep(10000);
		  //Verify the Welcome title,Text,image
		 		  /*Assert.assertTrue(driver.findElementByXPath(getPath("Bookmark","Welcome","welcomeTitle")).getText().equals(data.get("App title")),"("+intl+")"+"Text :"+data.get("App title")+ "not present");
		  Assert.assertTrue(driver.findElementByXPath(getPath("Bookmark","Welcome","welcomeText")).getText().equals(data.get("Welcome Text")),"("+intl+")"+"Text :"+data.get("Welcome Text")+ "not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","BMImage","bmimage"))));
		  Assert.assertTrue(driver.findElementByXPath(getPath("Bookmark","Label","bmaddText")).getText().equals(data.get("AddText")),"("+intl+")"+"Text :"+data.get("AddText")+ "not present");
		  //Verify the add button*/
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Label","AllBM")))," ALL Bookmarks not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Label","UnsortedBM")))," Unsorted bookmarks not present");

		  }
	
	/**
	 * 
	 * Test to verify the Add Bookmarks UI
	 * 
	 * 
	**/
	
	@Test(groups={"Regression"})
	public void addBookmarksUI() throws InterruptedException
	{
		 
		 // Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("tbtest903","123456",true);
		 // Thread.sleep(5000);
		  // Open the url
		  //driver.get("http://us.data.toolbar.yahoo.com/");
		  //Thread.sleep(5000);
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
		  //Click on the Add button
		  driver.findElement(By.className("add-btn")).click();
          // Verify the bookmarks name, url and folder drop down 		 
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Label","bkurl"))),"URL label not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Label","bkname"))),"Bookmarkname label not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Label","mydropdown"))),"Folder drop down not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Label","tags"))),"Tags not prsent"); 
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Textfield","bookmarkurl"))),"Bookmark url textfield not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Textfield","bookmarkname"))),"Bookmark name text field not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Textfield","bookmarktags"))),"Bookmarks tag text field not present");
 	      Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Quicklist","QLCheck"))),"Quicklist checkbox not present");
		  Assert.assertTrue(isElementPresent(By.className("boo-add")),"Add button not present");
		  Assert.assertTrue(isElementPresent(By.className("boo-add-cancel")),"Cancel button not present");
		  Assert.assertTrue(isElementPresent(By.className("fadd")));
		
	}
	
	/**
	 * 
	 * Test verify the addition of bookmarks to quicklist
	 * 
	**/
	@Test(groups={"Regression"})
	public void addBookmarksQL() throws InterruptedException
	{
		// Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("hafeez_tb3","testing",true);
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		 //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
		  
		  //Go to bookmarks.yahoo.com/preferences page
		  driver.get("http://bookmarks.yahoo.com/index.php/preferences");
		  //Wait for recently saved radio button to appear
		  waitForElementPresent(By.id("recentlysaved-btn"),5000);
		  //Click on Quicklist view 
		  driver.findElementByXPath(getPath("Bookmark","Input","quicklist")).click();
		  //Click the save button
		  driver.findElementByXPath(getPath("Bookmark","Input","submitButton")).click();
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000); 
 
		  //Click on the Add button
		  driver.findElement(By.className("add-btn")).click();
		  //Clear the Bookmark url text field
		  driver.findElement(By.id("bmurl")).clear(); 
		  //Enter the Bookmark url
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkurl")).sendKeys("http://www.fossil.com");
		  //Clear the Bookmark name text field
		  driver.findElement(By.id("bmname")).clear();
		  //Enter the Bookmark name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkname")).sendKeys("fossil");
		  //Enter the tag name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarktags")).sendKeys("product");
		  //Check the Quicklist checkbox
		  driver.findElementByXPath(getPath("Bookmark","Quicklist","QLCheck")).click();
		  //Click on the Add button
		  driver.findElement(By.className("boo-add")).click();
		  //Wait for confirmation to add appear
		  waitForElementPresent(By.xpath(getPath("Bookmark","AddConfirmation","confirmation")),3000);
		  //Click on the close link
		  driver.findElementByXPath(getPath("Bookmark","CloseButton","close")).click();
		 // driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  sleep(5000);
		  driver.findElementByXPath(getPath("Bookmark","Folders","Unsorted")).click();
		  sleep(5000);
		  deleteBoo("fossil");
		
	}

	/**
	 * 
	 * 
	 * Test verify the addition of bookmarks to Recently saved list 
	 * 
	**/
	
	@Test(groups={"Smoke12345"})
	public void addBookmarks() throws InterruptedException
	{

		  bookmarksCommon();
		  //Go to bookmarks.yahoo.com/preferences page
		  driver.get("http://bookmarks.yahoo.com/index.php/preferences");
		  //Wait for recently saved radio button to appear
		  waitForElementPresent(By.id("recentlysaved-btn"),5000);
		  //Click on Quicklist view 
		  driver.findElementByXPath(getPath("Bookmark","Input","quicklist")).click();
		  driver.findElementByXPath(getPath("Bookmark","Input","folderview")).click();
		  //Click the save button
		  driver.findElementByXPath(getPath("Bookmark","Input","submitButton")).click();
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000); 
		  //Click on the Add button
		  
		  driver.findElement(By.className("add-btn")).click();
		  //Clear the Bookmark url text field
		  driver.findElement(By.id("bmurl")).clear(); 
		  //Enter the Bookmark url
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkurl")).sendKeys("http://www.fossil.com");
		  //Clear the Bookmark name text field
		  driver.findElement(By.id("bmname")).clear();
		  //Enter the Bookmark name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkname")).sendKeys("fossil");
		  //Enter the tag name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarktags")).sendKeys("product");
		  //Click on the Add button
		  driver.findElement(By.className("boo-add")).click();
		  //Wait for confirmation to add appear
		  waitForElementPresent(By.xpath(getPath("Bookmark","AddConfirmation","confirmation")),3000);
		  
		  
		  
		  //Click on the close link
		  driver.findElementByXPath(getPath("Bookmark","CloseButton","close")).click();
		  sleep(5000); 
		  driver.findElementByXPath(getPath("Bookmark","Folders","Unsorted")).click();
		  sleep(5000);
		  deleteBoo("fossil");
	         	
			       
		  }
		
	
	//@Test(groups={"Regression"})
	public void newFolderVerification() throws InterruptedException
	{
		        
		// Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("hafeez_tb9","testing",true);
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		 //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
		  //Check if Product folder is already present
		  List<WebElement> elements = driver.findElementsByXPath(getPath("Bookmark","FolderList","folderList"));
	      System.out.println(elements.size());
		  for (WebElement element1: elements){
			  if(element1.getText().contains("Product"))
	    	  {
				  driver.get("http://us.bookmarks.yahoo.com/");
				  sleep(5000);
				  //Click on the user created folder product
				  driver.findElementByXPath(getPath("Bookmark","Folder","UserFolder")).click();
				  sleep(5000);
				  //Click on edit link
				  driver.findElementByXPath(getPath("Bookmark","Folder","Edit")).click();
				  sleep(5000);
				  //Click on delete link
				  driver.findElementByXPath(getPath("Bookmark","Folder","FolderDelete")).click();
				  sleep(5000);
				  //Verify the delete confirmation
				  Assert.assertTrue(driver.findElementByXPath(getPath("Bookmark","Folder","delSuccess")).getText().equals(data.get("Folder Delete")),"("+intl+")"+"Text :"+data.get("Folder Delete")+ "not present");
				  sleep(20000);
				  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
				  //Wait for the Add button to appear
				  waitForElementPresent(By.className("add-btn"),5000);
				  //Click on the Add button
		     	  driver.findElement(By.className("add-btn")).click();
				  //Clear the Bookmark url text field
				  driver.findElement(By.id("bmurl")).clear(); 
				  //Enter the Bookmark url
				  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkurl")).sendKeys("http://www.amazon.com");
				  //Clear the Bookmark name text field
				  driver.findElement(By.id("bmname")).clear();
				  //Enter the Bookmark name
				  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkname")).sendKeys("amazon");
				  //Click the Add folder button
				  driver.findElementByXPath(getPath("Bookmark","AddButton","addFolder")).click();
				  //Clear the Bookmark name text field
				  driver.findElement(By.id("newfolder")).clear();
				  //Add a Folder name
				  driver.findElementByXPath(getPath("Bookmark","Input","folderName")).sendKeys("Product"); 
				  //Enter the tag name
				  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarktags")).sendKeys("product");
				  //Click on the Add button
				  driver.findElement(By.className("boo-add")).click();
				  //Wait for the Add confirmation
				  waitForElementPresent(By.xpath(getPath("Bookmark","AddConfirmation","confirmation")),1000);
				  driver.findElementByXPath(getPath("Bookmark","CloseButton","close")).click();
				  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
			      //Wait for the Add button to appear
			      waitForElementPresent(By.className("add-btn"),5000); 
			      
			      List<WebElement> elements1 = driver.findElementsByXPath(getPath("Bookmark","FolderList","folderList"));
			      System.out.println(elements1.size());
			      for (WebElement element: elements1){
					  if(element.getText().contains("Product"))
			    	  {
				         Assert.assertTrue(element.getText().contains("Product"),"Product folder not present");
			    	  }
			      }
				  
	    	  }
		  }
		  //Click on the Add button
     	  driver.findElement(By.className("add-btn")).click();
		  //Clear the Bookmark url text field
		  driver.findElement(By.id("bmurl")).clear(); 
		  //Enter the Bookmark url
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkurl")).sendKeys("http://www.amazon.com");
		  //Clear the Bookmark name text field
		  driver.findElement(By.id("bmname")).clear();
		  //Enter the Bookmark name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkname")).sendKeys("amazon");
		  //Click the Add folder button
		  driver.findElementByXPath(getPath("Bookmark","AddButton","addFolder")).click();
		  //Clear the Bookmark name text field
		  driver.findElement(By.id("newfolder")).clear();
		  //Add a Folder name
		  driver.findElementByXPath(getPath("Bookmark","Input","folderName")).sendKeys("Product"); 
		  //Enter the tag name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarktags")).sendKeys("product");
		  //Click on the Add button
		  driver.findElement(By.className("boo-add")).click();
		  //Wait for the Add confirmation
		  waitForElementPresent(By.xpath(getPath("Bookmark","AddConfirmation","confirmation")),1000);
		  driver.findElementByXPath(getPath("Bookmark","CloseButton","close")).click();
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
	      //Wait for the Add button to appear
	      waitForElementPresent(By.className("add-btn"),5000); 
	      
	      List<WebElement> elements1 = driver.findElementsByXPath(getPath("Bookmark","FolderList","folderList"));
	      System.out.println(elements1.size());
	      for (WebElement element: elements1){
			  if(element.getText().contains("Product"))
	    	  {
		         Assert.assertTrue(element.getText().contains("Product"),"Product folder not present");
	    	  }
	      }
	      } 		  
	
	
	
	
	@Test(groups={"Regression"})
	public void invalidURLCheck() throws InterruptedException
	{
		
		  bookmarksCommon();
		  //Click on the Add button
		  driver.findElement(By.className("add-btn")).click();
		  //Clear the Bookmark url text field
		  driver.findElement(By.id("bmurl")).clear(); 
		  //Enter the Bookmark url
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkurl")).sendKeys("www.fossil.com");
		  //Clear the Bookmark name text field
		  driver.findElement(By.id("bmname")).clear();
		  //Enter the Bookmark name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkname")).sendKeys("fossil");
		  //Enter the tag name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarktags")).sendKeys("product");
		  //Click on the Add button
		  driver.findElement(By.className("boo-add")).click();
		  sleep(3000);
		  //Verify the alert stating input a valid url
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Dialog","yso"))),"YSO dialog not present");
		  Assert.assertTrue(driver.findElementByXPath(getPath("Bookmark","Dialog","ysoMessage")).getText().equals(data.get("InvalidURL message")),"("+intl+")"+"Text :"+data.get("InvalidURL message")+ "not present");
		  

          
	}
	
	@Test(groups={"Smoke"})
	public void removeBookmarks() throws InterruptedException
	{
		
		  // Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("hafeez_tb8","testing",true);
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
		//Click on the Add button
		  driver.findElement(By.className("add-btn")).click();
		  //Clear the Bookmark url text field
		  driver.findElement(By.id("bmurl")).clear(); 
		  //Enter the Bookmark url
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkurl")).sendKeys("http://www.jabong.com");
		  //Clear the Bookmark name text field
		  driver.findElement(By.id("bmname")).clear();
		  //Enter the Bookmark name
		  driver.findElementByXPath(getPath("Bookmark","Textfield","bookmarkname")).sendKeys("Jabong");
		  //Click on the Add button
		  driver.findElement(By.className("boo-add")).click();
		  //Wait for the Add confirmation
		  waitForElementPresent(By.xpath(getPath("Bookmark","AddConfirmation","confirmation")),3000);
		  sleep(6000);
		  //Click on the close link
		  //driver.findElementByXPath(getPath("Bookmark","CloseButton","close")).click();
		  sleep(5000); 
		  driver.findElementByXPath(getPath("Bookmark","Folders","Unsorted")).click();
		  sleep(5000);
		  deleteBoo("Jabong");
		}
	            
		
	
				
	
	@Test(groups={"Regression"})
	public void optionsVerification()throws Exception
	{
		
		  bookmarksCommon();
		  //Click on options preferences
	      driver.findElementById(getPath("Bookmark","Options","options")).click();
		  waitForElementPresent(By.xpath(getPath("Bookmark","Options","preferences")),2);
		  driver.findElementById(getPath("Bookmark","Options","preferences")).click();
		  String prefURL=driver.getCurrentUrl();
		  Assert.assertTrue(prefURL.contains(data.get("Preferences")),"Preferences url not present");
		  sleep(5000);
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  sleep(5000);
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
		  //Click on options tools
		  driver.findElementById(getPath("Bookmark","Options","options")).click();
		  waitForElementPresent(By.xpath(getPath("Bookmark","Options","tools")),2);
		  driver.findElementById(getPath("Bookmark","Options","tools")).click();
		  sleep(5000);
		  String toolsURL=driver.getCurrentUrl(); 
		  Assert.assertTrue(toolsURL.contains(data.get("Tools")),"Tools url not present");
		  sleep(5000);
		  
	}
	
	@Test(groups={"Regression"})
	public void tagViewVerification()throws Exception
	{
		
		  bookmarksCommon();
		  //Click on options
		  driver.findElementById(getPath("Bookmark","Options","options")).click();
		  waitForElementPresent(By.xpath(getPath("Bookmark","Options","preferences")),2);
		  //Click on preferences
		  driver.findElementById(getPath("Bookmark","Options","preferences")).click();
		  //Verify user is taken to us.bookmarks.yahoo.com page
		  assert(driver.getTitle().equals("Yahoo! Bookmarks"));
		  //Click on Recently saved and tag view 
		  driver.findElementByXPath(getPath("Bookmark","Input","quicklist")).click();
		  driver.findElementByXPath(getPath("Bookmark","Input","tagview")).click();
		  //Click the save button
		  driver.findElementByXPath(getPath("Bookmark","Input","submitButton")).click();
          sleep(5000);
		  //Open bookmarks app
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","List","allBM"))),"All bookmarks not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","List","quicklist"))),"Quick list not present");
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","List","tags"))),"Tags not present");
		  
			
	}

	@Test(groups={"Regression"})
	public void headerFooterVerification()throws Exception
	{
		
		 bookmarksCommon();
		 //Click on the header link
	     driver.findElementByXPath(getPath("Bookmark","Title","header")).click();
	     sleep(5000);
	     String headerurl=driver.getCurrentUrl();
	     System.out.println(headerurl);
	     //Verification of Bookmarks title
	     Assert.assertTrue(headerurl.contains(data.get("BookmarksTitle")),"Header url not found");
	     driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
	     sleep(5000);
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
	    /* driver.findElementByXPath(getPath("Bookmark","Title","footer")).click();
	     String footerurl=driver.getCurrentUrl();
	     Assert.assertTrue(footerurl.contains(data.get("BookmarksTitle")),"Footer url not found");*/
	     
  		  
		  
	}
	
	//@Test(groups={"Smoke","Regression123"})
	public void links()throws Exception
	{
		 // Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("hafeez_tb6","testing",true);
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000); 
		
		  sleep(5000); 	
		  click_QuickList("apple");
		  sleep(10000); 	
		  String url= driver.getCurrentUrl();
		  System.out.println(url);
		  Assert.assertTrue(url.contains(data.get("AppleTitle")),"Apple title not present");
        }
	
	@Test(groups={"Regression"})
	public void noBookmarksCheck()throws Exception
	{
		  // Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("hafeez_tb14","testing",true);		  
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
		  String url=driver.findElementByXPath(getPath("Bookmark","Quicklist","quicktext")).getText().trim();
		  String url1=data.get("QuicklistEmpty").trim();
		  Assert.assertTrue(url.equals(url1));
		  
        	
	}
	
/*	@Test(groups={"Smoke","Regression"})
	 public void bookmarksSingleSignOn()throws Exception
	{
		singleSignon("hafeez_tb13","testing","boo");
	}
*/
	
	@Test(groups={"Regression"})
	public void allBookmarksCheck()throws Exception
	{
		
		  // Log out if the user is already logged in
		  logout();
		  //Login with a user who has bookmarks 
		  login("hafeez_tb3","testing",true);		  
		  driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=2.4.7&modid=ytframe&bid=boo&debug=1&minified=1");
		  //Wait for the Add button to appear
		  waitForElementPresent(By.className("add-btn"),5000);
		  //Click on all bookmarks link
		  driver.findElementByXPath(getPath("Bookmark","AllBM","all")).click();
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Home","home"))),"Home link not present");
		  driver.findElementByXPath(getPath("Bookmark","Home","home")).click();
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","AllBM","all"))),"All bookmarks not present");
		  driver.findElementByXPath(getPath("Bookmark","UnsortedBM","unsorted")).click();
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","Home","home"))),"Home link not present");
		  driver.findElementByXPath(getPath("Bookmark","Home","home")).click();
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Bookmark","UnsortedBM","unsorted"))),"Unsorted bookmarks not present");
	}
	
}
