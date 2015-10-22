package io.github.web.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteChromeTest {

	private WebDriver driver;

	@Before
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setBrowserName(DesiredCapabilities.chrome()
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
