package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyManagingItems extends BasicPage {

	private By favoriteButton = By.cssSelector("span.etsy-icon.icon-t-1.text-gray.display-block");
	private By quantity = By.cssSelector("[class='wt-select__element  variation-selector']");
	private By addButton = By.cssSelector("button.wt-btn.wt-btn--filled.wt-width-full");
	
	public EtsyManagingItems(WebDriverWait wait, WebDriver driver) 
	{
		super(wait, driver);
	}
	
	public void setFavorite()
	{
		wait.until(presenceOfElementLocated(this.favoriteButton)).click();
	}
	
	public void setParametersForItems() throws InterruptedException
	{
		List<WebElement> optionsList = new ArrayList<WebElement>();
		optionsList = driver.findElements(this.quantity);
		Select currentSelect;
		for(int i = 0; i < optionsList.size(); i++)
		{
			String idOfSelect = optionsList.get(i).getAttribute("id");

			currentSelect = new Select(optionsList.get(i));
			
			if(idOfSelect != null && idOfSelect.contains("quantity"))
			{
				currentSelect.selectByValue("2");
			}
			else
			{
				currentSelect.selectByIndex(1);
			}
		}
		
	}
	
	public void setCustomizationText()
	{
		try 
		{
			WebElement customizationText = driver.findElement(By.id("personalization-input"));
			if(customizationText != null)
			{
				customizationText.sendKeys("Hello");
			}
		}
		catch(Exception e)
		{
			System.out.println("This item doesn't have a personalized message");
		}
	}
	
	public void addToCart()
	{
		wait.until(presenceOfElementLocated(this.addButton)).click();
	}

}
