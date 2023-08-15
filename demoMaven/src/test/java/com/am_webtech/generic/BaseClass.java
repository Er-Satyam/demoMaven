package com.am_webtech.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.am_webtech.generic.FileLib;
import com.am_webtech.pom.HomePage;
import com.am_webtech.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;// static mandatory for screenshot

	@BeforeTest
	public void openBrowser() {
		Reporter.log("Open Browser", true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void closeBrowser() {
		Reporter.log("Close Browser", true);
		driver.quit();
	}

	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("Login", true);
		FileLib f = new FileLib();
		String url = f.getPropertyData("url");
		driver.get(url);
	}

	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("Logout", true);
		HomePage h = new HomePage(driver);
		h.setLogout();
	}

}
