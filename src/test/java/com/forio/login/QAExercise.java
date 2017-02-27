package com.forio.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QAExercise {

	private WebDriver driver;

	@BeforeTest
	public void init() throws FileNotFoundException, Exception {

		String configFile = "config.prop";

		System.setProperty("webdriver.chrome.driver", "/Users/AK/Downloads/chromedriver");

		if (driverName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (driverName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (driverName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else if (driverName.equalsIgnoreCase("IE")) {
			driver = new SafariDriver();
		}

		Properties prop = new Properties();
		InputStream input = null;
		try {
			// get properties file from project classpath
			input = getClass().getClassLoader().getResourceAsStream(dbconfig);
			prop.load(input);

		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@AfterTest
	public void destroy() {
		driver.quit();
	}

	@Test
	public void main() throws InterruptedException {
		driver.get("http://www.google.com");
		System.out.println("Page Title is " + driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		Thread.sleep(5000);
	}

}
