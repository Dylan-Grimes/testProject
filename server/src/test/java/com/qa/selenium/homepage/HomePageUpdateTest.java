package com.qa.selenium.homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.selenium.SeleniumConst;

import com.qa.selenium.homepage.HomePagePOM;

public class HomePageUpdateTest {

	private WebDriver driver;
	private HomePagePOM homepage;

	
	@Before
	public void setup() {
		System.setProperty(SeleniumConst.DRIVER_KEY, SeleniumConst.DRIVER_LOCATION);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.get(SeleniumConst.HOMEPAGE_URL);
		homepage = new HomePagePOM(driver);
		
	}
	
	@Test
	public void updateTest() throws InterruptedException {
		homepage.updateTeam(SeleniumConst.OLD_TEXT, SeleniumConst.NEW_TEXT);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
