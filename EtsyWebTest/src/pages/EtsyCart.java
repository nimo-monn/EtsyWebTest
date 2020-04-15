package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyCart extends BasicPage {

	private By giftOrderCheck = By.cssSelector("span.checkbox-label.pb-xs-2");
	private By messageSeller = By.cssSelector("[name='message_to_seller']");
	private By remove = By.cssSelector("[aria-label='Remove listing']");
	
	public EtsyCart(WebDriverWait wait) 
	{
		super(wait);
	}
	
	public void checkOrderIsGift()
	{
		wait.until(presenceOfElementLocated(this.giftOrderCheck)).click();
	}
	
	public void addMessage(String message)
	{
		wait.until(presenceOfElementLocated(this.messageSeller)).sendKeys(message);
	}
	
	public void removeItem()
	{
		wait.until(presenceOfElementLocated(this.remove)).click();
	}

	public void manageCart(String message) throws InterruptedException
	{
		this.checkOrderIsGift();
		Thread.sleep(1000);
		this.addMessage(message);
		Thread.sleep(1000);
		this.removeItem();
	}
}
