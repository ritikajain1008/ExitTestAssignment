package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	public WebElement signinicon;

	@FindBy(how = How.XPATH, using = "//li[@id='signInLink']")
	public WebElement signin;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement mframe;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]")
	public WebElement googleicon;

	@FindBy(how = How.XPATH, using = "//body")
	public WebElement signinframe;

	@FindBy(how = How.XPATH, using = "//input[@id='identifierId']")
	public WebElement mail;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
	public WebElement nextbtn;

	@FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement password;
	
	@FindBy(how = How.XPATH, using = "//div[@id='confirm_yes']")
	public WebElement confirm;
	
	@FindBy(how = How.XPATH, using = "//body/div[6]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	public WebElement cross;
	
	@FindBy(how = How.XPATH, using = "//li[@id='signOutLink']")
	public WebElement signout;
	
	@FindBy(how = How.XPATH, using = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[2]")
	public WebElement incorrectpswd;
	
	@FindBy(how = How.XPATH, using = " //li[contains(text(),'My Profile')]")  
	public WebElement myprofile;
	
	@FindBy(how = How.XPATH, using = "//span[@id='Editbtn']")
	public WebElement editbtn;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'My Trips')]")
	public WebElement mytrips;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Wallets/Cards')]")
	public WebElement wallets_cards;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Your Wallet Balance')]")
	public WebElement wallettxt;
	
	
	
	
	public void icon_click() {
		signinicon.click();
	}

	public void signin_click() {
		signin.click();
	}

	public void enter_mail(String email) {
		mail.sendKeys(email);
	}

	public void nextbtn_click() {
		nextbtn.click();
	}

	public void confirm_click()
	{
		confirm.click();
	}
	
	public void cross_click()
	{
		cross.click();
	}
	
	public void signout_click()
	{
		signout.click();
	}
	
	public String incorrectpswd_txt()
	{
		return incorrectpswd.getText();
	}
	
	public void myprofile_click()
	{
		myprofile.click();
	}
	
	public void mytrips_click()
	{
		mytrips.click();
	}
	
	public void walletsAndcards_click()
	{
		wallets_cards.click();
	}
	
	public String wallet_txt()
	{
		return wallettxt.getText();
	}
	

}
