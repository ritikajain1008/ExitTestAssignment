package com.redbus.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BusTicketsPage {
	WebDriver driver;

	public BusTicketsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='redBus']")
	public WebElement bustickets;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/a[1]/div[2]/img[1]")
	public WebElement journeyfordreams;

	@FindBy(how = How.XPATH, using = "//button[@id='search_btn']")
	public WebElement search;

	@FindBy(how = How.XPATH, using = "//input[@id='txtSource']")
	public WebElement source;

	@FindBy(how = How.XPATH, using = "//input[@id='txtDestination']")
	public WebElement destination;

	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	public WebElement calendar;

	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/button[1]")
	public WebElement searchbus;

	public void bustickets_click() {
		bustickets.click();
	}

	public void enter_source() {
		source.sendKeys(Keys.ARROW_DOWN); // select from drop down
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);

	}

	public void enter_destination() {
		destination.sendKeys(Keys.ARROW_DOWN);
		destination.sendKeys(Keys.ARROW_UP);
		destination.sendKeys(Keys.ENTER);

	}

	public void enter_calendardate(String calendar_date) {
		calendar.sendKeys(calendar_date);

	}

	public void search_click() {
		searchbus.click();
	}

}
