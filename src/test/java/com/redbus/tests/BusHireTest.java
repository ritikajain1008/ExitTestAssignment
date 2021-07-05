package com.redbus.tests;
import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.redbus.pages.BusHirePage;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExcelUtilities;



public class BusHireTest extends BaseTest {
	
	public static Logger log = Logger.getLogger(BusHireTest.class); // logging
	
	@Test
	public void minibuses_hire() throws Exception
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("BusHireTest");
		extentTest = extent.startTest("Hire Minibuses");
		CommonUtils.CheckExecutionRequired(executiondata.get("minibuses_hire"));
		BusHirePage bushire = new BusHirePage(driver);
		bushire.bushire_click();
		bushire.busminibus_click();
		changeWindow();
		Assert.assertEquals(driver.getTitle(),"Minibus Rental | Hire Minibus on redBus.in starting @ INR(24)/KM");
		log.info("************************Available Mini Buses are displayed***************************");
		closeWindow();
		Thread.sleep(5000);
	}
	
	@Test
	public void tempotraveller_hire() throws Exception
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("BusHireTest");
		extentTest = extent.startTest("Hire TempoTraveller");
		CommonUtils.CheckExecutionRequired(executiondata.get("tempotraveller_hire"));
		BusHirePage bushire = new BusHirePage(driver);
		bushire.bushire_click();
		bushire.tempotraveller_click();
		changeWindow();
		Assert.assertEquals(driver.getTitle(),"Tempo Traveller | Rent Force Tempo Traveller Van | Rental Booking Price");
		log.info("*************************Available Tempo Traveller are displayed*************************");
		closeWindow();
		Thread.sleep(5000);
	}
	
	@Test
	public void car_hire() throws Exception
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("BusHireTest");
		extentTest = extent.startTest("Hire Cars");
		CommonUtils.CheckExecutionRequired(executiondata.get("car_hire"));
		BusHirePage bushire = new BusHirePage(driver);
		bushire.bushire_click();
		bushire.car_click();
		changeWindow();
		Assert.assertEquals(driver.getTitle(),"Car Rentals in India | Low Fares, Sanitised Vehicles, and much more! | redBus");
		log.info("*********************Available Cars on rent are displayed************************");
		closeWindow();
		Thread.sleep(5000);
	}
	
	@Test
	public void managebooking_cancel() throws Exception
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("BusHireTest");
		extentTest = extent.startTest("Cancellation of Hired Buses");
		CommonUtils.CheckExecutionRequired(executiondata.get("managebooking_cancel"));
		BusHirePage bushire = new BusHirePage(driver);
		bushire.bushire_click();
		bushire.managebooking_click();
		bushire.cancellation_click();
		Assert.assertEquals(bushire.cancellationpage_text(),"Cancellation");
		log.info("**********************Cancellation Page is displayed*****************************");
	    Thread.sleep(5000);
		
	}
	
	@Test
	public void offers() throws Exception
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("BusHireTest");
		extentTest = extent.startTest("Available Offers");
		CommonUtils.CheckExecutionRequired(executiondata.get("offers"));
        BusHirePage bushire = new BusHirePage(driver);
		bushire.bushire_click();
		bushire.offersicon_click();
		bushire.offers_click();
		Assert.assertEquals(bushire.instantoffer_text(),"Get Rs.1000 off");
		log.info("***********************Available Offers on Booking are displayed*********************");
	    Thread.sleep(5000);
	}
	
	@Test
	public void hireVehicle_Outstation() throws Exception    
	{
		Map <String,String> executiondata = ExcelUtilities.getExecutionMapData("BusHireTest");
		extentTest = extent.startTest("Hire Vehicle for Outstation");
		CommonUtils.CheckExecutionRequired(executiondata.get("hireVehicle_Outstation"));
	    log.info("*******************Hire Vehicle for outstation*****************************");
		BusHirePage bushire = new BusHirePage(driver);
		bushire.bushire_click();
		driver.switchTo().frame(bushire.anotherframe);
		bushire.outstation_click();
		Thread.sleep(5000);
		bushire.enter_pickup(prop.getProperty("fromcity"));
		bushire.enter_dest(prop.getProperty("tocity"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", bushire.fromDateAndTime);
        bushire.fromslctdate_click();
	    bushire.ok_click();
	    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
        jse1.executeScript("arguments[0].click()", bushire.toDateAndTime);
        bushire.arrow_click();
        Thread.sleep(5000);
        bushire.toslctdate_click();
        bushire.ok_click();
        Thread.sleep(5000);
        bushire.enter_no_of_passengers(prop.getProperty("passengers"));
		bushire.proceed_click();
		Assert.assertEquals(bushire.outstationpg_text(),"Outstation");
		Thread.sleep(5000);
	}

}
