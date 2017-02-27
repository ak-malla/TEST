package com.forio.login;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class QAExercise {

	private WebDriver driver;
	String credentials;
	String endPoint;
	String browser;
	String webdriver;

	@BeforeTest
	@Parameters({ "config" })
	public void init() throws FileNotFoundException, NullPointerException, Exception {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.prop");
			prop.load(input);

			endPoint = prop.getProperty("endPoint");
			webdriver = prop.getProperty("webdriver");
			browser = prop.getProperty("browser");

			credentials = prop.getProperty("credentials");

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

	private void invokeDriver() {
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", webdriver);
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}
	}

	@AfterTest
	public void destroy() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

	@DataProvider
	public Object[][] getCredentials() {

		int testSize = credentials.split("#").length;
		int i = 0;
		Object[][] data = new Object[testSize][2];
		for (String lin : credentials.split("#")) {

			String[] aTest = new String[2];
			StringTokenizer st = new StringTokenizer(lin, "=");
			aTest[0] = st.nextToken();
			aTest[1] = st.nextToken();

			data[i] = aTest;
			i++;
		}

		return data;
	}

	@Test(dataProvider = "getCredentials")
	public void main(String uName, String pass) throws InterruptedException {

		invokeDriver();
		driver.manage().window().maximize();
		driver.get(endPoint);

		LoginPage.uName(driver, uName);
		LoginPage.password(driver, pass);
		LoginPage.login(driver);

		Assert.assertEquals(driver.getTitle(), "Epicenter");
		Thread.sleep(5000);
		driver.quit();

	}

}
