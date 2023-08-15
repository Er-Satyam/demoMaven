package com.am_webtech.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class punch {
public static void main(String[] args) throws InterruptedException {
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
	
	Thread.sleep(5000);
	WebElement date = driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']"));
	String displayedDate = date.getText();
	System.out.println(displayedDate);
}
}
