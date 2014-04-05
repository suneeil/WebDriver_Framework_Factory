package yahoo.toolbar.webDriver.apps.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MiddleMouseClick {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id='pmolnk']/a"));
		builder.keyDown(Keys.SHIFT).moveToElement(ele).click().perform();

	}

}
