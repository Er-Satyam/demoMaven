package com.am_webtech.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// declaration

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement untbx;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement pwtbx;

	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement lgBtn;

	// initilization

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public void setLogin(String un, String pw) {
		untbx.sendKeys(un);
		pwtbx.sendKeys(pw);
		lgBtn.click();
	}

	public WebElement setuntbx() {

		return untbx;
	}

	public WebElement setpwtbx() {

		return pwtbx;
	}
}
