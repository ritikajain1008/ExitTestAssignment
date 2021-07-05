package com.redbus.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerRunnable {
	
	static RemoteWebDriver driver = null;
	
	   public static RemoteWebDriver runInDocker() throws MalformedURLException {   //to run testcases using docker
		  final ChromeOptions options = new ChromeOptions(); 
		  options.addArguments("--headless");
		  options.addArguments("--disable-gpu");
		  options.addArguments("--disable-dev-shm-usage");
		  options.addArguments("--no-sandbox");
		  options.addArguments("--allow-insecure-localhost");
		  options.addArguments("window-size=1920,1080");
		  options.addArguments("user-agent=Chrome/91.0.4472.124");
		  URL url = new URL("http://localhost:4444/wd/hub"); 
		  driver = new RemoteWebDriver(url,options); 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		  return driver;
		  }
	
	
		 

}
