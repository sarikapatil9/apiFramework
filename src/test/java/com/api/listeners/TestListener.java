package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private static final Logger logger = LogManager.getLogger(TestListener.class);
	
	 public void onStart(ITestContext context) {
		   logger.info("Test suite started");
		  }
	 public void onFinish(ITestContext context) {
		 logger.info("Test suite completed");
		  }
	 
	 public void onTestStart(ITestResult result) {
		 logger.info(result.getName()+"Test case started");
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		 logger.info(result.getName()+"Test case passed");
		  }
	 
	 public void onTestFailure(ITestResult result) {
		 logger.info(result.getName()+"Test case failed");
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		 logger.info(result.getName()+"Test case skipped");
		  }


}
