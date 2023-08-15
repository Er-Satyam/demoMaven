package com.am_webtech.testscript;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	@Test
	public void testLoginNull() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement usetxt = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement pwd = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		if (usetxt.getAttribute("value").isEmpty()) {
			System.out.println("username is empty");
		} else {
			System.out.println("username is not empty");
		}
		if (pwd.getAttribute("value").isEmpty()) {
			System.out.println("Password is empty");
		} else {
			System.out.println("Password is not empty");
		}
		Assert.assertTrue(usetxt.getAttribute("value").isEmpty());
		driver.quit();
	}

	@Test
	public void testLoginLogout() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		WebElement logouttxt = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
		if (logouttxt.isEnabled()) {
			System.out.println("logout link is visible and is enable ");
		} else {
			System.out.println("logout link is not present");
		}
		Assert.assertTrue(logouttxt.isEnabled());
		driver.quit();

	}

	@Test
	public void testPunchIn() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Attendance']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Punch In/Out']")).click();

		// Get current system time and date
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
		String systemDateTime = currentDateTime.format(formatter);
		String systemTime = currentDateTime.format(formatter2);

		// Verify time and date match

		WebElement date = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		String displayedDate = date.getText();
		System.out.println(displayedDate);
		if (systemDateTime.equals(displayedDate)) {
			System.out.println("Date match the system date.");
		} else {
			System.out.println(" Date do not match.");
		}

		WebElement time = driver.findElement(By.xpath("//input[@placeholder='hh:mm']"));
		String displayedTime = time.getText();
		System.out.println(displayedTime);
		if (systemTime.equals(displayedTime)) {
			System.out.println("Time  match the system time .");
		} else {
			System.out.println("Time do not match.");
		}

		driver.quit();
	}

	@Test
	public void quickAction() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		// Locate Quick Launch button
		WebElement quickLaunchButton = driver.findElement(By.xpath(
				"//button[@title='Assign Leave']//*[name()='svg']//*[name()='g' and contains(@fill,'currentCol')]//*[name()='path' and contains(@class,'cls-1')]"));

		// Perform hover action
		Actions actions = new Actions(driver);
		actions.moveToElement(quickLaunchButton).perform();

		// Verify highlight effect (check if the button's style/appearance changed)
		String highlightedColor = "rgba(0, 0, 0, 0)"; // Example highlighted color value
		String buttonColor = quickLaunchButton.getCssValue("background-color");
		System.out.println(buttonColor);

		if (buttonColor.equals(highlightedColor)) {
			System.out.println("Quick Launch button is highlighted on hover.");
		} else {
			System.out.println("Quick Launch button is not highlighted on hover.");
		}
		Assert.assertEquals(highlightedColor, buttonColor);
		// Close the browser
		driver.quit();
	}

}
