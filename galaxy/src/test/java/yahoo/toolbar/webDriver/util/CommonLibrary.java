package yahoo.toolbar.webDriver.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.w3c.dom.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import static yahoo.toolbar.webDriver.util.Config.driver;



/**
 * Class containing common functions for the test suite
 * @author asingla
 **/

public class CommonLibrary {
	
	/**
	 * 
	 * Variable decalaration's section
	 * 
	 * declare object and class variables in this section
	 **/
	
	
	
	
	/**
	 * 
	 *Common methods  section
	 *
	 *Please define all of test suite common method's in this section
	 **/
	
	
	/**
	 * Method to get path from XPathList.xml file
	 * @app=name of the app e.g Youtube
	 * @element=element to fetch e.g Playbutton
	 * @identifier=how to identify element e.g Link,id etc 
	 **/
	
	public String getPath(String app,String element ,String identifier)
	{
		try
		{
			//create Document object using XPathList.xml file
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			//Document doc=builder.parse(new File("/Users/asingla/workspace/galaxy/src/test/resources/XPathList.xml"));
			Document doc=builder.parse(new File("src/test/resources/XPathList.xml"));
			
			//get app node list
			NodeList nodeList=doc.getElementsByTagName(app);
			//getting first node from list
			Node node=nodeList.item(0);
			//if node is element node
			if(node.getNodeType()==Node.ELEMENT_NODE)
			{
				
				Element elementNode=(Element)node; 
				//get node list given by @element
				NodeList childNodes=elementNode.getElementsByTagName(element);
				//loop through all the @element nodes 
				for(int i=0; i<childNodes.getLength();i++)
				{	
					//fetch @element node
					Node childNode=childNodes.item(i);
					//if @element node is element node
					if(childNode.getNodeType()==Node.ELEMENT_NODE)
					{
							//fetch all the attributes nodes of @element node
							NamedNodeMap attributeNodes=childNode.getAttributes();
							//loop through all the attributes nodes
							for(int j=0; j<attributeNodes.getLength();j++)
							{
								//fetch attribute node
								Node attributeNode=attributeNodes.item(j);
								//if attributeNode is attribute node
								if(attributeNode.getNodeType()==Node.ATTRIBUTE_NODE)
								{		
									//check node name with @identifier and return childNode value
									if(attributeNode.getNodeValue().equals(identifier))
									{
										return childNode.getTextContent();
									}
								}
								//if atttributeNode is not an attribute node, print on console and exit
								else
								{
									System.out.println("#####"+attributeNode+"is not a attribute node"+"#######");
								}
							}
					}
					//if @element node is not an element node, print on console and exit
					else
					{
						System.out.println("#####"+childNode+"is not a element node"+"#######");
					}
				}
				
			}
			//if node is not an element node, print on console and exit
			else
			{
				System.out.println("#####"+node+"is not a element node"+"#######");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * Method to return if element is present or not
	 *@By= By object
	**/
	public boolean isElementPresent(By by)
	{	
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	/**
	 * 
	 *Method to return if text is present or not
	 * @text=text to find
	**/
	public boolean isTextPresent(String text)
	{
		return driver.findElement(By.tagName("body")).getText().contains(text);
	}
	
	/**
	 * Method to waits for an element to appear on the page for a provided amount of time and checks every 500 milliseconds.
	 * @by= By object
	 * @p_maxTimeOutInMilliSeconds=time in millisecond to wait
	**/
	public  boolean waitForElementPresent(By by, int maxTimeOutInMilliSeconds)
	{
		//timer for the for loop.
		int timer;
		
		//timer starts at 0, increases by 500 each loop, and stops when the element is there, OR it is greater than the max time out.
		for (timer = 0; timer <= maxTimeOutInMilliSeconds; timer = timer+500)
		{
			//if the passed in element is there and visible...
			if (isElementPresent(by) && driver.findElements(by).get(0).isDisplayed())
			{
				//return true and break out.
				return true;
			}
			
			try
			{
				//otherwise... the thread sleeps for half a seconds and loops through again.
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//return false because we are passed the max timeout and the element can not be found.
		return false;
	}
	
	/**
	 * 
	 * Method to wait for element to disappear from page in provided amount of time
	 * @param xPath
	 * @param p_maxTimeOutInMilliSeconds
	 * 
	 */
	public  boolean waitForElementNotPresent(By by, int maxTimeOutInMilliSeconds)
	{
		//timer for the for loop.
		int timer;
		
		//timer starts at 0, increases by 500 each loop, and stops when the element is there, OR it is greater than the max time out.
		for (timer = 0; timer <= maxTimeOutInMilliSeconds; timer = timer+500)
		{
			//if the passed in element is not there...
			if (isElementPresent(by) == false)
			{
				//return true and break out.
				return true;
			}
			try
			{
				//otherwise... the thread sleeps for half a seconds and loops through again.
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//return false because we are passed the max timeout and the element can still be found.
		return false;
	}
	
	/**
	 * method to sleep for given amount of time
	 * @milliSecond= time in millisecond to sleep
	 * 
	**/
	public void sleep(int milliSecond)
	{
		try
		{
			Thread.sleep(milliSecond);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 *method to login to yahoo
	 *@userName=username
	 *@password=password 
	 * @loginPage= if want to login by going to login.yahoo.com
	**/
	public void login(String userName,String password,boolean loginPage)
	{
		if(loginPage)
		{
			driver.get("https://login.yahoo.com");
			sleep(5000);
		}
			
		//enter user name
		driver.findElementById(getPath("LogIn","UserName","userName")).sendKeys(userName);
		//enter password
		driver.findElementById(getPath("LogIn","Password","password")).sendKeys(password);
		//sign in
		driver.findElementById(getPath("LogIn","SignIn","signIn")).click();
		sleep(5000);
	}
	
	/**
	 * 
	 *method to logout from yahoo 
	 * 
	**/
	public void logout()
	{
		//navigate to logout url
		driver.get("http://login.yahoo.com/config/login?logout=1");
		sleep(4000);
	}
	
	/**
	 * 
	 * verify if driver is firefox driver
	 * 
	**/
	public boolean isFirefoxDriver()
	{
		if(driver instanceof FirefoxDriver)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * verify if driver is chrome driver
	 * 
	**/
	public boolean isChromeDriver()
	{
		if(driver instanceof ChromeDriver)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * verify if driver is IE driver
	 * 
	**/
	public boolean isIEDriver()
	{
		if(driver instanceof InternetExplorerDriver)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * method to read data from excel
	 * @intl=intl to use
	 * @appName=name of app e.g YouTube  
	 * @sheetNumber=sheet number of workbook
	 * 
	**/
	public Map<String,String> readExcel(String intl,String appName,int sheetNumber)
	{
		try
		{
			//input stream to excel file
			FileInputStream fileInputStream = new FileInputStream("src/test/resources/IntlStrings.xls");
			//create POIFSFileSystem object
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			//create workbook object
			HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
			//create sheet object
			HSSFSheet hssfSheet = workBook.getSheetAt(sheetNumber);
			//create iterator to iterate over all the rows
			Iterator rowIterator = hssfSheet.rowIterator();
			//map of result data
			Map<String,String> data=new HashMap<String,String>();
			
			//declare variables
			boolean cond=false;
			//String intl=getPath("Config","Intl","intl");
			int i=0;
			List<String> li=new  ArrayList<String>();
			HSSFRow hssfRow=null;
			Iterator cellIterator=null;
			String cellValue=null;
			
			//iterate over all the rows present in the sheet
			while (rowIterator.hasNext())
			{
				//fetch row
				hssfRow = (HSSFRow) rowIterator.next();
				//create cell iterator for the fetched row
				cellIterator = hssfRow.cellIterator();
				//while cells are present in the row
				while(cellIterator.hasNext())
				{			
					//fetch cell value
					cellValue=((HSSFCell)cellIterator.next()).getStringCellValue();
					
					//if cond=true, add cell value to list,li
					if(cond)
					{
						//add all cell values of the row to list , li 
						while(cellIterator.hasNext())
						{
							cellValue=((HSSFCell)cellIterator.next()).getStringCellValue();
							li.add(cellValue);
							
						}
						//update conditions
						i++;
						cond=false;
						break;
						
					}
					
					//if i==1
					if(i==1)
					{
						//if cell value is equal to given intl
						if(cellValue.equals(intl))
						{
							int k=0;
							//add cell values to data map
							while(cellIterator.hasNext())
							{
								cellValue=((HSSFCell)cellIterator.next()).getStringCellValue();
								data.put((String)li.get(k),cellValue);
								k++;
							}
							//close stream and return data
							fileInputStream.close();
							return data;
						}
						
					}
					
					//if cell value equals to appName
					if(cellValue.equals(appName))
					{
						cond=true;
						break;						
					}
				}	
					
			}
			//close stream
			fileInputStream.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	/*
	 * This function is for Inpanel Login for Mail and Bookmarks app 
	 * Required Username, Password and App as String
	 * App =  boo or yma
	 * intl = either null or us/uk/hk....
	 * 
	 */
	
	
	
	public void inPanel_Login(String uname, String pwd, String app) 
	{
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
		logout();
		sleep(5000);
		driver.get("http://us.data.toolbar.yahoo.com/bh/slideout?.=us&.pc=&.ver=3.0.2&modid=ytframe&bid="+app+"&debug=1");
		sleep(9000);
		Assert.assertTrue(driver.findElement(By.xpath(getPath("Mail", "UserName", "username"))).isDisplayed(), "User Name field not found");
		driver.findElement(By.xpath(getPath("Mail","UserName","username"))).sendKeys(uname);
		
		Assert.assertTrue(isElementPresent(By.xpath(getPath("Mail","Password","passwd"))), "Psssword edit box not Presenet");
		driver.findElement(By.xpath(getPath("Mail","Password","passwd"))).sendKeys(pwd);
		sleep(2000);
		driver.findElement(By.xpath(getPath("Mail","Password","passwd"))).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@class='login-btn-container']//span[text()='Sign In']")).click();
				
		//driver.findElement(By.))).click();
		sleep(9000);
		
		
		
	}
	
	
	
	/**
	 * 	Note: This method will work only inside corp n/w 
	 *	Method to send simple text/HTML email
	 *	@to=address to whom email to be send
	 *	@from=address from whom email to be send
	 *	@subject=subject of message
	 *	@content=text content
	 *	@html= if message is HTML message or not
	**/
	public void sendEmail(String to,String from,String subject,String content,boolean html)
	{
		//set host
	    Properties properties = System.getProperties();
	    properties.setProperty("mail.smtp.host", "smtp.yahoo.com");
	    //use default session
	    Session session = Session.getDefaultInstance(properties);
		 
	   try
	   {
	        //Create a default MimeMessage object.
	        MimeMessage message = new MimeMessage(session);
	        //Set From: header field
	        message.setFrom(new InternetAddress(from));
	        //Set To: header field
	        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	        //Set Subject: header field
	        message.setSubject(subject);
	        //actual message, if HTML message
	        if(html)
	        {
	        	message.setContent(content,"text/html");
	        }
	        else
	        {
	        	message.setText(content);
	        }
	        
	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	    }
		catch (MessagingException mex) 
		{
			mex.printStackTrace();
		}
	}
	
}	

