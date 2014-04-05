package yahoo.toolbar.webDriver.util;

import yahoo.toolbar.webDriver.apps.Bookmarks.Bookmarks;
import yahoo.toolbar.webDriver.apps.Weather.Weather;
import yahoo.toolbar.webDriver.apps.facebook.Facebook;
//import yahoo.toolbar.webDriver.apps.youTube.YouTube;
import yahoo.toolbar.webDriver.buttonGallery.Gallery;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Factory;

/**
 * 
 * Factory class use to create Test classes for all
 * the intls specific in XML file 
 * @author asingla
 *
 */

public class WebFactory extends CommonLibrary{
	
	@Factory
	public Object[] createTestInstances()
	{
		//fetch all the intls
		String[] intlsList=getPath("Config","Intl","intl").split(",");
		//create Object list
		List<Object> objList=new ArrayList<Object>();
		//loop through all the intls
		for(int i=0;i<intlsList.length;i++)
		{
			//create and add Test classes in Object list 
			//objList.add(new Facebook(intlsList[i]));
			//objList.add(new YouTube(intlsList[i]));
			//objList.add(new Bookmarks(intlsList[i]));
			//objList.add(new Gallery(intlsList[i]));
			objList.add(new Weather(intlsList[i]));
		}
		//return all the test classes to be use by testng 
		return objList.toArray(new Object[objList.size()]);
	}

}
