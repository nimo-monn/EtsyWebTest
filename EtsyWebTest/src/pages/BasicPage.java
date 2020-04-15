package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasicPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public BasicPage(WebDriverWait wait)
	{
		this.wait = wait;
	}
	
	public BasicPage(WebDriverWait wait, WebDriver driver)
	{
		this.wait = wait;
		this.driver = driver;
	}

}
