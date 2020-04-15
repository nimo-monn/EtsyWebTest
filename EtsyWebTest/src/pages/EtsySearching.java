package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsySearching extends BasicPage {

	private By searchBar = By.id("global-enhancements-search-query");
	private By radioPrice = By.className("wt-radio__label");
	private By items = By.cssSelector("[class='text-gray text-truncate mb-xs-0 text-body']");
	
	public EtsySearching(WebDriverWait wait, WebDriver driver) 
	{
		super(wait, driver);
	}
	
	public void clickSearchBar(String itemName)
	{
		WebElement searchConfirm = wait.until(presenceOfElementLocated(this.searchBar));
		searchConfirm.sendKeys(itemName);
		searchConfirm.sendKeys(Keys.ENTER);
	}
	
	public void setPrice()
	{
		List<WebElement> radioPriceList = new ArrayList<WebElement>();
		radioPriceList = wait.until(presenceOfAllElementsLocatedBy(this.radioPrice));
		
		radioPriceList.get(2).click();
	}
	
	public void getItem() throws InterruptedException
	{
		List<WebElement> itemsList = new ArrayList<WebElement>();
		itemsList = driver.findElements(this.items);
		
		Random rand = new Random();
		
		WebElement itemInList = itemsList.get(rand.nextInt(itemsList.size()));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", itemInList);
		Thread.sleep(1000);
		itemInList.click();
	}

}
