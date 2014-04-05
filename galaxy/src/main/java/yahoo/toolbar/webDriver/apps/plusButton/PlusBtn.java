package yahoo.toolbar.webDriver.apps.plusButton;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.Set;


//import junit.framework.Assert;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import static yahoo.toolbar.webDriver.util.Config.driver;
import yahoo.toolbar.webDriver.util.CommonLibrary;
public class PlusBtn extends CommonLibrary{

	private static final String String = null;
	//private static final boolean  = false;

	/**
	 * 
	 * Settings constructor used by factory class to create intl specific Test classes
	 *
	**/
	

	public PlusBtn(String intl)
	{
		//initialize intl 
		this.intl=intl;
		//fetch intl specific strings from excel
		data=readExcel(intl,"Settings",5);
		System.out.println(data);
		//create URL
	    URL = "http://fe1.staging.toolbar.bf1.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=3.0.0&modid=ytframe&bid=pres&debug=1"; 
		PlusUrl = "http://fe1.dev-qa.toolbar.bf1.yahoo.com/bh/slideout?.intl=us&.pc=&.ver=3.0.0&modid=ytmenu&bid=add_grp_fav&debug=1&minified=1";
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
		Object element = trigger(java.lang.String.format(script, url));
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
	
	
	//About Testcase : Verifying the select from button gallery link in plus button app

	@Test(groups = "regression1212")
	public void plusgallery()
	{
	   driver.get(PlusUrl);
	   sleep(5000);
	   driver.findElementByXPath(getPath("Settings", "plusaddpage", "plusgallery")).click();
	   sleep(5000);
	   String url1 = driver.getCurrentUrl();
	   Assert.assertTrue(url1.contains("us.data.toolbar.yahoo.com/ytoolbar/configserver/glxy/landing"));
	 }






	//About Testcase : Verifying the add this page to toolbar link in plus button app
	@Test(groups = "regression")
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
		    js = driver;
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
