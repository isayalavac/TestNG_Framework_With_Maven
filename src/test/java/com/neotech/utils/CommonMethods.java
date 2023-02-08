package com.neotech.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.testbase.BaseClass;

public class CommonMethods  extends BaseClass{
	
	/**
	 * This method first clear the textbox end send some text.
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	/**
	 * This method firt checks if radio button or chackbox is anebled and then.
	 * cliks on the element that has the value that we are looking for.
	 * 
	 * @param elementList
	 * @param value
	 */
	public static void clickRadioOrChecbox(List<WebElement> elementList, String value) {
		for(WebElement el : elementList)
		{
			String actualValue = el.getAttribute("value").trim();
			if(actualValue.equals(value) && el.isEnabled())
			{
				el.click();
				break;
			}
		}
	}
	/**
	 * This method allows us to call Thread.sleep() for any amount of seconds that we specified.
	 * 
	 * @param seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	/**
	 * This method checks whether a visible text is found in a drop-down and access it.
	 * 
	 * @param element
	 * @param visibleText
	 */
	public static void selectDropDown(WebElement element, String visibleText) {
		try {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method checks if a given index is valid for the Webelement and only then select the option by using the index.
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDropDown(WebElement element, int index) {
		try {
		Select sel = new Select(element);
		int size = sel.getOptions().size();
		if (size > index)
		{
			sel.selectByIndex(index);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This method will switch to an alert and will accept the alert.
	 * It will handle a NoAlertPresentException.
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}
	/**
	 * This method will dismiss the alert.
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	/**
	 *  This method will return the alert text. If no alert is present the method will turn null.
	 *  
	 * @return
	 */
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
}
	/**
	 * This method sends text to the alert if it is present.
	 * 
	 * @param text
	 */
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method switches to a frame using Name or Id.
	 * 
	 * @param nameOrId
	 */
	public static void swicthToFrame(String nameOrId) {
	try {
		driver.switchTo().frame(nameOrId);
	} catch (NoSuchFrameException e) {
		e.printStackTrace();
	}
	}
	/**
	 * This method switches to a frame using an index.
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This method switches to a frame using a WebElement.
	 * 
	 * @param element
	 */
	public static void swicthToFrame(WebElement element) {
	try {
		driver.switchTo().frame(element);
	} catch (NoSuchFrameException e) {
		e.printStackTrace();
	}
	}
/**
 	* This method switches to the child window
 */
	public static void switchToChildWindow() {
	String mainWindow = driver.getWindowHandle();
	Set<String> handles = driver.getWindowHandles();
	for(String handle : handles)
	{
		if(!mainWindow.equals(handle))
		{
			driver.switchTo().window(handle);
			break;
		}
	}
}
/**
 	* This method creates a WebDriver object and returns it.
 * 
 * @return
 */
	public static WebDriverWait getWaitObject(){
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
	return wait;
}
/**
 	* This method will wait for an element to be clickable.
 * 
 * @param element
 * @return
 */
	public static WebElement waitForCliackability(WebElement element) {
	return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
}
/**
 	* This method will wait for an element to be visible.
 * 
 * @param element
 * @return
 */
	public static WebElement waitForVisibility(WebElement element) {
	WebElement el = getWaitObject().until(ExpectedConditions.visibilityOf(element));
	return el;
}
/**
 	* This method waits for an element to be clickable then cliks on it.
 * 
 * @param element
 */
	public static void click(WebElement element) {
	waitForCliackability(element);
	element.click();
}
/**
 * This method gets the title of current page
 */
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println("Title of the current webpage -> " + title);
	}	
	/**
	 * 
	 * @return
	 */
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
		// in one line
		// return (JavascriptExecutor) driver;
	}
	/**
	 * Tihs method will clcik on an element using JacascriptExecutor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0]", element);
	}
	/**
	 * This method will scroll the page until a specific element is in view.
	 * 
	 * @param element
	 */
	public static void scrollToElement (WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
	}
	/**
	 * This method will scroll the page down based on the pixel parameter
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0, "+pixel+")");
	}
	/**
	 * This method will scroll the page upbased on the pixel parameter
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0, -"+pixel+")");
	}
	/**
	 * This method selects a date from calendar
	 * 
	 * @param elements
	 * @param date
	 */
	public static void selectCalendarDate(List<WebElement> elements, String date) {
		for (WebElement day : elements)
		{
			if(day.isEnabled())
			{
				if(day.getText().equals(date))
				{
					day.click();
					break;
				}
			}else {
				System.out.println("This day in not enabled!");
				break;
			}
		}
	}
	
	public static void takeScreenShot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("screenShots/" + fileName + ".png");
		try {
			FileUtils.copyFile(source, destination);	
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Did NOT take a screenshot!!!");
		}
		
	}
	
	
	
	
	
	
//	public static void fileUpload (WebElement element, String file) {
//	file= "";
//	 element = driver.findElement(null);
//	String filePath = System.getProperty("user.dir") + file;
//	
//	
//	
//	sendText(element, filePath);
//	
//	
//}
	
}
