package com.am_webtech.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement logoutdropdown;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//span[normalize-space()='Time']")
	private WebElement timeTab; // declaration

	// initilization

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public WebElement setLogoutDropDown() {
		return logoutdropdown;
	}

	public WebElement setLogout() {
		return logout;
	}

	public WebElement setTimeTab() {

		return timeTab;
	}
}
