package io.github.web.springtest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SpringChromeTest {

	private WebDriver driver;
	private ConfigurableApplicationContext context;

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}

	@Before
	public void setupTest() {
		context = SpringApplication.run(SpringTestDemoApp.class);

		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}

		if (context != null) {
			context.close();
		}
	}

	@Test
	public void test() {
		// Always wait 30 seconds to locate elements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Open system under test
		driver.get("http://localhost:8080/");

		// Verify first page title
		String firstPageTitle = driver.getTitle();
		String expectedFirstPageTitle = "Spring Boot Test - Page 1";
		Assert.assertEquals(expectedFirstPageTitle, firstPageTitle);

		// Click on link
		driver.findElement(By.linkText("another")).click();

		// Verify second page caption
		String secondPageCaption = driver.findElement(By.id("caption"))
				.getText();
		String expectedSecondPageTitle = "Other page";
		Assert.assertEquals(expectedSecondPageTitle, secondPageCaption);
	}

}
