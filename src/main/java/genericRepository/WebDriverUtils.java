package genericRepository;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils 
{
	/**
	 * This method is used to apply wait until the page gets loaded
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for specified time for an element to be clickable
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait for specified time for an element to be visible
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Object creation to handle Dropdown
	 * @param element
	 * @return
	 */
	public Select dropdownObj(WebElement element)
	{
		Select sel = new Select(element);
		return sel;
	}
	
	/**
	 * This method is used to handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		dropdownObj(element).selectByIndex(index);
	}
	
	/**
	 * This method is used to handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		dropdownObj(element).selectByValue(value);
	}
	
	/**
	 * This method is used to handle dropdown by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		dropdownObj(element).selectByVisibleText(text);
	}
	
	/**
	 * Object creation to handle actions
	 * @param driver
	 * @return 
	 */
	public Actions actionsObj(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		actionsObj(driver).dragAndDrop(src, dst).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverOnEle(WebDriver driver, WebElement ele)
	{
		actionsObj(driver).click(ele).perform(); // moveToElement(ele)
	}
	
	/**
	 * This method will right click on the element
	 * @param driver
	 * @param ele
	 */
	public void rightClickOnEle(WebDriver driver, WebElement ele)
	{
		actionsObj(driver).contextClick().perform();
	}
	
	/**
	 * This method will double click on element
	 * @param driver
	 * @param ele
	 */
	public void doubleClickOnEle(WebDriver driver, WebElement ele)
	{
		actionsObj(driver).doubleClick(ele).perform();
	}
	
	/**
	 * This method will press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		actionsObj(driver).sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		actionsObj(driver).sendKeys(Keys.PAGE_DOWN).perform();
	}
	
	/**
	 * This method will use to pass the text in string form
	 * @param driver
	 * @param text
	 */
	public void sendtext(WebDriver driver, String text)
	{
		actionsObj(driver).sendKeys(text).perform();
	}
	
	
	/**
	 * Robot class
	 * This method will press enter key
	 * @param driver
	 * @throws Throwable 
	 */
	public void enterKey() throws Throwable
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will release the key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable
	{
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will switch the frame based on the index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch the frame based on the name or Id
	 * @param driver
	 * @param nameorId
	 */
	public void switchToFrame(WebDriver driver, String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	/**
	 * This method will switch the frame based on the address of an element
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * This method will accept the alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert pop-up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * This method will switch between the windows
	 * @param driver
	 * @param expwindow
	 */
	public void switchToWindow(WebDriver driver, String expwindow)
	{
		// Step 1 : To capture all the window id's
		Set<String> window = driver.getWindowHandles();
		
		// Step 2 : Iterate through the windows
		Iterator<String> it = window.iterator();
		
		// check whether there is next window
		while(it.hasNext())
		{
			// capture the current window id
			String win = it.next();
			
			//  switch to the current window and capture the window title
			String currentwintitle = driver.switchTo().window(win).getTitle();
			
			// check whether the current window is expected
			if(currentwintitle.contains(expwindow))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take screenshot and store it in folder named Screenshot
	 * @param driver
	 * @param screenshotName
	 * @return 
	 * @throws Throwable
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = IpathConstants.Screenshotpath+screenshotName+".png";
		File dst = new File(path);
		String scrpath = dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return scrpath;	
	}
	
	/**
	 * This method is used to capture screenshot with date
	 * @param driver
	 * @param screenshotName
	 * @return 
	 * @throws Throwable
	 */
	public static String getScreenshotwithDate(WebDriver driver, String screenshotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		Date date = new Date ();
		String d1= date.toString();
		String d2 = d1.replace(":", "-");
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = IpathConstants.Screenshotpath+ ""+d2+"" +screenshotName+".png";
		File dst = new File(path);
		String scrpath = dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return scrpath;
	}
	
	/**
	 * This method will perform scroll action for specified amount
	 * @param driver
	 * @param amount
	 */
	public void scrollAmount(WebDriver driver, int amount)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, "+amount+")");
	}
	
	/**
	 * This method will perform scroll action till bottom of the page
	 * @param driver
	 */
	public void scrollTillPageBottom(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	
	/**
	 * This method will perform scroll action till top of the page
	 * @param driver
	 */
	public void scrollTillPageup(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
	}
	
	/**
	 * This method will scroll till required element
	 * @param driver
	 * @param element
	 */
	public void scrolltoElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	/**
	 * This method will perform click action on Disabled element
	 * @param driver
	 * @param element
	 */
	public void clickOnDisabledElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * This method is used to send values into a disabled textfield
	 * @param driver
	 * @param text
	 * @param element
	 */
	public void sendValuesintoDisabledElement(WebDriver driver, String text, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='"+text+"'", element);
	}
	
	
	
	
	
	
	
	
	
}
