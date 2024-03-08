package genericRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static WebDriver driver;
	
	ExcelUtils eLib = new ExcelUtils();
	DatabaseUtils dLib = new DatabaseUtils();
	WebDriverUtils wLib = new WebDriverUtils();
	PropertyFileUtils pLib = new PropertyFileUtils();
	
	@BeforeSuite(alwaysRun = true)
	public void conDB() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("Database connected");
	}

	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable
	{
		String browser = pLib.readDataFromPropertyFile("browser");
		String url = pLib.readDataFromPropertyFile("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println("chrome browser launched");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.out.println("firefox browser launched");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			System.out.println("edge browser launched");
		}
		driver.manage().window().maximize();
		
		driver.get(url);
		
		wLib.waitForPageLoad(driver, 20);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToApp()
	{
		System.out.println("Login successful");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromApp()
	{
		System.out.println("Logout successful");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() throws Throwable
	{
		Thread.sleep(1000);
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDB() throws Throwable
	{
		dLib.disconnectDB();
		System.out.println("Database closed");
	}	
}
