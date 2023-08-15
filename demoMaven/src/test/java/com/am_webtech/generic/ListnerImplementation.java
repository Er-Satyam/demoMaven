package com.am_webtech.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.am_webtech.generic.BaseClass;

public class ListnerImplementation extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();// fetching same name as testmethod

		TakesScreenshot ts = (TakesScreenshot) driver;// type cast the driver to takesscreenshot
		File src = ts.getScreenshotAs(OutputType.FILE);// method use to press print screen button and take screenshot

		File dest = new File("./ScreenShot/" + name + ".png");// creating the folder and ref variable

		try {
			FileUtils.copyFile(src, dest);// copy file from ram to folder

		} catch (IOException e) {

		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
