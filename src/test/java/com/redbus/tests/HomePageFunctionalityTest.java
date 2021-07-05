package com.redbus.tests;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.HomePageFunctionality;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExcelUtilities;

public class HomePageFunctionalityTest extends BaseTest {

	public static Logger log = Logger.getLogger(HomePageFunctionality.class); // logging

	@Test
	public void searchBuses() throws Exception {
		Map<String, String> executiondata = ExcelUtilities.getExecutionMapData("HomePageFunctionalityTest"); // data
																												// from
																												// excel
																												// sheet
		extentTest = extent.startTest("Search Buses");
		CommonUtils.CheckExecutionRequired(executiondata.get("searchBuses")); // execution required or not
		log.info("***********Search Buses from one location to other************************");
		HomePageFunctionality homepage = new HomePageFunctionality(driver);
		homepage.enter_sourcecity(prop.getProperty("fromcity")); // data from config file
		homepage.enter_destinationcity(prop.getProperty("tocity"));
		homepage.cal_click();
		homepage.date_click();
		homepage.searchbtn_click();
		log.info("**************Available buses info are displayed***************************");
	}

	@Test
	public void amazonOffer() throws Exception {
		Map<String, String> executiondata = ExcelUtilities.getExecutionMapData("HomePageFunctionalityTest");
		extentTest = extent.startTest("Available Amazon Offers");
		CommonUtils.CheckExecutionRequired(executiondata.get("amazonOffer"));
		log.info("******************Available Amazon Pay Offers are displayed********************");
		HomePageFunctionality homepage = new HomePageFunctionality(driver);
		homepage.amazonoffer_click();
		homepage.enter_sourcecity(prop.getProperty("fromcity"));
		homepage.enter_destinationcity(prop.getProperty("tocity"));
		homepage.cal_click();
		homepage.date_click();
		homepage.search_clickbtn();
		changeWindow(); // switch to other window
		Assert.assertEquals(driver.getTitle(), "Offers: Bus Offers, Hotel Discounts & Coupon Codes - redBus"); // Assertion
		closeWindow(); // opened other window will close
	}

	@Test
	public void redbusCares() throws Exception {
		Map<String, String> executiondata = ExcelUtilities.getExecutionMapData("HomePageFunctionalityTest");
		extentTest = extent.startTest("Red Bus Cares");
		CommonUtils.CheckExecutionRequired(executiondata.get("redbusCares"));
		HomePageFunctionality homepage = new HomePageFunctionality(driver);
		homepage.redbuscares_click();
		changeWindow();
		homepage.enter_money(prop.getProperty("money"));
		homepage.donateanonymous_click();
		homepage.donatenow_click();
		log.info("****************Donated Anonymously in RedBus cares fund*************************");
		Assert.assertEquals(driver.getTitle(), "redBus Cares - Supporting Bus drivers and helpers");
		closeWindow();
	}

	@Test
	public void journeyForDreams() throws Exception {
		Map<String, String> executiondata = ExcelUtilities.getExecutionMapData("HomePageFunctionalityTest");
		extentTest = extent.startTest("Journey For Dreams");
		CommonUtils.CheckExecutionRequired(executiondata.get("journeyForDreams"));
		log.info("************************Use Coupon Code to avail offers***************************");
		HomePageFunctionality homepage = new HomePageFunctionality(driver);
		homepage.journeyfordreams_click();
		changeWindow();
		Assert.assertEquals(driver.getTitle(), "Offers: Bus Offers, Hotel Discounts & Coupon Codes - redBus");
		closeWindow();

	}

	@Test
	public void sitelogoText() throws Exception {
		Map<String, String> executiondata = ExcelUtilities.getExecutionMapData("HomePageFunctionalityTest");
		extentTest = extent.startTest("Site Logo Text");
		CommonUtils.CheckExecutionRequired(executiondata.get("sitelogoText"));
		log.info("***********************Site Logo Text*******************************");
		HomePageFunctionality homepage = new HomePageFunctionality(driver);
		Assert.assertEquals(homepage.logo_text(), "redbus"); // Assertion to check sitelogo text spelling
	}

	@Test
	public void showMyTicket() throws Exception {
		Map<String, String> executiondata = ExcelUtilities.getExecutionMapData("HomePageFunctionalityTest");
		extentTest = extent.startTest("Show My Ticket");
		log.info("******************Booked Ticket Info is Available***********************");
		CommonUtils.CheckExecutionRequired(executiondata.get("showMyTicket"));
		HomePageFunctionality homepage = new HomePageFunctionality(driver);
		homepage.managebooking_click();
		homepage.showmyticket_click();
		Assert.assertEquals(homepage.ticketpg_txt(), "PRINT TICKET");
	}

	@Test
	public void cancelMyTicket() throws Exception // cancel ticket btn on home page
	{
		Map<String, String> executiondata = ExcelUtilities.getExecutionMapData("HomePageFunctionalityTest");
		extentTest = extent.startTest("Cancellation of Hired Buses");
		CommonUtils.CheckExecutionRequired(executiondata.get("cancelMyTicket"));
		log.info("************************Cancel Booked Tickets***************************");
		HomePageFunctionality homepage = new HomePageFunctionality(driver);
		homepage.managebooking_click();
		homepage.cancelmyticket_click();
		Assert.assertEquals(driver.getTitle(), "Cancel Ticket - redBus");
	}

	@Test
	public void Help() throws Exception {
		Map<String, String> executiondata = ExcelUtilities.getExecutionMapData("HomePageFunctionalityTest");
		extentTest = extent.startTest("View Help Page");
		CommonUtils.CheckExecutionRequired(executiondata.get("Help"));
		log.info("**********************Need Any Help?*************************************");
		HomePageFunctionality homepage = new HomePageFunctionality(driver);
		homepage.helpbtn_click();
		changeWindow(); // switch to other window
		homepage.cross_click();
		Assert.assertEquals(driver.getTitle(), "red:Care"); // Assertions
		closeWindow(); // close other opened window
	}

}
