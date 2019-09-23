package com.qa.selenium.homepage;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.selenium.SeleniumConst;

import com.qa.selenium.homepage.HomePagePOM;

public class HomePageCreateTest {

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
	public void addTeamTest() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int before = homepage.teamLength();
		homepage.addTeam(SeleniumConst.OLD_TEXT);
		assertEquals(before + 1, homepage.teamLength());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
