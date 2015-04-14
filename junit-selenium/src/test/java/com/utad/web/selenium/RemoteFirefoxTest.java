package com.utad.web.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteFirefoxTest {

	private WebDriver driver;

	@Before
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		FirefoxProfile profile = new FirefoxProfile();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		capabilities.setBrowserName(DesiredCapabilities.firefox()
				.getBrowserName());

		String hubAddress = "127.0.0.1";
		int hubPort = 4444;
		driver = new RemoteWebDriver(new URL("http://" + hubAddress + ":"
				+ hubPort + "/wd/hub"), capabilities);
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void testRemote() {
		driver.get("http://www.google.com/");
	}

}
