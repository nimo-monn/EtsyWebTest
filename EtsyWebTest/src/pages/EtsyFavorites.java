package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyFavorites extends BasicPage{

	private By favoritesButton = By.id("gnav-account-favorites-description");
	private By filters = By.id("favorites-filter-dropdown_button");
	private By availableItems = By.xpath("//*[@id='favorite-items-content']/div[1]/div/div/div[1]/div[2]/div/div[1]/div/div/div/ul/li[1]/fieldset/span/label/span");
	private By unfavoriteButton = By.cssSelector("span.favorite-listing-button-icon-container.icon-circle-container.bg-white.icon-group.p-xs-1");
	
	public EtsyFavorites(WebDriverWait wait) 
	{
		super(wait);
	}
	
	public void clickFavoriteButton()
	{
		wait.until(presenceOfElementLocated(this.favoritesButton)).click();
	}
	
	public void filterItems() throws InterruptedException
	{
		wait.until(presenceOfElementLocated(this.filters)).click();
		Thread.sleep(300);
		wait.until(presenceOfElementLocated(this.availableItems)).click();
	}
	
	public void unfavoriteItem() throws InterruptedException
	{
		wait.until(presenceOfElementLocated(this.unfavoriteButton)).click();
		Thread.sleep(1000);
	}

}
