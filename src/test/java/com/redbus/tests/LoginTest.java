package com.redbus.tests;

import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.LoginPage;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExcelUtilities;

public class LoginTest extends BaseTest {

	public static Logger log = Logger.getLogger(LoginTest.class); // logging

	@Test
	public void ValidLoginFunctionality() throws Exception {
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("LoginTest");
		Map <String,String> testdata = ExcelUtilities.getTestData("LoginTest");
		extentTest = extent.startTest("Valid Login Scenario");
		CommonUtils.CheckExecutionRequired(executiondata.get("ValidLoginFunctionality"));
		LoginPage login = new LoginPage(driver);
		login.icon_click();
		login.signin_click();
		driver.switchTo().frame(login.mframe);
		Thread.sleep(5000);
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOf(login.googleicon)).click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		for (String child : s) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				login.enter_mail(testdata.get("mail"));
				login.nextbtn_click();
				WebDriverWait w1 = new WebDriverWait(driver, 20);
				w1.until(ExpectedConditions.elementToBeClickable(login.password))
						.sendKeys(testdata.get("password"));
				login.nextbtn_click();
				log.info("**********************User is successfully logged in************************");

			}

			Thread.sleep(5000);
		}
		driver.switchTo().window(parent);
		login.cross_click();
		Thread.sleep(5000);
		login.signout_click();
		log.info("**********************User is successfully sign out************************");
		Thread.sleep(5000);
		
	}

	@Test
	public void InvalidLoginFunctionality() throws Exception {
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("LoginTest");
		Map <String,String> testdata = ExcelUtilities.getTestData("LoginTest");
		extentTest = extent.startTest("Invalid Login Scenario");
		CommonUtils.CheckExecutionRequired(executiondata.get("InvalidLoginFunctionality"));
		LoginPage login = new LoginPage(driver);
		login.icon_click();
		login.signin_click();
		driver.switchTo().frame(login.mframe);
		Thread.sleep(5000);
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOf(login.googleicon)).click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		for (String child : s) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				login.enter_mail(testdata.get("mail"));
				login.nextbtn_click();
				WebDriverWait w1 = new WebDriverWait(driver, 20);
				w1.until(ExpectedConditions.elementToBeClickable(login.password))
						.sendKeys(testdata.get("incorrect_password"));
				login.nextbtn_click();
				WebDriverWait w2 = new WebDriverWait(driver, 30);
				String text = w2.until(ExpectedConditions.visibilityOf(login.incorrectpswd)).getText();
				Assert.assertEquals(text, "Wrong password. Try again or click ‘Forgot password’ to reset it."); 
				log.info("********************Incorrect Password Entered***************************");
			}

			Thread.sleep(5000);
		}

	}

	@Test
	public void ViewMyProfile() throws Exception {
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("LoginTest");
		Map <String,String> testdata = ExcelUtilities.getTestData("LoginTest");
		extentTest = extent.startTest("View My Profile Scenario");
		CommonUtils.CheckExecutionRequired(executiondata.get("ViewMyProfile"));
		LoginPage login = new LoginPage(driver);
		login.icon_click();
		login.signin_click();
		driver.switchTo().frame(login.mframe);
		Thread.sleep(5000);
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOf(login.googleicon)).click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		for (String child : s) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				login.enter_mail(testdata.get("mail"));
				login.nextbtn_click();
				WebDriverWait w1 = new WebDriverWait(driver, 20);
				w1.until(ExpectedConditions.elementToBeClickable(login.password))
						.sendKeys(testdata.get("password"));
				login.nextbtn_click();
				log.info("**********************User is successfully logged in************************");

			}

			Thread.sleep(5000);
		}
		driver.switchTo().window(parent);
		login.cross_click();
		Thread.sleep(5000);
		login.icon_click();
		login.myprofile_click();
		WebDriverWait w2 = new WebDriverWait(driver, 30);
		w2.until(ExpectedConditions.visibilityOf(login.editbtn)).click();
		Thread.sleep(5000);
		log.info("**********************User can edit his/her profile************************");
	}

	@Test
	public void ViewMyTrips() throws Exception {
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("LoginTest");
		Map <String,String> testdata = ExcelUtilities.getTestData("LoginTest");
		extentTest = extent.startTest("View My Trips Scenario");
		CommonUtils.CheckExecutionRequired(executiondata.get("ViewMyTrips"));
		LoginPage login = new LoginPage(driver);
		login.icon_click();
		login.signin_click();
		driver.switchTo().frame(login.mframe);
		Thread.sleep(5000);
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOf(login.googleicon)).click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		for (String child : s) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				login.enter_mail(testdata.get("mail"));
				login.nextbtn_click();
				WebDriverWait w1 = new WebDriverWait(driver, 20);
				w1.until(ExpectedConditions.elementToBeClickable(login.password))
						.sendKeys(testdata.get("password"));
				login.nextbtn_click();
				log.info("**********************User is successfully logged in************************");
			}

			Thread.sleep(5000);
		}
		driver.switchTo().window(parent);
		login.cross_click();
		Thread.sleep(5000);
		login.icon_click();
		login.mytrips_click();
		Assert.assertEquals(driver.getTitle(),
				"Online Bus tickets Booking, AC Volvo Booking, 250 INR CB On Bus Reservation");
		log.info("**********************User can view his/her booked trips************************");
		Thread.sleep(5000);

	}

	@Test
	public void ViewWalletsAndCards() throws Exception {
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("LoginTest");
		Map <String,String> testdata = ExcelUtilities.getTestData("LoginTest");
		extentTest = extent.startTest("View My Wallet & Cards Scenario");
		CommonUtils.CheckExecutionRequired(executiondata.get("ViewWalletsAndCards"));
		LoginPage login = new LoginPage(driver);
		login.icon_click();
		login.signin_click();
		driver.switchTo().frame(login.mframe);
		Thread.sleep(5000);
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOf(login.googleicon)).click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		for (String child : s) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				login.enter_mail(testdata.get("mail"));
				login.nextbtn_click();
				WebDriverWait w1 = new WebDriverWait(driver, 20);
				w1.until(ExpectedConditions.elementToBeClickable(login.password))
						.sendKeys(testdata.get("password"));
				login.nextbtn_click();
				log.info("**********************User is successfully logged in************************");

			}

			Thread.sleep(5000);
		}
		driver.switchTo().window(parent);
		login.cross_click();
		Thread.sleep(5000);
		login.icon_click();
		login.walletsAndcards_click();
		WebDriverWait w2 = new WebDriverWait(driver, 30);
		String walletpgtxt = w2.until(ExpectedConditions.visibilityOf(login.wallettxt)).getText();
		Assert.assertEquals(walletpgtxt, "Your Wallet Balance");
		log.info("**********************User can view his/her wallet amount & added cards************************");
		Thread.sleep(5000);
	}

}
