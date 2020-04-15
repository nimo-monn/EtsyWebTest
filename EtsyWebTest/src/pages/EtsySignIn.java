package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class EtsySignIn extends BasicPage {

	private By signIn = By.cssSelector(".wt-btn.wt-btn--small.wt-btn--transparent.wt-mr-xs-1.inline-overlay-trigger.signin-header-action.select-signin");
	private By emailField = By.id("join_neu_email_field");
	private By passwordField = By.id("join_neu_password_field");
	private By signInButton = By.cssSelector(".btn.btn-large.width-full.btn-primary");
	
	public EtsySignIn(WebDriverWait wait) 
	{
		super(wait);
	}
	
	public void clickSignIn()
	{
		wait.until(presenceOfElementLocated(this.signIn)).click();
	}
	
	public void enterEmail(String email)
	{
		wait.until(presenceOfElementLocated(this.emailField)).sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		wait.until(presenceOfElementLocated(this.passwordField)).sendKeys(password);
	}
	
	public void clickSignInButton()
	{
		wait.until(presenceOfElementLocated(this.signInButton)).click();
	}
	
	public void getSignIn(String email, String password) throws InterruptedException
	{
		Thread.sleep(2000);
		this.clickSignIn();
		Thread.sleep(2000);
		this.enterEmail(email);
		Thread.sleep(2000);
		this.enterPassword(password);
		Thread.sleep(2000);
		this.clickSignInButton();
	}

}
