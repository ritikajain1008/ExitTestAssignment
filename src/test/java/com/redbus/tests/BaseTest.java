package com.redbus.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.redbus.utils.DockerRunnable;
import com.redbus.utils.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	static WebDriver driver=null;
	public static String winHandleBefore;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static Logger log = Logger.getLogger(BaseTest.class);
	static File file = new File(".\\Resources\\config.properties"); // config properties file path

	static File log_file = new File(".\\src\\main\\resources\\log4j.properties"); // log file path
	static FileInputStream fis = null;
	static FileInputStream log_fis = null;
	public static Properties prop = new Properties();
	static {
		try {
			fis = new FileInputStream(file);
			log_fis = new FileInputStream(log_file);
			PropertyConfigurator.configure(log_fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
			prop.load(log_fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void changeWindow() {
		winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void closeWindow() {
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\ExtentReport.html");
		extent.addSystemInfo("Host Name", "Ritika Jain");
		extent.addSystemInfo("User Name", "Ritika1008");
		extent.assignProject("Redbus Site Test");
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@AfterMethod
	public void report(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test case Failed");
			String screenshotPath = Screenshot.takeScreenShot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test case is Skipped");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case Passed Successfully");
		}
		extent.endTest(extentTest);

	}


	@BeforeMethod
	public static void Initialize() throws MalformedURLException {
		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome"))
		/*{
			driver = DockerRunnable.runInDocker();
			
		}*/
		{
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe"); // for Chrome browser
			if (prop.getProperty("Mode").equalsIgnoreCase("Headless")) // for headless mode
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		} else if (prop.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");// for firefox browser
			driver = new FirefoxDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".\\Drivers\\IEDriverServer.exe"); // for IE browser
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ImplicitWait

	}

	@BeforeMethod
	public static void openBrowser() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod(dependsOnMethods = "report")
	public static void closeBrowser() {
		driver.quit();

	}

}
