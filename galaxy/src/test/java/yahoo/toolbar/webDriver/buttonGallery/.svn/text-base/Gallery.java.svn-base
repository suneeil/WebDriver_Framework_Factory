package yahoo.toolbar.webDriver.buttonGallery;

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

public class Gallery extends CommonLibrary {
	
	/**
	 * 
	 * Gallery constructor used by factory class to create intl specific Test classes for Galaxy
	 * 
	**/
	

	public Gallery(String intl)
	{
		//initialize intl 
		this.intl=intl;
		//fetch intl specific strings from excel
		data=readExcel(intl,"Gallery",2);
		System.out.println(data);
		//create URL
		URL="http://"+ intl+".data.toolbar.yahoo.com/ytoolbar/configserver/glxy/landing/?intl="+intl+"&pc=&cv="; 
				
		//initialize expected header status message  
		headerStatus[0]=data.get("General Tab");
		headerStatus[1]=data.get("Button Gallery");
		headerStatus[2]=data.get("Help");
		headerStatus[3]=data.get("Change Layout Title");
		headerStatus[4]=data.get("Change Layout Sub Title");
		headerStatus[5]=data.get("Cross Tooltip");
		headerStatus[6]=data.get("Remove Tooltip");
		headerStatus[7]=data.get("Most Popular");
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
			//array containing all the header status messages
			private String[] headerStatus=new String[20];
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

	/**
	 *  configuration method to run before every test
	 * 
	**/
		public void switchWindow() throws NoSuchWindowException,
		NoSuchWindowException 
	{
	Set<String> handles = driver.getWindowHandles();
	String current = driver.getWindowHandle();
	handles.remove(current);
	String newTab = handles.iterator().next();
	Object locator;
	
	}

	/**
	 * 
	 * test to verify general tab presence 
	 * 
	**/
	@Test(groups = "regression")
	public void generalTab()
	{
        driver.get(URL);
        //driver.get("http://us.config.toolbar.yahoo.com/ytoolbar/configserver/glxy/landing/?intl=us&pc=&cv=");
		sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","generalTab","general"))),"General tab is present");
		Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","generalTab","general")).getText().equals(data.get("General Tab")));
	}
	/**
	 * 
	 * test to verify button gallery tab presence 
	 * 
	**/
	@Test(groups = "Regression")
	public void buttonGalleryTab()
	{
        driver.get(URL);
		sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","galleryTab","gallery"))),"Gallery tab is present");
		//Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","generalTab","gallery")).getText().equals(data.get("Button Gallery")));
		
	}
	
	/**
	 * 
	 * test to verify button help tab presence 
	 * 
	**/
	@Test(groups = "Regression")
	public void helpTab()
	{
        driver.get(URL);
		sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","helpTab","help"))),"Help tab is present");
		//Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","generalTab","help")).getText().equals(data.get("Help")));
		
	}
	
	/**
	 * 
	 * test to verify change layout 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void changelayout()
	{
        driver.get(URL);
		sleep(5000);
		Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","layoutTitle","title")).getText().equals(data.get("Change Layout Title")));
		Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","layoutSubTitle","subtitle")).getText().equals(data.get("Change Layout Sub Title")));
		
	}
	
	/**
	 * 
	 * Verify the "X" button is present 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void crossButton()
	{
        driver.get(URL);
		sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","crossButton","cross"))),"Cross button is present");
		
	}
	
	/**
	 * 
	 * Verify the "X" button is present 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void Xtooltip()
	{
        driver.get(URL);
		sleep(5000);
		Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","crossButton","cross")).getAttribute("title").equals(data.get("Cross Tooltip")));
	}
	
	/**
	 * 
	 * Verify clicking on "X" button 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void clickCross()
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","crossButton","cross"))).click();
		sleep(2000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","removeButton","remove"))),"Remove button is present");
	}
	
	/**
	 * 
	 * Verify clicking on "X" button
	
	* 
	**/
	@Test(groups = "Regression")
	public void removeTooltip()
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","crossButton","cross"))).click();
		sleep(2000);
		//Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","removeButton","remove")).getAttribute("title").equals(data.get("Remove Tooltip")));
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","removeButton","remove"))),"Remove button is present");
	}
	 
	
	/**
	 * 
	 * Verify the default layout 
	 * 
	**/
	
	@Test(groups = "Regression111")
	public void defaultLayout()
	{
        driver.get(URL);
		sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","bookmarkLayout","bookmark"))));
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","mailLayout","mail"))));
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","facebookLayout","facebook"))));
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","ebayLayout","ebay"))));
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","visicomLayout","visicom"))));
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","youtubeLayout","youtube"))));
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","weatherlayout","weather"))));
	}
	
	/**
	 * 
	 * Verify clicking on "X" button 
	 * @throws AWTException 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void clickRemove() throws AWTException
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","crossButton","cross"))).click();
		sleep(2000);
		driver.findElement(By.xpath(getPath("Gallery","removeButton","remove"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery", "searchTextEditBox", "searchbox"))).clear();
		driver.findElement(By.xpath(getPath("Gallery", "searchTextEditBox", "searchbox"))).sendKeys("Mail");
		sleep(7000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","mailButtonPresent","buttonPresent"))),"Remove button is present");
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","mailButtonPresent","buttonPresent"))).click();
		sleep(5000);
	}
	
	/**
	 * 
	 * Verify the featured Apps 
	 * @throws AWTException 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void featureAppPresent() 
	{
        driver.get(URL);
		sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","featureTabPresent","feature"))),"Feature tab present");
			
	}
	
	/**
	 * 
	 * Verify the featured Apps should not display when app search is performed 
	 * @throws AWTException 
	 * 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void featureAppPresentdisable() throws AWTException 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery", "searchTextEditBox", "searchbox"))).clear();
		driver.findElement(By.xpath(getPath("Gallery", "searchTextEditBox", "searchbox"))).sendKeys("Mail");
		sleep(2000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		sleep(5000);
		Assert.assertTrue((!isElementPresent(By.xpath(getPath("Gallery","featureTabPresent","feature")))),"Feature tab is not present");
			
	}
	
	/**
	 * 
	 * Verify images for features 
	 * @throws AWTException 
	 * 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void featuredimages() 
	{
        driver.get(URL);
		sleep(5000);
		Assert.assertTrue((isElementPresent(By.xpath(getPath("Gallery","weatherImage","weather")))),"Weather image is present");
		Assert.assertTrue((isElementPresent(By.xpath(getPath("Gallery","facebookImage","facebook")))),"Facebook image is present");
		//Assert.assertTrue((isElementPresent(By.xpath(getPath("Gallery","youtubeImage","youtube")))),"Youtube image is present");
		//Assert.assertTrue((isElementPresent(By.xpath(getPath("Gallery","mailImage","mail")))),"Mail image is present");
		Assert.assertTrue((isElementPresent(By.xpath(getPath("Gallery","bookmarkImage","bookmark")))),"Bookmark image is present");
	}
	
	/**
	 * 
	 * Verify images for features 
	 * 
	**/
	
	@Test(groups = "Regression111")
	public void addAppFromFeaturedApp() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","crossButton","cross"))).click();
		sleep(2000);
		driver.findElement(By.xpath(getPath("Gallery","removeButton","remove"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","mailImage","mail"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","mailAdd","mail"))).click();
		sleep(5000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","mailLayout","mail"))));
		
	}
	
	/**
	 * 
	 * Verify text for most popular section
	 * 
	**/
	
	@Test(groups = "Regression")
	public void mostPopular() 
	{
        driver.get(URL);
		sleep(5000);
		System.out.println("text " + driver.findElementByXPath(getPath("Gallery","mostPopular","popular")).getText());
		//Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","mostPopular","popular")).getText().equals(data.get("Most Popular")));
		Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","mostPopular","popular")).getText().contains("Most Popular"));
	}
	
	/**
	 * 
	 * Verify text for most popular section
	 * 
	**/
	
	@Test(groups = "Regression112")
	public void seeAllLink() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","seeAllLink","seeAll"))).click();
		sleep(3000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","allButtons","button"))),"All buttons present");
	}
	
	/**
	 * 
	 * Verify General tab is working 
	 * 
	**/
	
	@Test(groups = "Regression")
	public void generalPage() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","generalPage","general"))),"General page present");
	}
	
	/**
	 * 
	 * Verify add appbutton checkbox is present and clickable 
	 * 
	**/
	@Test(groups = "Regression")
	public void addAppButtonCheckbox() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","addAppButtonCheckbox","checkbox"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","addAppButtonCheckbox","checkbox"))),"Add App check box is present and clickable");
		
	}
	
	/**
	 * 
	 * Verify text lable for each app checkbox is present and clickable 
	 * 
	**/
	@Test(groups = "Regression")
	public void textLableCheckbox() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","textLableCheckbox","checkbox"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","textLableCheckbox","checkbox"))),"textLable check box is present and clickable");
		
	}
	
	/**
	 * 
	 * Verify add featuretip checkbox is present and clickable 
	 * 
	**/
	@Test(groups = "Regression")
	public void featureTipCheckbox() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","featureTipCheckbox","checkbox"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","featureTipCheckbox","checkbox"))),"featureTip check box is present and clickable");
		
	}
	
	
	/**
	 * 
	 * Verify add BrowserUtility checkbox is present and clickable 
	 * 
	**/
	/**
	@Test(groups = "Regression121212")
	public void browserUtilityCheckbox() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","browserUtilityCheckbox","checkbox"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","browserUtilityCheckbox","checkbox"))),"Browser Utility check box is present and clickable");
		
	}
	**/
	
	
	/**
	 * 
	 * Verify add Search Assist checkbox is present and clickable 
	 * 
	**/
	@Test(groups = "Regression")
	public void searchAssistCheckbox() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","searchAssistCheckbox","checkbox"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","searchAssistCheckbox","checkbox"))),"search assist check box is present and clickable");
		
	}
	
	
	/**
	 * 
	 * Verify Open results in new tab checkbox is present and clickable 
	 * 
	**/
	@Test(groups = "Regression")
	public void newTabCheckbox() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","newTabCheckbox","checkbox"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","newTabCheckbox","checkbox"))),"Open results in new tab check box is present and clickable");
		
	}
	
	
	/**
	 * 
	 * Verify 404 Assistant checkbox is present and clickable 
	 * 
	**/
	@Test(groups = "Regression")
	public void navAssistCheckbox() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","navAssistCheckbox","checkbox"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","navAssistCheckbox","checkbox"))),"Nav Assist check box is present and clickable");
		
	}
	
	/**
	 * 
	 * Verify 404 Assistant checkbox is present and clickable 
	 * 
	**/
	@Test(groups = "Regression")
	public void privacyCheckbox() 
	{
        driver.get(URL);
		sleep(5000);
		driver.findElement(By.xpath(getPath("Gallery","generalTab","general"))).click();
		sleep(3000);
		driver.findElement(By.xpath(getPath("Gallery","privacyCheckbox","checkbox"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Gallery","privacyCheckbox","checkbox"))),"privacy check box is present and clickable");
		
	}
	
	/**
	@Test(groups = "Regression3232")
	public void helpTabUrl() throws AWTException
	{
        driver.get(URL);
		sleep(5000);
		String currentUrl;
		driver.findElement(By.xpath(getPath("Gallery","helpTab","help"))).click();
		sleep(7000);
		Set<String> handles = driver.getWindowHandles();
		java.util.Iterator<String> it = handles.iterator();
		// iterate through your windows
		while (it.hasNext())
		{
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);
			Assert.assertTrue(driver.getCurrentUrl().equals("http://help.yahoo.com/kb/index?page=product&y=PROD_TOOL&locale=en_US"));
			//Assert.assertTrue(driver.findElementByXPath(getPath("Gallery","generalTab","help")).getText().equals(data.get("Help")));
			Robot r = new Robot(); 
			r.keyPress(KeyEvent.VK_ALT); 
			r.keyPress(KeyEvent.VK_F4); 
			r.keyRelease(KeyEvent.VK_ALT); 
			r.keyRelease(KeyEvent.VK_F4);
			sleep(2000);
			driver.switchTo().window(parent);
			sleep(3000);
		}
		
	}
	**/
	@Test(groups = "Regression")
	public void helpPageVerification() throws AWTException
	{
        driver.get(URL);
		sleep(5000);
		String currentUrl;
		driver.findElement(By.xpath(getPath("Gallery","helpTab","help"))).click();
		sleep(7000);
		Set<String> handles = driver.getWindowHandles();
		java.util.Iterator<String> it = handles.iterator();
		// iterate through your windows
		while (it.hasNext())
		{
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);
			String url1 = driver.getCurrentUrl();
			Assert.assertTrue(url1.contains("help.yahoo.com/kb/index?page=product&y=PROD_TOOL&locale"));
			Robot r = new Robot(); 
			r.keyPress(KeyEvent.VK_ALT); 
			r.keyPress(KeyEvent.VK_F4); 
			r.keyRelease(KeyEvent.VK_F4); 
			r.keyRelease(KeyEvent.VK_ALT);
			sleep(2000);
			driver.switchTo().window(parent);
			sleep(3000);
		}
		
		
	}
}
