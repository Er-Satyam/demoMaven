package com.am_webtech.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimePage {
	@FindBy(xpath = "//span[normalize-space()='Attendance']")
	private WebElement attendance;

	@FindBy(xpath = "//a[normalize-space()='Punch In/Out']")
	private WebElement punchinout;

	// initilization

	public TimePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public void setPunchIn() {
		attendance.click();
		punchinout.click();

	}

}
