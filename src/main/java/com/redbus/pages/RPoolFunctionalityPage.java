package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RPoolFunctionalityPage {
	WebDriver driver;

	public RPoolFunctionalityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='cars']")
	public WebElement rpool;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'How it works')]")
	public WebElement rpool_How_it_works;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Offer Ride')]")
	public WebElement rpool_offer_ride;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/img[1]")
	public WebElement googleplay;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'redBus - World’s #1 Online Bus Ticket Booking App')]")
	public WebElement googleplaytxt;

	public void rpool_click() {
		rpool.click();
	}

	public void rpool_how_it_works_click() {
		rpool_How_it_works.click();
	}

	public void rpool_offer_ride_click() {
		rpool_offer_ride.click();
	}

	public void googleplay_click() {
		googleplay.click();
	}

	public String googleplay_txt() {
		return googleplaytxt.getText();
	}

}
