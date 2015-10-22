package io.github.web.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest {

	private static final int TIMEOUT = 30; // seconds
	private WebDriver driver;

	@Before
	public void setup() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void testChrome() {
		driver.get("http://en.wikipedia.org/wiki/Main_Page");
		driver.findElement(By.id("searchInput")).sendKeys("Software");
		driver.findElement(By.id("searchButton")).click();

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.tagName("body"), "Computer software or simply software"));
	}

}
