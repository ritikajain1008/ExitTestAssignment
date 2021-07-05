package com.redbus.tests;


import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.RPoolFunctionalityPage;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExcelUtilities;

public class RPoolFunctionalityTest extends BaseTest{
	public static Logger log = Logger.getLogger(RPoolFunctionalityTest.class); // logging
	
	@Test
	public void RPool() throws Exception
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("RPoolFunctionality");
		extentTest = extent.startTest("RPool Page Functionality");
		CommonUtils.CheckExecutionRequired(executiondata.get("RPool"));
		RPoolFunctionalityPage rpool = new RPoolFunctionalityPage(driver);
		rpool.rpool_click();
		rpool.rpool_how_it_works_click();
		rpool.rpool_offer_ride_click();
		log.info("************************Swipe Functionality*******************");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),"rPool - India’s new Carpool & Bikepool mobile app");
	}
	
	@Test
	public void siteOnGooglePlay() throws Exception
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("RPoolFunctionality");
		extentTest = extent.startTest("Site On Google Play store");
		CommonUtils.CheckExecutionRequired(executiondata.get("siteOnGooglePlay"));
		RPoolFunctionalityPage rpool = new RPoolFunctionalityPage(driver);
		rpool.rpool_click();
		rpool.googleplay_click();
		Thread.sleep(5000);
		log.info("**************Application can be installed for given site from google play store***********");
		Thread.sleep(5000);
	}
	
	

}
