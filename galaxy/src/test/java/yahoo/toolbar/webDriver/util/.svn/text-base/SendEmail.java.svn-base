
package yahoo.toolbar.webDriver.util;

import java.io.File;
import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.io.File; 

import javax.mail.Message;
import javax.mail.MessagingException;
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


/**
 * Class used to send email after test suite execution , implements IReporter interface
 * @author asingla
 **/

public class SendEmail extends CommonLibrary implements IReporter 
{
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
	
	 
	
	/**
	 * 
	 *Method to send email
	 */
	private void sendEmail()
	{
		//define @to,@from,@host,@totalTestCases
		int totalTestCases=passedTestCases+failedTestCases+skippedTestCases;
		String to = "toolbar-eng@yahoo-inc.com";
		String from = "GalaxyAutomation@yahoo-inc.com";
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
	        message.setSubject("Galaxy Automation report");
	        //actual message
	        message.setContent(
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
	        	"Please find the detailed report <a href='http://aq-tools2.ysm.corp.sp2.yahoo.com//toolbarautomation//Galaxy//emailable-report.html'>Click</a></br><br/>" +
	        	"<br>Thanks</br>" +
	        	"<br>Sandesh</br>" +
	    		"</html></body>" ,"text/html");
	        
	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	         
	         /**
	    	 *
	    	 * config method to Move the report after test suite run 
	    	 * 
	    	 **/
	    	
	    	
	    	    	
	    	    	try{
	    	    		
	    	    		
	    	    		 File file = new File("C:\\xampp\\htdocs\\toolbarautomation\\Galaxy\\");        
	    	    	        String[] myFiles;      
	    	    	            if(file.isDirectory()){  
	    	    	                myFiles = file.list();  
	    	    	                for (int i=0; i<myFiles.length; i++) {  
	    	    	                    File myFile = new File(file, myFiles[i]);   
	    	    	                    myFile.delete();  
	    	    	                }  
	    	    	             }  
	    	 
	    	    	   File afile =new File("C:\\Nano\\galaxy\\target\\surefire-reports\\emailable-report.html");
	    	    	  // java.util.Date date= new java.util.Date();
	    	    		// System.out.println(new Timestamp(date.getTime()));
	    	    	   
	    	    	   if(afile.renameTo(new File("C:\\xampp\\htdocs\\toolbarautomation\\Galaxy\\" + afile.getName()))){
	    	    		System.out.println("File is moved successful!");
	    	    	   }else{
	    	    		System.out.println("File is failed to move!");
	    	    	   }
	    	 
	    	    	}catch(Exception e){
	    	    		e.printStackTrace();
	    	    	}
	    	    }
	    
		catch (MessagingException mex) 
		{
			mex.printStackTrace();
		}
	}
}
