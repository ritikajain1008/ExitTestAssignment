package com.redbus.tests;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.pages.BusTicketsPage;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExcelUtilities;


public class BusTicketTest extends BaseTest {
	
	public static Logger log = Logger.getLogger(BusTicketTest.class); // logging
	
	@Test
	public void BusTickets() throws Exception
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("BusTicketTest");
		extentTest = extent.startTest("Search Available Bus Tickets");
		CommonUtils.CheckExecutionRequired(executiondata.get("BusTickets"));
		log.info("*************Search Buses from one location to other************");
		BusTicketsPage bustickets = new BusTicketsPage(driver);
		bustickets.bustickets_click();
		bustickets.enter_source();
		bustickets.enter_destination();
		bustickets.enter_calendardate(prop.getProperty("date"));
		bustickets.search_click();
		log.info("*************Available Buses are displayed*********************");
		Thread.sleep(5000);
	    Assert.assertEquals(driver.getTitle(),"Search Bus Tickets");
	}
}


