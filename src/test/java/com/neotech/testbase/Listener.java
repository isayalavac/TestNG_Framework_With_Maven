package com.neotech.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("Functionality Test Started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Functionality Test Finished");
	}

	public void onTestStart(ITestResult result) {
		// just printing logs to the console
		System.out.println("Test Will Start: " + result.getName());
		
		// we want create a test report --- so that we output logs on the ExtentReport
		BaseClass.test = BaseClass.report.createTest(result.getName());
		
		
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// just printing logs to the console
		System.out.println("Test Passed: " + result.getName());
		
		// print test passed on the report
		BaseClass.test.pass("Test Pessed: " + result.getName());
		
		
	}

	public void onTestFailure(ITestResult result) {
		// printing logs to the console
		System.out.println("Test Failed: " + result.getName());
		
		// print test failed on the report
		BaseClass.test.fail("Test Failed: " + result.getName());
	}


}
