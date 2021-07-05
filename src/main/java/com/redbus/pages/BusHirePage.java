package com.redbus.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusHirePage{

	WebDriver driver;

	public BusHirePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='redBus Bus Hire']")
	public WebElement bushire;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[5]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]")
	public WebElement busminibus;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[5]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]")
	public WebElement tempotraveller;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[5]/div[1]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]")
	public WebElement cars;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	public WebElement managebooking;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]")
	public WebElement cancellation;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Cancellation')]")
	public WebElement cancellationpagetxt;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/img[1]")
	public WebElement offersicon;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]")
	public WebElement offers;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Get Rs.1000 off')]")
	public WebElement instantoffer;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Outstation')]") // xpath locator
	public WebElement outstation;

	@FindBy(how = How.XPATH, using = "//object")
	public WebElement anotherframe;

	@FindBy(how = How.ID, using = "locationTextFieldLocal")
	public WebElement pickuplocation;

	@FindBy(how = How.ID, using = "local_dest_name") // id locator
	public WebElement destlocation;

	@FindBy(how = How.XPATH, using = "//*[@id='from_datepicker']/div/div/input")
	public WebElement fromDateAndTime;

	@FindBy(how = How.XPATH, using = "//body/div[5]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[5]/div[4]/button[1]/span[1]/p[1]")
	public WebElement slctfromDateAndTime;

	@FindBy(how = How.XPATH, using = "//body/div[5]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[6]/button[1]/span[1]/p[1]")
	public WebElement slcttoDateAndTime;

	@FindBy(how = How.XPATH, using = "//*[@id='to_datepicker']/div/div/input")
	public WebElement toDateAndTime;

	@FindBy(how = How.XPATH, using = "//*[text() = 'OK']")
	public WebElement okbtn;

	@FindBy(how = How.XPATH, using = "//input[@id='numberOfPax']")
	public WebElement noofpassengers;

	@FindBy(how = How.XPATH, using = "//button[@id='proceedButtonOutstation']")
	public WebElement proceedbtn;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Outstation')]")
	public WebElement outstationpgtxt;

	@FindBy(how = How.XPATH, using = "//body/div[5]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/button[2]/span[1]/*[1]")
	public WebElement arrow;

	public void bushire_click() {
		bushire.click();
	}

	public void busminibus_click() {
		busminibus.click();
	}

	public void tempotraveller_click() {
		tempotraveller.click();
	}

	public void car_click() {
		cars.click();
	}

	public void managebooking_click() {
		managebooking.click();
	}

	public void cancellation_click() {
		cancellation.click();
	}

	public String cancellationpage_text() {
		return cancellationpagetxt.getText();
	}

	public void offersicon_click() {
		offersicon.click();
	}

	public void offers_click() {
		offers.click();
	}

	public String instantoffer_text() {
		return instantoffer.getText();
	}

	public void outstation_click() {
		outstation.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(pickuplocation));  //explicit wait
	}

	public String outstation_txt() {
		return outstation.getText();
	}

	public void enter_pickup(String ploc) {
		pickuplocation.sendKeys(ploc);
		pickuplocation.sendKeys(Keys.ARROW_DOWN); // select from drop down list
		pickuplocation.sendKeys(Keys.ARROW_UP);
		pickuplocation.sendKeys(Keys.RETURN);
	}

	public void enter_dest(String dloc) {
		destlocation.sendKeys(dloc);
		destlocation.sendKeys(Keys.ARROW_DOWN);
		destlocation.sendKeys(Keys.ARROW_UP);
		destlocation.sendKeys(Keys.ENTER);
	}

	public void fromslctdate_click() {
		slctfromDateAndTime.click();
	}

	public void toslctdate_click() {
		slcttoDateAndTime.click();
	}

	public void ok_click() {
		okbtn.click();
	}

	public void arrow_click() {
		arrow.click();
	}

	public void proceed_click() {
		proceedbtn.click();
	}

	public String outstationpg_text() {
		return outstationpgtxt.getText();
	}

	public void enter_no_of_passengers(String num) {
		noofpassengers.sendKeys(num);
	}

}
