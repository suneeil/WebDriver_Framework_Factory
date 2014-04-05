package yahoo.toolbar.webDriver.apps.facebook;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import yahoo.toolbar.webDriver.util.*;
import static yahoo.toolbar.webDriver.util.Config.driver;
import yahoo.toolbar.webDriver.util.CommonLibrary;

public class Facebook extends CommonLibrary {
	
	/**
	 * 
	 * Facebook constructor used by factory class to create intl specific Test classes
	 *
	**/
	

	public Facebook(String intl)
	{
		//initialize intl 
		this.intl=intl;
		//fetch intl specific strings from excel
		data=readExcel(intl,"Facebook",1);
		System.out.println(data);
		//create URL
		URL="http://toolbar.yahoo.com/ytoolbar/slideouts/php/modules/fbupdates.php?debug=1&widget_id=toolbar.fbupdates&intl="+intl; 
		System.out.println(data);
		//initialize expected header status message  
//		headerStatus[0]=data.get("Login page");
	//	headerStatus[1]=data.get("Login button");
		//headerStatus[2]=data.get("Error Message");
		
		
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
			private String userName="testingga92@yahoo.in";
			private String password="abcd@1234";
	/**
	 * Executes a script on an element
	 * 
	 * @note Really should only be used when the web driver is sucking at
	 *       exposing functionality natively
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

	public void switchWindow() throws NoSuchWindowException,
			NoSuchWindowException 
	{
		Set<String> handles = driver.getWindowHandles();
		String current = driver.getWindowHandle();
		handles.remove(current);
		String newTab = handles.iterator().next();
		Object locator;

	}

	private void faceBookLogin(String Username, String Password)
	{
		driver.get("http://search.yahoo.com");
		sleep(4000);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		openTab(URL);
		Set<String> handles = driver.getWindowHandles();
		java.util.Iterator<String> it = handles.iterator();
		// iterate through your windows
		while (it.hasNext())
		{
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);
			waitForElementPresent(
					By.xpath(getPath("Facebook", "FacebookSignIn", "signIn")),
					4000);
			driver.findElementByXPath(
					getPath("Facebook", "FacebookSignIn", "signIn")).click();
			sleep(5000);
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(
					Username);
			driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(
					Password);
			driver.findElement(By.xpath("//input[@name='login']")).click();
			sleep(10000);
			driver.switchTo().window(parent);
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			driver.get(URL);
			waitForElementPresent(
					By.xpath(getPath("Facebook", "facebookProfile", "profile")),
					4000);
	    }
    }
	
	private void login()
	{
		driver.get(URL);
		sleep(20000);
		if(driver.findElementByXPath(getPath("Facebook","loginMessage","message")).getText().equals(data.get("Login page")))
		
		{
			String username = "testingga92@yahoo.in";
			String password = "abcd@1234";
			faceBookLogin(username, password);	
			
		}
		
	}
	
	private void logOut()
	{   
		driver.get("http://search.yahoo.com");
		sleep(4000);
		openTab(URL);
		Set<String> handles = driver.getWindowHandles();
		java.util.Iterator<String> it = handles.iterator();
		// iterate through your windows
		while (it.hasNext())
		{
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);
		sleep(4000);
		driver.findElement(By.xpath(getPath("Facebook","facebookLogout","logout"))).click();
		sleep(10000);
		driver.switchTo().window(parent);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get(URL);
		}
		
	}

	
	@Test(groups = "Smoke")
	public void loginMessage()
	{
        logOut();
        sleep(6000);
		driver.get(URL);
		sleep(5000);
		Assert.assertTrue(driver.findElementByXPath(getPath("Facebook","loginMessage","message")).getText().equals(data.get("Login page")));
		
	}

	
	
	@Test(groups = "Smoke")
	public void faceBooklogin()
	{
		login();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Facebook","facebookLogout","logout"))),"Facebook Logout link is present.");
	}
	
	
	@Test(groups = "Smoke")
	public void profileVerify()
	{
		login();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Facebook", "facebookProfile", "profile"))),"Facebook profile is present");
		driver.findElement(By.xpath(getPath("Facebook", "facebookProfile", "profile"))).click();
		sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Facebook", "facebookPhoto", "photo"))),"Photo is present under Facebook profile");
		driver.findElement(By.xpath(getPath("Facebook", "facebookPhoto", "photo"))).click();
	}
	
	
	@Test(groups = "Smoke")
	public void NotificationVerify()
	{
		login();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Facebook", "facebookNotification", "notification"))),"Facebook notification is present");
		driver.findElement(By.xpath(getPath("Facebook", "facebookNotification", "notification"))).click();
		sleep(5000);
		if(isElementPresent(By.xpath(getPath("Facebook", "facebookPhoto", "photo"))))
		{
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Facebook", "facebookPhoto", "photo"))),"Photo is present under Facebook notification");
		driver.findElement(By.xpath(getPath("Facebook", "facebookPhoto", "photo"))).click();
		}
		else
		{
			Assert.assertTrue(isElementPresent(By.xpath(getPath("Facebook", "notificationAvailability", "notification"))),"notifications are not available");
		}
	}
	
	
	@Test(groups = "Regression")
	public void LinkVerify() throws AWTException
	{
		login();
		sleep(5000);
		driver.findElement(By.xpath(getPath("Facebook", "facebookShare", "share"))).sendKeys("test");
		
		sleep(7000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//driver.findElement(By.xpath(getPath("Facebook", "facebookShare", "share"))).sendKeys(Keys.ENTER);
		sleep(7000);
		Assert.assertTrue(driver.findElementByXPath(getPath("Facebook","commentMessage","comment")).getText().equals("test"));
		driver.findElementByXPath(getPath("Facebook", "facebookLike", "like")).click();
		sleep(7000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Facebook", "unlikeLink", "unlike"))),"Verify Unlike link present");
		
	}
	
	
	@Test(groups = "Regression")
	public void CommentVerify() throws AWTException
	{
		login();
		sleep(5000);
		String postXpath=getPath("Facebook","Post","post");
		String commentXpath=getPath("Facebook","Comment","comment");
		String commentShareXpath=getPath("Facebook","commentShare","share");
        int i=1;
		String commentPath=postXpath+i+"]"+commentXpath;
		String commentSharePath=postXpath+i+"]"+commentShareXpath;
		driver.findElementByXPath(commentPath).click();
		sleep(7000); 
		//driver.findElementByXPath(commentSharePath).sendKeys("awesome");
		String commentBoxXpath=postXpath+i+"]"+getPath("Facebook", "facebookcommentShare", "passComment");
		Random rand = new Random();
		  int num = rand.nextInt(1000);
		  int numpass = rand.nextInt();
		driver.findElementByXPath(getPath("Facebook", "facebookcommentShare", "passComment")).sendKeys(Integer.toString(numpass) );
		sleep(7000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		sleep(7000);
		String text=driver.findElementByXPath(postXpath+i+"]"+getPath("Facebook","commentVerification","Comment")).getText();
		Assert.assertTrue(text.contains(Integer.toString(numpass)));
		sleep(3000); 
	}
	
	
	@Test(groups = "Regression")
	public void clickLike()
	{
		login();
		sleep(5000);
		String postXpath=getPath("Facebook","Post","post");
		String likeXpath=getPath("Facebook","Like","like");
		String commentXpath=getPath("Facebook","Comment","comment");
		int i=1;
		String commentPath=postXpath+i+"]"+commentXpath;
		String likePath=postXpath+i+"]"+likeXpath;
		//loop till all posts
		do
		{
			//click on like
			if(isElementPresent(By.xpath(commentPath)) && isElementPresent(By.xpath(likePath)))
			{
			driver.findElementByXPath(likePath).click();
			sleep(2000);
			}
			i++;
			//update path
			likePath=postXpath+i+"]"+likeXpath;
			
		}while(isElementPresent(By.xpath(postXpath+i+"]")));
		
	}
	
		
	@Test(groups = "Regression")
	public void clickComment()
	{
		login();
		sleep(5000);
		String postXpath=getPath("Facebook","Post","post");
		String likeXpath=getPath("Facebook","Like","like");
		String commentXpath=getPath("Facebook","Comment","comment");
       	int i=1;
		String commentPath=postXpath+i+"]"+commentXpath;
		String likePath=postXpath+i+"]"+likeXpath;
		//loop till all posts
		do
		{
			//click on comment
			if(isElementPresent(By.xpath(commentPath)) && isElementPresent(By.xpath(likePath)))
			{
				driver.findElementByXPath(commentPath).click();
			    sleep(2000);
			}
			i++;
			//update path
			commentPath=postXpath+i+"]"+commentXpath;
			
		}while(isElementPresent(By.xpath(postXpath+i+"]")));
		
	}

@Test(groups = "Regression")
public void viewmoreVerify()
{
	login();
	Assert.assertTrue(isElementPresent(( By.xpath(getPath("Facebook", "viewMore", "more")))),"Viewmore like is present");
	sleep(5000);
}


@Test(groups = "Regression1")
public void morePosts()
{
		login();
		sleep(5000);
		String postXpath=getPath("Facebook","Post","post");
		String commentXpath=getPath("Facebook","Comment","comment");
       
		int i=1;
		String commentPath=postXpath+i+"]"+commentXpath;

		//loop till all posts
		while(isElementPresent(By.xpath(postXpath+i+"]")))
     	{			
	    	i++;
		     //update path
		    commentPath=postXpath+i+"]"+commentXpath;		
		 }
		driver.findElementByXPath(getPath("Facebook", "viewMore", "more")).click();
		sleep(5000);
		
		if (isElementPresent(By.xpath(getPath("Facebook","viewMoreErrorMessage","errormsg"))))
		 {
			System.out.println("Error message");
			Assert.assertTrue(isElementPresent(( By.xpath(getPath("Facebook","viewMoreErrorMessage","errormsg")))),"Facebook updates are temporarily unavailable.");
			
		 }
		else
		  {
			i++;
			if(isElementPresent(By.xpath(postXpath+i+"]")))
			{
		    Assert.assertTrue(isElementPresent(By.xpath(postXpath+i+"]")),"More post are available");
		    }
			else
			{
				Assert.assertTrue(isElementPresent(By.xpath(postXpath+i+"]")),"More post are not available");
			}
		  	}	
}
		
}		
		
		

