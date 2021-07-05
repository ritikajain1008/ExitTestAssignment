package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFunctionality {
	WebDriver driver;

	public HomePageFunctionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement sourcecity;

	@FindBy(how = How.XPATH, using = "//input[@id='dest']") // xpath locator
	public WebElement destinationcity;

	@FindBy(how = How.XPATH, using = "//input[@id='onward_cal']")
	public WebElement calendar;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'29')]")
	public WebElement date;

	@FindBy(how = How.XPATH, using = "//*[text()='Search Buses']")
	public WebElement searchbtn;

	@FindBy(how = How.XPATH, using = "//body/section[@id='rh_main']/div[@id='mBWrapper']/main[1]/div[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[1]/span[1]/span[2]/img[1]")
	public WebElement amazonoffer;

	@FindBy(how = How.XPATH, using = "//button[@id='search_btn']")
	public WebElement search;

	@FindBy(how = How.XPATH, using = "//body[1]/section[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[2]/span[1]/span[2]/img[1]")
	public WebElement redbuscares;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/span[2]/input[1]")
	public WebElement money;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[6]/ul[1]/li[2]/span[1]/ul[1]/li[1]/span[1]/input[1]")
	public WebElement donateanonymous;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[7]/button[1]/div[1]")
	public WebElement donatenow;

	@FindBy(how = How.XPATH, using = "//body[1]/section[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[4]/div[2]/ul[1]/li[1]/span[1]/span[2]/img[1]")
	public WebElement journeyfordreams;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'redbus')]")
	public WebElement logotxt;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manage Booking')]")
	public WebElement managebooking;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
	public WebElement showmyticket;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'PRINT TICKET')]")
	public WebElement myticketpgtxt;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	public WebElement cancelmyticket;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	public WebElement helpbtn;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	public WebElement cross;

	public void enter_sourcecity(String srccity) {
		sourcecity.sendKeys(srccity);
	}

	public void enter_destinationcity(String destcity) {
		destinationcity.sendKeys(destcity);
	}

	public void cal_click() {
		calendar.click();
	}

	public void date_click() {
		date.click();
	}

	public void searchbtn_click() {
		searchbtn.click();
	}

	public void amazonoffer_click() {
		amazonoffer.click();
	}

	public void search_clickbtn() {
		search.click();
	}

	public void redbuscares_click() {
		redbuscares.click();
	}

	public void enter_money(String moneyamt) {
		money.sendKeys(moneyamt);
	}

	public void donateanonymous_click() {
		donateanonymous.click();
	}

	public void donatenow_click() {
		donatenow.click();
	}

	public void journeyfordreams_click() {
		journeyfordreams.click();
	}

	public String logo_text() {
		return logotxt.getText();
	}

	public void managebooking_click() {
		managebooking.click();
	}

	public void showmyticket_click() {
		showmyticket.click();
	}

	public String ticketpg_txt() {
		return myticketpgtxt.getText();
	}

	public void cancelmyticket_click() {
		cancelmyticket.click();
	}

	public void helpbtn_click() {
		helpbtn.click();
	}

	public void cross_click() {
		cross.click();
	}

}
