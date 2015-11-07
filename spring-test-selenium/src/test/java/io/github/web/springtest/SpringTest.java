package io.github.web.springtest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@WebIntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestDemoApp.class)
public class SpringTest {

	private static final long TIMEOUT = 30; // seconds
	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() {
		// Always wait TIMEOUT seconds
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

		// Open system under test
		driver.get("http://localhost:8080/");

		// Verify first page title
		Assert.assertTrue(ExpectedConditions.titleIs(
				"Spring Boot Test - Page 1").apply(driver));

		// Click on link
		driver.findElement(By.linkText("another")).click();

		// Verify second page text content
		Assert.assertTrue(ExpectedConditions.textToBePresentInElementLocated(
				By.tagName("body"), "Hello").apply(driver));
	}

}
