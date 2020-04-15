package tests;

import java.util.ArrayList;

import org.testng.annotations.Test;

import pages.EtsySignIn;
import pages.EtsyCart;
import pages.EtsyFavorites;
import pages.EtsyManagingItems;
import pages.EtsySearching;

public class EtsyTest extends BasicTest{
	
	private String baseUrl = "https://www.etsy.com";
	
	@Test(priority = 0)//Log in to Etsy website
	public void signIn() throws InterruptedException
	{
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		EtsySignIn er = new EtsySignIn(wait);
		Thread.sleep(2000);
		
		er.getSignIn("vsunildouo@epicxel.com", "testtest");	
	}
	
	@Test(priority = 2)//Searching and filtering items, and opening one item
	public void search() throws InterruptedException
	{
		EtsySearching es = new EtsySearching(wait, driver);
		Thread.sleep(2000);
		
		es.clickSearchBar("bags");
		Thread.sleep(2000);
		
		es.setPrice();
		Thread.sleep(4000);
		
		es.getItem();
	}
	
	@Test(priority = 3)//Adding item to cart
	public void itemManagement() throws InterruptedException
	{
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		EtsyManagingItems emi = new EtsyManagingItems(wait, driver);
		Thread.sleep(2000);
		
		emi.setFavorite();
		Thread.sleep(1000);
		
		emi.setParametersForItems();
		Thread.sleep(1000);
		
		emi.setCustomizationText();
		Thread.sleep(1000);
		
		emi.addToCart();
	}
	
	@Test(priority = 4)//Managing cart
	public void cartManagement() throws InterruptedException
	{
		EtsyCart ec = new EtsyCart(wait);
		Thread.sleep(2000);
		
		ec.manageCart("Beautiful item"); 
	}
	
	@Test(priority = 5)//Managing favorites
	public void favoritesManagement() throws InterruptedException
	{
		EtsyFavorites ef = new EtsyFavorites(wait);
		Thread.sleep(2000);	
		
		ef.clickFavoriteButton();
		Thread.sleep(2000);
		
		ef.filterItems();
		Thread.sleep(1000);
		
		ef.unfavoriteItem();
		driver.navigate().refresh();
	}

}
