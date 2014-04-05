package yahoo.toolbar.webDriver.apps.mail;

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
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;



public class Mail extends CommonLibrary
{
	
	
	 
	@Test(groups={"Smoke"})
	public void mailSignedInStateVerification()
	 {
		// Log out if the user is already logged in
		  logout();
		  //Login with a user who has mails
		  login("hafeez_tb8","testing",true); 
		  sleep(10000);
		  driver.get("http://toolbar-applet.trunk.development.manhattan.gq1.yahoo.com/console?m_id=td-applet-mail&disableAppClass=1&toolbar=1&site=ytb&disableAppClass=1&toolbar=1&site=ytb");
		  sleep(20000);
		  //Wait for the title to appear
		  waitForElementPresent(By.xpath(getPath("Mail","Title","yahoo")),10000);
		  //verify inbox, compose, delete, spam icons
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Inbox","inbox"))));
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Button","compose"))));
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Button","delete"))));
		 // Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Button","spam"))));
		  //verify the settings drop down
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Dropdown","selectbox"))));
		
	 }
	
	
	@Test(groups={"Smoke"})
	public void mailSignedoutStateVerification()
	{
		  // Log out if the user is already logged in
		  logout();
		  driver.get("http://toolbar-applet.trunk.development.manhattan.gq1.yahoo.com/console?m_id=td-applet-mail&disableAppClass=1&toolbar=1&site=ytb&disableAppClass=1&toolbar=1&site=ytb");
		  sleep(20000);
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Button","signin"))));
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Link","signUP"))));
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Label","signupText"))));
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Dropdown","selectbox"))));
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Button","compose"))));
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Button","delete"))));
		  Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Button","spam"))));
		  
		  
	}
	
	
	@Test(groups={"Smoke"})
	public void settingsToggleVerification() throws InterruptedException
	{
		// Log out if the user is already logged in
		  logout();
		  //Login with a user who has mails
		  login("hafeez_tb8","testing",true); 
		  driver.get("http://toolbar-applet.trunk.development.manhattan.gq1.yahoo.com/console?m_id=td-applet-mail&toolbar=1&site=ytb&instance_id=c3c335&disableAppClass=0");
		  sleep(20000);
		  //Wait for the Inbox text to appear
		  waitForElementPresent(By.xpath(getPath("Mail","Inbox","inbox")),10000);
		 
		  WebElement select = driver.findElement(By.name("tabname"));
		  List<WebElement> options = select.findElements(By.tagName("option"));
		  System.out.println(options.size());
		  for (WebElement option : options) {
		      if(option.getText().equals("Google"))
		          option.click();   
		          waitForElementPresent(By.xpath(getPath("Mail","Title","gmail")),2000);
		        	
	}

	}
	
	@Test(groups={"Smoke1235"})
	 public void SignatureinMessage() throws InterruptedException{
		  	String msg="test";
		  	//readMail(msg);
		  	composeMail(msg);
		  	
	 }
	
	
	private void readMail(String mailsub)
	{
		
		  // Log out if the user is already logged in
		  logout();
		  //Login with a user with mails in account
		  login("hafeez_tb8","testing",true); 
		  driver.get("http://toolbar-applet.trunk.development.manhattan.gq1.yahoo.com/console?m_id=td-applet-mail&disableAppClass=1&toolbar=1&site=ytb");
		  sleep(20000);
		  //Wait for the title to appear
		  waitForElementPresent(By.xpath(getPath("Mail","Inbox","inbox")),10000);
		  try{
				
			//  
		 	Actions builder = new Actions(driver);  			
		 	int i=0;			
			Thread.sleep(5000);
			String xpath= getPath("Mail","Yahootab","mails");
		    List<WebElement> elements = driver.findElementsByXPath(xpath);
			System.out.println(elements.size());
			
			
			for(i=0;i<elements.size();i++)
				{
					//System.out.print(i + ":  "+elements.get(i).getText());
					String mails = elements.get(i).getText();
					System.out.println(mails);
					if(mails.contains(mailsub))
					{
						
						System.out.println("MatchFound");
						
						String xp_start = getPath("Mail", "Yahootab", "del_mail_li_Start");  
						String xp_middle = getPath("Mail", "Yahootab", "del_mail_li_middle");
						String xp_end = getPath("Mail", "Yahootab", "del_mail_li_end");
						System.out.println("The xpath is =====" +xp_start+i+xp_middle+i+xp_end);
						WebElement xpath1 = elements.get(i).findElement(By.xpath(xp_start+i+xp_middle+i+xp_end));
					    //System.out.println("The Delete Icon: "+ xpath1);
						builder.moveToElement(xpath1).click().build().perform();  
						waitForElementPresent(By.xpath(getPath("Mail","Button","delete")),3000);
						
						//break;
						 
					}	
			}
			if(i==elements.size())
			{
				System.out.println("No Mail Found");
				Assert.assertFalse(true,"Not getting title :"+mailsub);
			}
	
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	 
		
	}
	
	private void composeMail(String mailsub)
	{
		
		  // Log out if the user is already logged in
		  logout();
		  //Login with a user with mails in account
		  login("hafeez_tb8","testing",true); 
		  driver.get("http://toolbar-applet.trunk.development.manhattan.gq1.yahoo.com/console?m_id=td-applet-mail&toolbar=1&instance_id=aa913a&site=ytb");
		  sleep(20000);
		  //Wait for the title to appear
		  waitForElementPresent(By.xpath(getPath("Mail","Inbox","inbox")),10000);
		  try{
				
			//  
		 	Actions builder = new Actions(driver);  			
		 	int i=0;			
			String xpath= getPath("Mail","Yahootab","mails");
		    List<WebElement> elements = driver.findElementsByXPath(xpath);
			System.out.println(elements.size());
			
			
			for(i=0;i<elements.size();i++)
				{
					//System.out.print(i + ":  "+elements.get(i).getText());
					String mails = elements.get(i).getText();
					System.out.println(mails);
					if(mails.contains(mailsub))
					{
						
						System.out.println("MatchFound");
						
						String xp_start = getPath("Mail", "Yahootab", "del_mail_li_Start");  
						String xp_middle = getPath("Mail", "Yahootab", "del_mail_li_middle");
						String xp_end = getPath("Mail", "Yahootab", "del_mail_li_end");
						System.out.println("The xpath is =====" +xp_start+i+xp_middle+i+xp_end);
						WebElement xpath1 = elements.get(i).findElement(By.xpath(xp_start+i+xp_middle+i+xp_end));
					    System.out.println("checkbox select is: "+ xpath1);
						builder.moveToElement(xpath1).click().build().perform();  
						waitForElementPresent(By.xpath(getPath("Mail","Button","delete")),1000);
						driver.findElement(By.xpath(getPath("Mail","Button","compose"))).click();
						sleep(5000);
						Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Input","toField"))));
						
						break;
						 
					}	
			}
			if(i==elements.size())
			{
				System.out.println("No Mail Found");
				Assert.assertFalse(true,"Not getting title :"+mailsub);
			}
	
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	 
		
	
	}
	
	
	@Test(groups={"Smoke12"})
	public void Gmail_Verification()
	{
		// Log out if the user is already logged in
		  logout();
		  //Login with a user who has mails
		  login("hafeez_tb8","testing",true); 
		  driver.get("http://toolbar-applet.trunk.development.manhattan.gq1.yahoo.com/console?m_id=td-applet-mail&toolbar=1&instance_id=aa913a&site=ytb");
		  sleep(20000);
		  //Wait for the Inbox text to appear
		  waitForElementPresent(By.xpath(getPath("Mail","Inbox","inbox")),10000);
		 
		  WebElement select = driver.findElement(By.name("tabname"));
		  List<WebElement> options = select.findElements(By.tagName("option"));
		  System.out.println(options.size());
		  for (WebElement option : options) {
		      if(option.getText().equals("Google"))
		          option.click();   
		          waitForElementPresent(By.xpath(getPath("Mail","Title","gmail")),2000);
		          driver.findElement(By.xpath(getPath("Mail","Button","googleConnect"))).click();
		          if(driver.findElement(By.xpath(getPath("Mail","Button","approve"))).isDisplayed())
		          {
		        	  driver.findElement(By.xpath(getPath("Mail","Button","approve"))).click();
		        	  driver.get("http://toolbar-applet.trunk.development.manhattan.gq1.yahoo.com/console?m_id=td-applet-mail&toolbar=1&instance_id=aa913a&site=ytb");
		        	  
		          }
		 
	}
	
	}
}
