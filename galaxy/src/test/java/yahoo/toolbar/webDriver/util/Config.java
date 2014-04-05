package yahoo.toolbar.webDriver.util;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * Class containing config settings for the suites
 * @author asingla
 *
 */
public class Config extends JFrame {
	
	/**
	 * 
	 * Variable decalaration's section
	 * 
	 * declare object and class variables in this section
	 **/
	
	public static RemoteWebDriver driver=null;
	public static String browser=null;
	private JComboBox combo;
	private JFrame frame = new JFrame("Select Browser");
	private JPanel panel = new JPanel();
	private JLabel label= new JLabel();
	private JButton button=new JButton("OK");
	
	
	/**
	 * Method's declaration section
	 * 
	 * define all of the methods in this section
	 * 
	 **/
	
	/**
	 * 
	 * define configuration to be done before running suite
	 * define @driver to be use 
	 * 
	 **/
	@BeforeSuite(alwaysRun=true)
	public void selectBrowser()
	{
		//show JFrame to user and get the user selected option: browser
		showCombo();
		CommonLibrary ob=new CommonLibrary();
		ob.sleep(15000);
		//get logged-in user name
		String userName=System.getProperty("user.name");
		//get OS
		String OSName=System.getProperty("os.name");
		//variable declaration
		String driverDirectoryPath;
		String chromeExtensionDir;
		String profileFolderPath;
		
		if(OSName.equals("Mac OS X"))
		{
			//path for drivers directory
			driverDirectoryPath= "/Users/"+userName+"/Documents/drivers/";
			//path to chrome extensions
			chromeExtensionDir="/Users/"+userName+"/Documents/extensions/";
			//firefox profile folder path
			profileFolderPath="/Users/"+userName+"/Library/Application Support/Firefox/Profiles/";
		}
		else
		{
			//path for drivers directory
			driverDirectoryPath="C:\\Users\\"+userName+"\\Documents\\drivers\\";
			//path to chrome extensions
			chromeExtensionDir="C:\\Users\\"+userName+"\\Documents\\extensions\\";
			//firefox profile folder path
			profileFolderPath="C:\\Users\\"+userName+"\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\";
		}
		
		//create file object pointing to firefox profiles folder
		File file=new File(profileFolderPath);
		//get all the profiles listed in profiles folder
		String[] profiles=file.list();
		String profileName=null;
		//go through all the profiles and find profile named :Default User
		for(int i=0;i<profiles.length;i++)
		{
			profileName=profiles[i];
			if(profileName.endsWith(".Default User"))
			{
				break;
			}
		}
		
		
		//if user didn't select anything , get the browser from XPathList.xml file and dispose the frame
		if(browser==null)
		{
			frame.setVisible(false);
            frame.dispose();
			browser=ob.getPath("Config","DefaultBrowser","browser");
		}
		
		//based on the browser create driver
		if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver",driverDirectoryPath+"IEDriverServer.exe");
			driver=new  InternetExplorerDriver();
			driver=((InternetExplorerDriver)driver);
		}
		else if(browser.equals("Chrome"))
		{
			if(OSName.equals("Mac OS X"))
			{
				System.setProperty("webdriver.chrome.driver",driverDirectoryPath+"chromedriver");
			}
			else
			{
				System.setProperty("webdriver.chrome.driver",driverDirectoryPath+"chromedriver.exe");
			}
			driver=new ChromeDriver();
			driver=((ChromeDriver)driver);
		}
		else if(browser.equals("Chrome w/e"))
		{
			if(OSName.equals("Mac OS X"))
			{
				System.setProperty("webdriver.chrome.driver",driverDirectoryPath+"chromedriver");
			}
			else
			{
				System.setProperty("webdriver.chrome.driver",driverDirectoryPath+"chromedriver.exe");
			}
			
			//create chrome options object
			ChromeOptions option = new ChromeOptions();
			//create file object pointing to chrome extensions folder
			File chromeExtenDir=new File(chromeExtensionDir);
			//get all the extensions listed there
			String[] extensions=chromeExtenDir.list();
			ArrayList<File> extensionsFile=new ArrayList<File>();
			//loop through all the extension
			for (int i=0;i<extensions.length;i++)
			{
				extensionsFile.add(new File(chromeExtensionDir+extensions[i]));
			}
			
			//add extensions to ChromeOptions object
			option.addExtensions(extensionsFile);
			//create driver object
			driver=new ChromeDriver(option);
			driver=((ChromeDriver)driver);
		}
		else if(browser.equals("FF"))
		{
			driver=new FirefoxDriver();
			driver=((FirefoxDriver)driver);
			
		}
		else if(browser.equals("FF (Default Profile)"))
		{
			driver=new FirefoxDriver(new FirefoxProfile(new File(profileFolderPath+profileName)));
			driver=((FirefoxDriver)driver);
		}
		else
		{
			driver=new FirefoxDriver();
			driver=((FirefoxDriver)driver);
		}
		
	}
	
	
	/**
	 *
	 * config method to quit browser after test suite run 
	 * 
	 **/
	@AfterSuite(alwaysRun=true)
	public void killBrowser()
	{
		driver.quit();
	}
	
	
	

	/**
	 * Method to show JFrame to user to select browser on which automation to be run
	 *  
	**/
	private void showCombo()
	{
		//browser options
		String course[] = {"IE","FF","FF (Default Profile)","Chrome","Chrome w/e"};
		//create JPanel
		combo = new JComboBox(course);
		combo.setBackground(Color.gray);
		combo.setForeground(Color.green);
		combo.setBounds(100, 100,50,50);
		label.setText("Select Browser");
		panel.add(label);
		panel.add(combo);
		panel.add(button);
		frame.add(panel);
		
		//set size and visibility of JFrame and exit frame upon clicking on CLOSE button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 400);
		frame.setSize(400,100);
		frame.setVisible(true);
		
		//listener will listen which browser user selected upon clicking on OK button
		button.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//get the user selected browser and dispose frame
						browser=(String)combo.getSelectedItem();
						System.out.print(combo.getSelectedItem());
						frame.setVisible(false);
						frame.dispose();
					}
				}
		);
	}
}
