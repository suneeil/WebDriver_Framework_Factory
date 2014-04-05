package yahoo.toolbar.webDriver.apps.UISettings;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

//import junit.framework.Assert;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import yahoo.toolbar.webDriver.util.*;
import static yahoo.toolbar.webDriver.util.Config.driver;
import yahoo.toolbar.webDriver.util.CommonLibrary;

public class settingsUI extends CommonLibrary {
	
	private static final String String = null;

	/**
	 * 
	 * Facebook constructor used by factory class to create intl specific Test classes
	 *
	**/
	

	public settingsUI(String intl)
	{
		//initialize intl 
		this.intl=intl;
		//fetch intl specific strings from excel
		data=readExcel(intl,"Settings",5);
		System.out.println(data);
		//create URL
	    URL = "http://fe1.staging.toolbar.bf1.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=3.0.0&modid=ytframe&bid=pres&debug=1"; 
		PlusUrl = "http://fe1.dev-qa.toolbar.bf1.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=3.0.0&modid=ytmenu&bid=add_grp_fav&debug=1&ysoid=@yt_plusbtn";
		//initialize expected header status message  
		//headerStatus[0]=data.get("Login page");
	}
	
	/**
	 *  configuration method to run before every test
	 * 
	**/
	//@BeforeMethod
	//public void logIn()
	//{
	//	System.out.println("111111111");
	//	faceBookLogin(userName,password);
	//}
	
	
	/**
	 *
	 *Variable declaration section 
	 * 
	**/
	
	//intl to test
	String intl;
	//map containing intl specific strings
	private Map <String,String>data;
	//array containing all the header status messages
	private String[] headerStatus=new String[6];
	//URL to test
	private String URL;
	private String PlusUrl;
			//URL to test
			
	/**
	 * Executes a script on an element
	 * 
	 * @note Really should only be used when the web driver is sucking at
	 *       exposing functionality native
	 * @param script
	 *            The script to execute
	 * @param element
	 *            The target of the script, referenced as arguments[0]
	 */
	public void trigger(String script, WebElement element) 
	{
		((JavascriptExecutor) driver).executeScript(script, element);
	}

	/**
	 * Executes a script
	 * 
	 * @note Really should only be used when the web driver is sucking at
	 *       exposing functionality natively
	 * @param script
	 *            The script to execute
	 */
	public Object trigger(String script)
	{
		return ((JavascriptExecutor) driver).executeScript(script);
	}

	public void openTab(String url)
	{
		String script = "var d=document,a=d.createElement('a');a.target='_blank';a.href='%s';a.innerHTML='.';d.body.appendChild(a);return a";
		Object element = trigger(String.format(script, url));
		if (element instanceof WebElement)
		{
			WebElement anchor = (WebElement) element;
			anchor.click();
			trigger("var a=arguments[0];a.parentNode.removeChild(a);", anchor);
		} else
		{
			throw new JavaScriptException(element, "Unable to open tab", 1);
		}
	}

	public void switchWindow() throws NoSuchWindowException{
	       
	           Set handles = driver.getWindowHandles();
	           String current = driver.getWindowHandle();
	           handles.remove(current);
	           String newTab = (String) handles.iterator().next();
	           driver.switchTo().window(newTab);
	   	}
	
	public void switchTab()
	{
		 //Perform the click operation that opens new window before
	       String winHandleBefore = driver.getWindowHandle();
//	     //Perform the click operation that opens new window
//	     //Switch to new window opened
	     for(String winHandle : driver.getWindowHandles())
	     {
	         driver.switchTo().window(winHandle);
	         System.out.println("Url ===" + driver.getCurrentUrl());
	     }
	       sleep(5000);
	       
	}

	@AfterTest(groups = "Smoke")
	public void Signinlink()
	{
       driver.get(URL);
	   sleep(5000);
	   driver.findElementByXPath(getPath("Settings", "signInLink", "signIn")).click();
	   sleep(5000);
	   Assert.assertTrue(isElementPresent(By.xpath(getPath("Settings","signInVerification","YahoosignIn"))),"Login page for Yahoo");
	   	
	}
	
	@Test(groups = "Smoke")
	public void Edittoolbar()
	{
       driver.get(URL);
       sleep(3000);
       driver.findElementByXPath(getPath("Settings", "editToolbarVerification", "editToolbar")).click();
       sleep(7000);
       String winHandleBefore = driver.getWindowHandle();
//     //Perform the click operation that opens new window
//     //Switch to new window opened
     for(String winHandle : driver.getWindowHandles())
     {
         driver.switchTo().window(winHandle);
         driver.findElement(By.xpath(getPath("Settings","galset","buttonGallery"))).click();
         
     }
//     // Perform the actions on new window
//     //Close the new window, if that window no more required
    //driver.close();
//     //Switch back to original browser (first window)
   driver.switchTo().window(winHandleBefore);
  // driver.close();
    // sleep(50000);
       sleep(5000);
        
      // Assert.assertTrue(isElementPresent(By.xpath(getPath("Settings","setting","edit"))),"Check button gallery is presentand confirm that test passed");
     
     //  sleep(5000);
     
      // Assert.assertTrue(isElementPresent(By.xpath(getPath("Settings","galleryTab","gallery"))),"Nav Assist check box is present and clickable");
      // driver.findElement(By.xpath(getPath("Settings","generalTab","generaledit"))).click();
     
	  //	driver.close();   
	   
	 }
	
	@Test(groups = "Smoke")
	public void EditSettingslink()
	{
       driver.get(URL);
	   sleep(5000);
	   driver.findElementByXPath(getPath("Settings", "editSettings", "settings")).click();
	   sleep(5000);
	   switchTab();
	   String url = driver.getCurrentUrl();
	   System.out.println("The Search URL is " + url);
	       Assert.assertTrue(url.contains("dv=general"));
	 }
	
	@Test(groups = "Regression")
	public void AboutToolbar()
	{
       driver.get(URL);
	   sleep(5000);
	   driver.findElementByXPath(getPath("Settings", "aboutToolbar", "about")).click();
	   sleep(10000);
	   try {
		    Robot robot = new Robot();
             // Simulate a key press
		    robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_TAB);
		    robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_TAB);
		    robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_TAB);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
		    e.printStackTrace();
		}
	   Assert.assertTrue(true);
	 }
	
	
	@Test(groups = "Regression")
	public void feedbacklink()
	{
       driver.get(URL);
	   sleep(5000);
	   driver.findElementByXPath(getPath("Settings", "sendFeedback", "feedback")).click();
	   sleep(5000);
	   switchTab();
	   sleep(3000);
	   Assert.assertTrue(isElementPresent(By.xpath(getPath("Settings","feedBackPage","yahoofeedback"))),"Yahoo feedback page is opened");
	 }
	
		
@Test(groups = "Regression")
public void policyLink()
{
   driver.get(URL);
   sleep(5000);
   driver.findElementByXPath(getPath("Settings", "privacyPolicy", "policy")).click();
   sleep(5000);
   switchTab();
   sleep(3000);
   String url1 = driver.getCurrentUrl();
	   Assert.assertTrue(url1.contains("info.yahoo.com"));
 }
	


@Test(groups = "Regression")
public void helpLink()
{
   driver.get(URL);
   sleep(5000);
   driver.findElementByXPath(getPath("Settings", "helpLink", "helpsettings")).click();
   sleep(5000);
   switchTab();
   sleep(3000);
   String url1 = driver.getCurrentUrl();
	   Assert.assertTrue(url1.contains("help.yahoo.com"));
 }


@Test(groups = "Smoke")
public void plusgallery()
{
   driver.get(PlusUrl);
   sleep(5000);
   driver.findElementByXPath(getPath("Settings", "plusaddpage", "plusgallery")).click();
   sleep(5000);
   String url1 = driver.getCurrentUrl();
	   Assert.assertTrue(url1.contains("us.config.toolbar.yahoo.com/ytoolbar/configserver/glxy/landing"));
 }







@Test(groups = "regression887")
public void addButton()
{
	driver.get(PlusUrl);
	sleep(5000);
	driver.findElementByXPath(getPath("Settings", "plusaddbutton", "addbutton")).click();
	sleep(5000);
	driver.get("http://in.yahoo.com");
	sleep(10000);
	JavascriptExecutor js = null;
	if (driver instanceof JavascriptExecutor) {
	    js = (JavascriptExecutor)driver;
	}
	//js.executeScript("function showAlert() { alert('success'); }; showAlert()");
	//js.executeScript("alert ('here');");
	//js.executeScript("alert ('Hi');" + "alert ('by');");
	//js.executeScript("alert(window.Customizer);");
	
	String buttons =  (String) js.executeScript("var layoutEngine = window.Customizer.LayoutEngine;" +  "document.title = layoutEngine.GetLayout('');" + "return document.title;");
	System.out.println("Button on layout" + buttons);
	//js.executeScript("alert ('hello')");
	Assert.assertTrue(buttons.contains("@lb_fe1_dev-qa_toolbar_bf1"));
	
	
	
	
 }



}		

