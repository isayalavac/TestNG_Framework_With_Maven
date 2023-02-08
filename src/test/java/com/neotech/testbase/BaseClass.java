package com.neotech.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	

	/**
	 * This method will initialize the driver
	 */
	@BeforeMethod(alwaysRun=true)
	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported!!!");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
	}

	/**
	 * This method will quit the browser
	 */
	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
