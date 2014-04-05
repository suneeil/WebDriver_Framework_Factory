package yahoo.toolbar.webDriver.apps.youTube;

import java.io.File;
import java.util.Map;

import yahoo.toolbar.webDriver.util.CommonLibrary;
import static yahoo.toolbar.webDriver.util.Config.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * 
 * Test class for Youtube App 
 * 
 * @author asingla
 *
**/
public class YouTube extends CommonLibrary
{
	
	/**
	 * 
	 * YouTube constructor used by factory class to create intl specific Test classes
	 *
	**/
	public YouTube(String intl)
	{
		//initialize intl 
		this.intl=intl;
		//fetch intl specific strings from excel
		data=readExcel(intl,"YouTube",0);
		//create URL
		URL="http://fe1.dev-qa.toolbar.bf1.yahoo.com/bh/ytmodule?.intl="+intl+"&.pc=&.ver=9_0_0&.ysoid=@oa_visi_youtube"; 
		//initialize expected header status message  
//		headerStatus[0]=data.get("First Page");
//		headerStatus[1]=data.get("Second Page");
//		headerStatus[2]=data.get("Third Page");
//		headerStatus[3]=data.get("Fourth Page");
//		headerStatus[4]=data.get("Fifth Page");
//		headerStatus[5]=data.get("Sixth Page");	
		
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
	private String[] headerStatus=new String[6];
	//URL to test
	private String URL;
	
	
	/**
	 * 
	 * Config method declaration section
	 * 
	**/
	
	
	/**
	 * 
	 * Common methods for youtube
	 * 
	**/
	
	
	
	/**
	 * 
	 * method to verify header of youtube app
	 * @currentTab=expected current tab, if null no tab selected
	 * @statusText=expected status text to be present in Header
	 * @displayBack= whether to show Back button or not
	**/
	private void verifyHeader(String currentTab,String statusText,boolean displayBack)
	{
		//verify Featured tab is present
	
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","Featured","featured"))),"("+intl+")"+"Featured tab is not present");
		//verify expected text is present for Featured tab
		Assert.assertTrue(driver.findElementByXPath(getPath("YouTube","Featured","featured")).getText().equals(data.get("Featured Tab")),"("+intl+")"+"Text :"+data.get("Featured Tab")+ "not present");
		//verify Most Viewed tab is present
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","MostViewed","mostViewed"))),"("+intl+")"+"'Most Viewed' tab is not present");
		//verify expected text is present for Most Viewed tab
		Assert.assertTrue(driver.findElementByXPath(getPath("YouTube","MostViewed","mostViewed")).getText().equals(data.get("Most Viewed Tab")),"("+intl+")"+"Text :"+data.get("Most Viewed Tab")+ "not present");
		//verify Top Rated tab is present
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","TopRated","topRated"))),"("+intl+")"+"'Top Rated' tab is not present");
//		//verify expected text is present for Top Rated tab
		Assert.assertTrue(driver.findElementByXPath(getPath("YouTube","TopRated","topRated")).getText().equals(data.get("Top Rated Tab")),"("+intl+")"+"Text :"+data.get("Top Rated Tab")+ "not present");
//		//verify Discussed tab is present
//		Assert.assertTrue(isElementPresent(By.id(getPath("YouTube","Discussed","discussed"))),"("+intl+")"+"Discussed tab is not present");
//		//verify expected text is present for Discussed tab
//		Assert.assertTrue(driver.findElementById(getPath("YouTube","Discussed","discussed")).getText().equals(data.get("Discussed Tab")),"("+intl+")"+"Text :"+data.get("Discussed Tab")+ "not present");
//		//verify Search tab is present
//		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","SearchBox","searchBox"))),"("+intl+")"+"Search tab is not present");
//		//verify search box is present
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","InputSearch","search"))),"("+intl+")"+"Search box is not present");
		//verify search button is present
	//	Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","SearchButton","button"))),"("+intl+")"+"Search button is not present");
//		//if currentTab is not null
//		if(currentTab !=null)
//		{
//			//verify current tab
//			Assert.assertTrue(driver.findElementByXPath((getPath("YouTube","CurrentTab","currentTab"))).getText().equals(currentTab),"("+intl+")"+currentTab+" not the selected tab");
//		}
//		//verify no current tab
//		else if(isElementPresent(By.xpath(getPath("YouTube","CurrentTab","currentTab"))))
//		{
//			//test case fails
//			Assert.assertTrue(false,"("+intl+")"+"Expected no selected tab but getting selected tab: "+driver.findElementByXPath((getPath("YouTube","CurrentTab","currentTab"))).getText());
//			
//		}
//		//verify text element is present
//		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","LeftStatus","leftStatus"))),"("+intl+")"+"Element representing status message not present");
////		//verify statusText is present
//		Assert.assertTrue(driver.findElementByXPath((getPath("YouTube","LeftStatus","leftStatus"))).getText().equals(statusText),"("+intl+")"+"Text message '"+statusText+"' not present");
////		//if @displayBack is true
//		if(displayBack)
//		{
////			//verify text 'Back' is visible
//			Assert.assertTrue(driver.findElementByXPath((getPath("YouTube","RightStatus","rightStatus"))).isDisplayed(),"("+intl+")"+"Text 'Back' is hidden in Tab view");
////			//verify Text of Back link
//			Assert.assertTrue(driver.findElementByXPath(getPath("YouTube","RightStatus","rightStatus")).getText().equals(data.get("Back Link")),"("+intl+")"+"Text :"+data.get("Back Link")+ "not present");
//		}
//		else
//		{
//			//verify text 'Back' is hidden
//			Assert.assertFalse(driver.findElementByXPath((getPath("YouTube","RightStatus","rightStatus"))).isDisplayed(),"("+intl+")"+"Text 'Back' is visible in Tab view");
//		}
	}
	
	/**
	 * 
	 *method to verify content section of youtube app 
	 *@startVideo= verify videos from this number are present
	 *@endVideo= verify videos till this number are present
	**/
	private void verifyContent(int startVideo,int endVideo)
	{
		String videoStartPath=null;
		
		//verify video container is there
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","VideoContainer","videoContainer"))),"("+intl+")"+"Video container is not present");
		//verify videos are present
		for(int i=startVideo;i<=endVideo;i++)
		{
			//verify video is present
			Assert.assertTrue(driver.findElementByXPath((getPath("YouTube","Video","video")+i+"]")).isDisplayed(),"("+intl+")"+"Video is not present , number :"+i);
			videoStartPath=(getPath("YouTube","VideoStartPath","videoStartPath")+i);
			//verify video duration is present
			Assert.assertTrue(driver.findElementByXPath(videoStartPath+getPath("YouTube","VideoDuration","videoDuration")).getText().matches(".*:.*"),"("+intl+")"+"Video duration is not present for video, number :"+i);
			//verify video title is present
			Assert.assertFalse(driver.findElementByXPath(videoStartPath+getPath("YouTube","VideoTitle","videoTitle")).getText().isEmpty(),"("+intl+")"+"Video title is not present for video, number :"+i);
			//System.out.println(driver.findElementByXPath(videoStartPath+getPath("YouTube","VideoDetails","videoDetails")).getText());
			//verify video details is present
			Assert.assertFalse(driver.findElementByXPath(videoStartPath+getPath("YouTube","VideoDetails","videoDetails")).getText().isEmpty(),"("+intl+")"+"Video details is not present for video, number :"+i);
		}
		
		//verify video followed endVideo is not visible
		if(isElementPresent(By.xpath(getPath("YouTube","Video","video")+endVideo+1+"]")))
		{
			Assert.assertFalse(driver.findElementByXPath((getPath("YouTube","Video","video")+endVideo+1+"]")).isDisplayed(),"("+intl+")"+"Getting video beyond endVideo,number :"+endVideo+1);
		}
	}
	
	/**
	 * 
	 * method to verify footer of youtube app
	 * @selectedPage=verify given page is the selected one
	 * @prevDisable=whether  link should be disable or not
	 * @nextDisable=whether next link should be disable or not
	**/
	private void verifyFooter(String selectedPage,boolean prevDisable,boolean nextDisable)
	{
		//if previous link should be disable
		if(prevDisable)
		{
			//verify Previous link is disabled
			Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","PreviousLinkDisabled","previousDisabled"))),"("+intl+")"+"Previous link is enabled for page:"+selectedPage);
		}
		else
		{
			//verify Previous link is enabled
			Assert.assertFalse(isElementPresent(By.xpath(getPath("YouTube","PreviousLinkDisabled","previousDisabled"))),"("+intl+")"+"Previous link is disabled for page:"+selectedPage);
			//verify Text of Previous link
			Assert.assertTrue(driver.findElementByXPath(getPath("YouTube","PreviousLink","previous")).getText().equals(data.get("Prev Link")),"("+intl+")"+"Text :"+data.get("Prev Link")+ "not present");
		}
		
		//verify selectedPage is selected
		Assert.assertTrue(driver.findElementByXPath(getPath("YouTube","CurrentPage","currentPage")).getText().equals(selectedPage),"("+intl+")"+selectedPage+" is not the selected page");
		//verify total 8 links are present
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","Pagination","pagination")+"4]")),"("+intl+")"+"Total 4 links are not present in footer for page:"+selectedPage);
		
		//if Next link should be disabled
		if(nextDisable)
		{
			//verify Next link is disabled
			Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","NextLinkDisabled","nextDisabled"))),"("+intl+")"+"Next link is enabled for page:"+selectedPage);
		}
		else
		{
			//verify Next link is enabled
			Assert.assertFalse(isElementPresent(By.xpath(getPath("YouTube","NextLinkDisabled","nextDisabled"))),"("+intl+")"+"Previous link is disabled for page:"+selectedPage);
			//verify Text of Next link
			Assert.assertTrue(driver.findElementByXPath(getPath("YouTube","NextLink","next")).getText().equals(data.get("Next Link")),"("+intl+")"+"Text :"+data.get("Next Link")+ "not present");
		}
		
	}
	
	/**
	 * method to verify clicking on Next/pagination link 
	 * @currentTab=expected current tab 
	 * @pagination=if want to use pagination feature
	**/
	private void verifyNextLink(String currentTab,boolean pagination)
	{
		int cond=0;
		//loop through all the pages
		//Earlier it was 6 changed to 3 to maintain the pagination [@sandesh]
		for(int i=0;i<3;i++)
		{
			verifyHeader(currentTab,headerStatus[i],false);
			verifyContent(1+9*i,(9*(i+1))<50?(9*(i+1)):50);
			verifyFooter(new Integer(i+1).toString(),i==0?true:false,i==5?true:false);
			
			//at last page don't click on Next/pagination link
			if(i!=5)
			{
				//if want to navigate through clicking on page(1,2...) link
				if(pagination)
				{
					driver.findElementByXPath(getPath("YouTube","Pagination","pagination")+(i+3)+"]").click();
				}
				//click on Next link
				else
				{
					driver.findElementByXPath(getPath("YouTube","NextLink","next")).click();
				}
				//sleep(2000);
			}
		}
		
	}
	
	/**
	 * 
	 * method to verify Previous link
	 * @currentTab=expected current tab
	 * 
	**/
	private void verifyPreviousLink(String currentTab)
	{
		//first go to last page
		driver.findElementByXPath(getPath("YouTube","Pagination","pagination")+"3]").click();//it was 7
		//sleep(2000);
		
		//loop through all the pages
		//it was 5
		for(int i=4;i>=0;i--)
		{
			verifyHeader(currentTab,headerStatus[i],false);
			verifyContent(1+(9*i),(9*(i+1))<50?(9*(i+1)):50);
			verifyFooter(new Integer(i+1).toString(),i==0?true:false,i==5?true:false);
			
			//at first page don't click on Previous link
			if(i!=0)
			{
				driver.findElementByXPath(getPath("YouTube","PreviousLink","previous")).click();
				//sleep(2000);
			}
		}
	}
	
	/**
	 * 
	 * method for navigate to youtube app and click on tab
	 * @tab=tab number to be click , if 0 don't click
	**/
	private void navigateAndClick(int tab)
	{
		driver.get(URL);
		if(tab!=0)
		{
			driver.findElementByXPath(getPath("YouTube","Tab","tab")+tab+"]").click();
			//sleep(2000);
		}
	}
	
	/**
	 * 
	 * method to search from search box
	 * @searchQuery= query to search
	**/
	private void search(String searchQuery)
	{
		//navigate to youtube app
		driver.get(URL);
		////sleep(2000);
		//enter query
		driver.findElementByXPath(getPath("YouTube","InputSearch","search")).clear();
		driver.findElementByXPath(getPath("YouTube","InputSearch","search")).sendKeys(searchQuery);
		//search for query
		driver.findElementByXPath(getPath("YouTube","SearchButton","button")).click();
		//sleep(2000);
		
	}
	
	/**
	 * 
	 *  method to verify default UI
	 *  @tabNumer=tab number, if 0 then default tab
	 *  @tabName=name of tab
	 *  @search=whether to search or not
	 *  @searchQuery=query to search for
	**/
	private void verifyUI(int tabNumber, String tabName, boolean search,String searchQuery)
	{
		//if need to search
		if(search)
		{
			search(searchQuery);
		}
		else
		{
			//navigate to youtube app
			navigateAndClick(tabNumber);
		}
		//verify correct tab get selected and correct status message
		verifyHeader(tabName,headerStatus[0],false);
		//verify 9 videos are displayed
		verifyContent(1,9);
		//verify 1st page is selected in footer
		verifyFooter("1",true,false);
	}
	
	/**
	 * 
	 * method to verify next/pagination link  
	 * @tabNumber= tab number
	 * @tabName= expected tab name
	 * @pagination= whether to use pagination or not
	 * @search= whether to search or not
	 * @searchQuery=query to use for search
	**/
	private void clickAndVerifyNextLink(int tabNumber,String tabName,boolean pagination,boolean search,String searchQuery)
	{
		//if using search
		if(search)
		{
			search(searchQuery);
		}
		else
		{
			//navigate to youtube app and click on tab
			navigateAndClick(tabNumber);
		}
		//verify Next Link
		verifyNextLink(tabName,pagination);
	}
	
	/**
	 * 
	 * method to verify previous link  
	 * @tabNumber= tab number
	 * @tabName= expected tab name
	 * @search= whether to search or not
	 * @searchQuery=query to use for search
	**/
	private void clickAndVerifyPreviousLink(int tabNumber,String tabName,boolean search,String searchQuery)
	{
		//if using search
		if(search)
		{
			search(searchQuery);
		}
		else
		{
			//navigate to youtube app and click on tab
			navigateAndClick(tabNumber);
		}
		//verify previous Link
		verifyPreviousLink(tabName);
	}
	
	/**
	 * 	method to click on video
	 * 	@tabNumber=tab number
	 * 	@pageNumber=page number, if 0 then default page
	 * 	@videoNumer= video to be clicked
	 * 	@search=whether to search or not
	 * 	@searchQuery=query to be search
	**/
	private String clickVideo(int tabNumber,int pageNumber,int videoNumber,boolean search,String searchQuery)
	{
		String videoTitle=null;
		
		//if using search
		if(search)
		{
			search(searchQuery);
		}
		else
		{
			//navigate to youtube app and click on tab
			navigateAndClick(tabNumber);
		}
		
		//navigate to page if @pageNumber !=0
		if(pageNumber!=0)
		{
			driver.findElementByXPath(getPath("YouTube","Pagination","pagination")+(pageNumber+1)+"]").click();
			//sleep(2000);
		}
		videoNumber=(pageNumber==0 || pageNumber==1)?videoNumber:(videoNumber+((pageNumber-1)*9));
		//wait for video title to be present
		waitForElementPresent(By.xpath(getPath("YouTube","VideoStartPath","videoStartPath")+videoNumber+getPath("YouTube","VideoTitle","videoTitle")),5000);
		//fetch video title
		videoTitle=driver.findElementByXPath(getPath("YouTube","VideoStartPath","videoStartPath")+videoNumber+getPath("YouTube","VideoTitle","videoTitle")).getText();
		//click on video
		driver.findElementByXPath(getPath("YouTube","Video","video")+videoNumber+"]").click();
		//sleep(2000);
		return videoTitle;
	}
	
	
	/**
	 *	method to click on video and verify result page
	 * 	@tabNumber=tab number
	 * 	@pageNumber=page number, if 0 then default page
	 * 	@videoNumer= video to be clicked
	 * 	@search=whether to search or not
	 * 	@searchQuery=query to be search
	**/
	private void clickVideoAndVerifyVideoPage(int tabNumber,int pageNumber,int videoNumber,boolean search,String searchQuery)
	{
		
		//verify video page
		verifyVideoPage(clickVideo(tabNumber,pageNumber,videoNumber,search,searchQuery),pageNumber,videoNumber);
	}
	
	/**
	 * method to verify Back button video page 
	 * @tabName=name of the tab
	 * @tabNumber=tab number
	 * @pageNumber=page number, if 0 then default page
	 * @videoNumer= video to be clicked
	 * @search=whether to search or not
	 * @searchQuery=query to be search
	**/
	public void clickVideoAndVerifyBackButton(String tabName,int tabNumber,int pageNumber,int videoNumber,boolean search,String searchQuery)
	{
		//click video
		clickVideo(tabNumber,pageNumber,videoNumber,search,searchQuery);
		//click on Back button
		driver.findElementByXPath(getPath("YouTube","Back","back")).click();
		//sleep(2000);
		//verify navigated to correct page
		verifyHeader(tabName,pageNumber==0?headerStatus[0]:headerStatus[pageNumber-1],false);
		//verify 9 videos are displayed
		verifyContent((pageNumber==0 || pageNumber==1)?1:(9*(pageNumber-1)+1),(pageNumber==0 || pageNumber==1)?9:(pageNumber==6?50:pageNumber*9));
		//verify page is selected in footer
		verifyFooter(new Integer(pageNumber).toString(),(pageNumber==0 || pageNumber==1)?true:false,pageNumber==6?true:false);
	}
	
	/**
	 * @tabNumber=tab number
	 * @pageNumber=page number, if 0 then default page
	 * @videoNumer= video to be clicked
	 * @carouselVideoNumber= carousel video to be clicked
	 * @search=whether to search or not
	 * @searchQuery=query to be search
	 * 
	**/
	public void clickCarouselVideoAndVerify(int tabNumber,int pageNumber,int videoNumber,int carouselVideoNumber,boolean search,String searchQuery)
	{
		//click video
		clickVideo(tabNumber,pageNumber,videoNumber,search,searchQuery);
		//first fetch title of the carousel video to be clicked
		String videoTitlePath=getPath("YouTube","RelatedVideoStartPath","relatedVideoStartPath")+carouselVideoNumber+getPath("YouTube","VideoTitle","videoTitle");
		String videoTitle=driver.findElementByXPath(videoTitlePath).getText();
		//click on video and verify video page
		driver.findElementByXPath(getPath("YouTube","RelatedVideoStartPath","relatedVideoStartPath")+carouselVideoNumber+"]").click();
		sleep(2000);
		//verify video page
		verifyVideoPage(videoTitle,pageNumber,videoNumber);
				
	}
	
	/**
	 * 
	 * method to verify video page
	 * 
	 * @videoTitle=expected header status
	 * @pageNumber=page number
	 * @videoNumer= clicked video number
	 * 
	 * 
	**/
	private void verifyVideoPage(String videoTitle,int pageNumber,int videoNumber)
	{
		//verify Header on video page
		verifyHeader(null,videoTitle,true);
		//wait for video to be present
		waitForElementPresent(By.xpath(getPath("YouTube","VideoFrame","videoFrame")),5000);
		//verify video is present
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","VideoFrame","videoFrame"))),"("+intl+")"+"Video player didn't show up: Page number :"+pageNumber+" Video Number :"+videoNumber);
		//verifyCarousel(pageNumber,videoNumber);	
	}
	
	/**
	 *	method to verify carousel
	 *	@pageNumber=page number, if 0 then default page
	 * 	@videoNumer= video to be clicked
	**/
	private void verifyCarousel(int pageNumber,int videoNumber)
	{

		int totalNumberOfVideos=0;
		int i=1;
		int numberOfPages=0;
		
		//wait for carousel to be present
		waitForElementPresent(By.xpath(getPath("YouTube","Carousel","carousel")),5000);
		//verify carousel is present
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","Carousel","carousel"))),"("+intl+")"+"Related videos didn't show up: Page number :"+pageNumber+" Video Number :"+videoNumber);
		//verify carousel previous link is present in disabled form by default
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","CarouselPreviousDisabled","prevDisabled"))),"("+intl+")"+"Carousel previous link(disabled) didn't show up: Page number :"+pageNumber+" Video Number :"+videoNumber);
		//verfiy carousel next link is present
		Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","CarouselNext","carouselNext"))),"("+intl+")"+"Carousel next link didn't show up: Page number :"+pageNumber+" Video Number :"+videoNumber);
		
		//fetch total number of videos
		while(isElementPresent(By.xpath(getPath("YouTube","RelatedVideoStartPath","relatedVideoStartPath")+i+"]")))
		{
			totalNumberOfVideos=i;
			i++;
		}
		//calculate number of pages
		numberOfPages=(totalNumberOfVideos%3)==0?(totalNumberOfVideos/3):(totalNumberOfVideos/3)+1;
		i=1;
		//click on carousel next link and verify
		while(i<=numberOfPages)
		{
			//verify videos
			verifyCarouselContent(3*(i-1)+1,(3*i)<=totalNumberOfVideos?(3*i):totalNumberOfVideos,pageNumber,videoNumber);
			//if reached at last page verify next link is disabled
			if(i==numberOfPages)
			{
				//verify next link disabled
				Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","CarouselNextDisabled","nextDisabled"))),"("+intl+")"+"Carousel next link(disabled) is not present in last set: Page number :"+pageNumber+" Video Number :"+videoNumber);
			}
			else
			{
				//click on next link
				driver.findElementByXPath(getPath("YouTube","CarouselNext","carouselNext")).click();
				//sleep(1000);
			}
			i++;
		}
		
		//now click on carousel previous link and verify
		i=numberOfPages;
		while(i>=1)
		{
			//verify videos
			verifyCarouselContent(3*(i-1)+1,(3*i)<=totalNumberOfVideos?(3*i):totalNumberOfVideos,pageNumber,videoNumber);
			//if reached at first page verify prev link is disabled
			if(i==1)
			{
				//verify prev link disabled
				Assert.assertTrue(isElementPresent(By.xpath(getPath("YouTube","CarouselPreviousDisabled","prevDisabled"))),"("+intl+")"+"Carousel previous link(disabled) didn't show up: Page number :"+pageNumber+" Video Number :"+videoNumber);
			}
			else
			{
				//click on prev link
				driver.findElementByXPath(getPath("YouTube","CarouselPrevious","carouselPrevious")).click();
				//sleep(1000);
			}
			i--;
		}
	}
	
	/**
	 *	method to verify carousel content
	 *  @startVideo= verify videos from this number are present
	 *	@endVideo= verify videos till this number are present
	 *	@pageNumber=page number, if 0 then default page
	 * 	@videoNumer= video to be clicked
	**/
	private void verifyCarouselContent(int startVideo,int endVideo,int pageNumber,int videoNumber)
	{
		String videoStartPath=null;
		
		//verify videos are present
		for(int i=startVideo;i<=endVideo;i++)
		{
			//wait for carousel video to present
			waitForElementPresent(By.xpath((getPath("YouTube","RelatedVideo","relatedVideo")+i+"]")),5000);
			//verify video is present
			Assert.assertTrue(driver.findElementByXPath((getPath("YouTube","RelatedVideo","relatedVideo")+i+"]")).isDisplayed(),"("+intl+")"+"Carousel video is not present , number :"+i+" //Page number :"+pageNumber+" Video Number :"+videoNumber);
			videoStartPath=(getPath("YouTube","RelatedVideoStartPath","relatedVideoStartPath")+i);
			//wait for video duration to present
			waitForElementPresent(By.xpath(videoStartPath+getPath("YouTube","VideoDuration","videoDuration")),5000);
			//verify video duration is present
			Assert.assertTrue(driver.findElementByXPath(videoStartPath+getPath("YouTube","VideoDuration","videoDuration")).getText().matches(".*:.*"),"("+intl+")"+"Video duration is not present for carousel video, number :"+i+" //Page number :"+pageNumber+" Video Number :"+videoNumber);
			//verify video title is present
			Assert.assertFalse(driver.findElementByXPath(videoStartPath+getPath("YouTube","VideoTitle","videoTitle")).getText().isEmpty(),"("+intl+")"+"Video title is not present for carousel video, number :"+i+" //Page number :"+pageNumber+" Video Number :"+videoNumber);
			System.out.println(driver.findElementByXPath(videoStartPath+getPath("YouTube","VideoDetails","videoDetails")).getText());
			//verify video details is present
			Assert.assertFalse(driver.findElementByXPath(videoStartPath+getPath("YouTube","VideoDetails","videoDetails")).getText().isEmpty(),"("+intl+")"+"Video details is not present for carousel video, number :"+i+" //Page number :"+pageNumber+" Video Number :"+videoNumber);
		}
		
		//verify video followed endVideo is not visible
		if(isElementPresent(By.xpath(getPath("YouTube","Video","video")+endVideo+1+"]")))
		{
			Assert.assertFalse(driver.findElementByXPath((getPath("YouTube","Video","video")+endVideo+1+"]")).isDisplayed(),"("+intl+")"+"Getting video beyond endVideo,number :"+endVideo+1+" //Page number :"+pageNumber+" Video Number :"+videoNumber);
		}
	}
	
	/**
	 * 
	 * Test methods declaration section
	 * 
	**/
	
	
	
	/**
	 * 
	 * test to verify default UI 
	 * 
	**/
	@Test(groups={"Smoke"})
	public void defaultUI()
	{
		verifyUI(0,data.get("Featured Tab"),false,null);
	}
	
	
	/**
	 * 
	 * test to verify Featured Tab 
	 * 
	**/
	@Test(groups={"Smoke098","Functional","Regression"})
	public void featuredTabUI()
	{
		verifyUI(1,data.get("Featured Tab"),false,null);
	}
	
	
	/**
	 * 
	 * test to verify Most Viewed Tab 
	 * 
	**/
	@Test(groups={"Smoke"})
	public void mostViewedTabUI()
	{
		verifyUI(2,data.get("Most Viewed Tab"),false,null);
	}
	
	/**
	 * 
	 * test to verify Top Rated Tab 
	 * 
	**/
	@Test(groups={"Smoke"})
	public void mostRatedTabUI()
	{
		verifyUI(3,data.get("Top Rated Tab"),false,null);
	}
	
	/**
	 * 
	 * test to verify Discussed Tab 
	 * 
	**/
	@Test(groups={"Smokediscussed","Functional","Regression"})
	public void discussedTabUI()
	{
		verifyUI(4,data.get("Discussed Tab"),false,null);
	}
	
	/**
	 * 
	 * test to verify search UI
	 * 
	**/
	@Test(groups={"Smoke"})
	public void searchUI()
	{
		verifyUI(0,null,true,data.get("Search Query"));
	}
	
	/**
	 * 
	 * test to verify next link on Featured tab
	 * 
	**/
	@Test(groups={"Regression"})
	public void nextLinkFeaturedTab()
	{
		clickAndVerifyNextLink(0,data.get("Featured Tab"),false,false,null);
	}
	
	/**
	 * 
	 * test to verify next link on Most Viewed tab
	 * 
	**/
	@Test(groups={"Regression"})
	public void nextLinkMostViewedTab()
	{
		clickAndVerifyNextLink(2,data.get("Most Viewed Tab"),false,false,null);
	}
	
	/**
	 * 
	 * test to verify next link on Top Rated tab
	 * 
	**/
	@Test(groups={"Regression"})
	public void nextLinkTopRatedTab()
	{
		clickAndVerifyNextLink(3,data.get("Top Rated Tab"),false,false,null);
	}
	
	/**
	 * 
	 * test to verify next link on Discussed tab
	 * Discussed tab is remvoed so removing this from the list
	**/
	@Test(groups={"Smokedisccussed","Functional","Regression"})
	public void nextLinkDiscussedTab()
	{
		clickAndVerifyNextLink(4,data.get("Discussed Tab"),false,false,null);
	}
	
	/**
	 * 
	 * test to verify next link on Search tab
	 * 
	**/
	@Test(groups={"Smokesearchtab","Functional","Regression"})
	public void nextLinkSearchTab()
	{
		clickAndVerifyNextLink(0,null,false,true,data.get("Search Query"));
	}
	
	/**
	 * 
	 * test to verify pagination on Featured tab
	 * 
	**/
	@Test(groups={"Smoke"})
	public void paginationFeaturedTab()
	{
		clickAndVerifyNextLink(0,data.get("Featured Tab"),true,false,null);
	}
	
	/**
	 * 
	 * test to verify pagination on Most Viewed tab
	 * 
	**/
	@Test(groups={"Regression"})
	public void paginationMostViewedTab()
	{
		clickAndVerifyNextLink(2,data.get("Most Viewed Tab"),true,false,null);
	}
	
	/**
	 * 
	 * test to verify pagination on Top Rated tab
	 * 
	**/
	@Test(groups={"Regression"})
	public void paginationTopRatedTab()
	{
		clickAndVerifyNextLink(3,data.get("Top Rated Tab"),true,false,null);
	}
	
	/**
	 * 
	 * test to verify pagination on Discussed tab
	 * Discussed Tab is disabled : @sandesh
	**/
	@Test(groups={"Smokediscussed","Functional","Regression"})
	public void paginationDiscussedTab()
	{
		clickAndVerifyNextLink(4,data.get("Discussed Tab"),true,false,null);
	}
	
	/**
	 * 
	 * test to verify pagination on Search tab
	 * Search Tab is disabled
	**/
	@Test(groups={"Smokesearchtab","Functional","Regression"})
	public void paginationSearchTab()
	{
		clickAndVerifyNextLink(0,null,true,true,data.get("Search Query"));
	}
	
	/**
	 * 
	 * test to verify previous link on Featured tab
	 * 
	**/
	@Test(groups={"","Functional","Regression"})
	public void previousLinkFeaturedTab()
	{
		clickAndVerifyPreviousLink(0,data.get("Featured Tab"),false,null);
	}
	
	/**
	 * 
	 * test to verify previous link on Most Viewed tab
	 * 
	**/
	@Test(groups={"","Functional","Regression"})
	public void previousLinkMostViewedTab()
	{
		clickAndVerifyPreviousLink(1,data.get("Most Viewed Tab"),false,null);
	}
	
	/**
	 * 
	 * test to verify previous link on Top Rated tab
	 * 
	**/
	@Test(groups={"","Functional","Regression"})
	public void previousLinkTopRatedTab()
	{
		clickAndVerifyPreviousLink(2,data.get("Top Rated Tab"),false,null);
	}
	
	/**
	 * 
	 * test to verify previous link on Discussed tab
	 * 
	**/
	@Test(groups={"SmokeIgnore","Functional","Regression"})
	public void previousLinkDiscussedTab()
	{
		clickAndVerifyPreviousLink(4,data.get("Discussed Tab"),false,null);
	}
	
	/**
	 * 
	 * test to verify previous link on Search tab
	 * 
	**/
	@Test(groups={"SmokeIgnoer","Functional","Regression"})
	public void previousLinkSearchTab()
	{
		clickAndVerifyPreviousLink(0,null,true,data.get("Search Query"));
	}
	
	/**
	 * 
	 * test to verify video page by clicking on video from Featured tab 
	 * 
	**/
	@Test(groups={"Smoke","Functional","Regression"})
	public void verifyVideoPageFeaturedTab()
	{
		clickVideoAndVerifyVideoPage(0,0,1,false,null);
	}
	
	/**
	 * 
	 * test to verify video page by clicking on video from Most Viewed tab 
	 * 
	**/
	@Test(groups={"Smoke"})
	public void verifyVideoPageMostViewedTab()
	{
		clickVideoAndVerifyVideoPage(2,2,8,false,null);
	}
	
	/**
	 * 
	 * test to verify video page by clicking on video from Top Rated tab 
	 * 
	**/
	@Test(groups={"Smoke"})
	public void verifyVideoPageTopRatedTab()
	{
		clickVideoAndVerifyVideoPage(3,2,8,false,null);
	}
	
	/**
	 * 
	 * test to verify video page by clicking on video from Discussed tab 
	 * 
	**/
	@Test(groups={"SmokeIgnored","Functional","Regression"})
	public void verifyVideoPageDiscussedTab()
	{
		clickVideoAndVerifyVideoPage(4,6,5,false,null);
	}
	
	/**
	 * 
	 * test to verify video page by clicking on video from search page
	 * 
	**/
	@Test(groups={"SmokeIgnored","Functional","Regression"})
	public void verifyVideoPageSearchPage()
	{
		clickVideoAndVerifyVideoPage(0,3,7,true,data.get("Search Query"));
	}
	
	/**
	 * 
	 * test to verify back button when clicked on video from Featured tab
	 * 
	**/
	@Test(groups={"","Functional","Regression"})
	public void verifyBackFeaturedTab()
	{
		clickVideoAndVerifyBackButton(data.get("Featured Tab"),0,1,1,false,null);
	}
	
	/**
	 * 
	 * test to verify back button when clicked on video from Most Viewed tab
	 * 
	**/
	@Test(groups={"","Functional","Regression"})
	public void verifyBackMostViewedTab()
	{
		clickVideoAndVerifyBackButton(data.get("Most Viewed Tab"),2,5,4,false,null);
	}
	
	/**
	 * 
	 * test to verify back button when clicked on video from Top Rated tab
	 * 
	**/
	@Test(groups={"","Functional","Regression"})
	public void verifyBackTopRatedTab()
	{
		clickVideoAndVerifyBackButton(data.get("Top Rated Tab"),3,4,9,false,null);
	}
	
	/**
	 * 
	 * test to verify back button when clicked on video from Discussed tab
	 * 
	**/
	@Test(groups={"","Functional","Regression"})
	public void verifyBackDiscussedTab()
	{
		clickVideoAndVerifyBackButton(data.get("Discussed Tab"),4,2,7,false,null);
	}
	
	/**
	 * 
	 * test to verify back button when clicked on video from Search page
	 * 
	**/
	@Test(groups={"SmokeIgnored","Functional","Regression"})
	public void verifyBackSearchPage()
	{
		clickVideoAndVerifyBackButton(null,0,6,3,true,data.get("Search Query"));
	}
	
	/**
	 * 
	 * click on carousel video by navigating to video page from Featured tab
	 * 
	**/
	@Test(groups={"Regression"})
	public void verifyCarouselVideoFeatureTab()
	{
		clickCarouselVideoAndVerify(0,0,5,1,false,null);
	}
	
	/**
	 * 
	 * click on carousel video by navigating to video page from Most Viewed tab
	 * 
	**/
	@Test(groups={"Regression"})
	public void verifyCarouselVideoMostViewedTab()
	{
		clickCarouselVideoAndVerify(2,2,1,3,false,null);
	}
	
	/**
	 * 
	 * click on carousel video by navigating to video page from Top Rated tab
	 * 
	**/
	@Test(groups={"","Functional","Regression"})
	public void verifyCarouselVideoTopRatedTab()
	{
		clickCarouselVideoAndVerify(3,5,1,3,false,null);
	}
	
	/**
	 * 
	 * click on carousel video by navigating to video page from Discussed tab
	 * 
	**/
	@Test(groups={"SmokeIgnored","Functional","Regression"})
	public void verifyCarouselVideoDiscussedTab()
	{
		clickCarouselVideoAndVerify(4,6,5,3,false,null);
	}
	
	/**
	 * 
	 * click on carousel video by navigating to video page from Search page
	 * 
	**/
	@Test(groups={"SmokeIgnored","Functional","Regression"})
	public void verifyCarouselVideoSearchPage()
	{
		clickCarouselVideoAndVerify(0,3,9,2,true,data.get("Search Query"));
	}
}
