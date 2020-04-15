package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BasicTest {
	
protected WebDriver driver;
protected WebDriverWait wait;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver,10);
		} else if(browser.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver", "driver-lib\\operadriver.exe");
			driver = new OperaDriver();
			wait = new WebDriverWait(driver, 10);
		} else
		{
			throw new Exception("Browser is not correct");
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void quit() 
	{
		driver.quit();
	}

}
