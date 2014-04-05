package yahoo.toolbar.webDriver.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Class used to send email after test suite execution , implements IReporter interface
 * @author asingla
 **/

public class SendEmail_New extends CommonLibrary implements IReporter 
{
	private static final String String = null;
	/**
	 * 
	 * Variable decalaration's section
	 * 
	 * declare object and class variables in this section
	 **/
	
	String outputDirectory;
	private int passedTestCases;
	private int failedTestCases=0;
	private int skippedTestCases=0;
	//variable to check email is send only once
	static int cond=0;
	
	
	/**
	 * Method's declaration section
	 * 
	 * define all of the methods in this section
	 * 
	 **/
	
	
	
	
	/**
	 * Method to generate report after test execution is complete , it override generateReport method of IReporter
	 * 
	 * @xmlSuites=xml suites list that testng used
	 * @suites= list of suites testng used
	 * @outputDirectory=directory to which output report will be generated
	 **/
	
	@Override
	public void generateReport(java.util.List<XmlSuite> xmlSuites, java.util.List<ISuite> suites,String outputDirectory) 
	{
		//get testng tests and fetch result of suite execution
		XmlSuite suite=xmlSuites.get(0);
		List<XmlTest> xmlTests=suite.getTests();
		Map<String,ISuiteResult> result=suites.get(0).getResults();
		
		//loop through all the tests to find passed , skipped, failed testcases
		for(int i=0;i<xmlTests.size();i++)
		{
			//get the ITestContext and the result of test
			ITestContext testContext=result.get(xmlTests.get(i).getName()).getTestContext();
			passedTestCases+=testContext.getPassedTests().size();
			failedTestCases+=testContext.getFailedTests().size();
			skippedTestCases+=testContext.getSkippedTests().size();
			
		}
		
		//check if sendMail is true in XPathList.xml, if true send mail
		if(getPath("Config","SendEmail","sendMail").equals("true"))
		{
			//at present testng sending email twice after suite run, so adding check to ensure email is sent only once
			if(cond==0)
			{	
				sendEmail();
				cond++;
			}
		}
	}
	

@AfterSuite(alwaysRun=true)
private void sendEmail()
{

	int totalTestCases=passedTestCases+failedTestCases+skippedTestCases;
	String to = "hsandesh@yahoo-inc.com";
	String from = "GalaxyReports@yahoo-inc.com";
    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", "smtp.yahoo.com");
    //use default session
    Session session = Session.getDefaultInstance(properties);
	
  //2) compose message   
  try{
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    message.setSubject("Galaxy Apps Automation Report");
    
    //3) create MimeBodyPart object and set your message content    
    BodyPart messageBodyPart1 = new MimeBodyPart();
  messageBodyPart1.setText("This is message body");
  messageBodyPart1.setContent(
       		"<html></body>" +
       		"Hi All,<br/>" +
       		"<br>Please find below the automation run report:</br><br/>" +
        	"<br>" +
     		"<TABLE width='100%' border='1'>" +
       		"<tr>" +
       		"<th>Total Test Executed</th>" +
       		"<th>Test Passed</th>" +
       		"<th>Test Failed</th>" +
    		"<th>Test Skipped</th>" +
       		"</tr>" +
        	"<tr>" +
        	"<td align='center'>"+totalTestCases+"</td>" +
        	"<td align='center'>"+passedTestCases+"</td>" +
       	"<td align='center'>"+failedTestCases+"</td>" +
        	"<td align='center'>"+skippedTestCases+"</td>" +
        	"</tr>" +
        	"</TABLE>" +
        	"</br>" +
       	"<br>" +
        	"Please find the Attahed report.</br><br/>" +
        	"<br>Thanks</br>" +
       	"<br>Sandesh</br>" +
    		"</html></body>" ,"text/html");
    
    //4) create new MimeBodyPart object and set DataHandler object to this object    
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();

    String filename = "C:\\Nano\\galaxy\\target\\surefire-reports\\emailable-report.html";//change accordingly
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName(filename);
   
   
    //5) create Multipart object and add MimeBodyPart objects to this object    
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart );
   
    //7) send message
    Transport.send(message);
 
   System.out.println("message sent....");
   }catch (MessagingException ex) {ex.printStackTrace();}
 }
}
