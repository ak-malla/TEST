package com.forio.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private static WebElement element = null;

	public static WebElement uName(WebDriver driver, String uName) {
		element = driver.findElement(By.xpath("//input[@name='email']"));
		element.sendKeys(uName);
		return element;
	}

	public static WebElement password(WebDriver driver, String pass) {
		element = driver.findElement(By.xpath("//input[@name='password']"));
		element.sendKeys(pass);
		return element;
	}

	public static WebElement login(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='register-or-sign-in']//button"));
		element.click();
		return element;
	}

}