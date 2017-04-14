package io.github.web.springtest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestDemoApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringFirefoxTest {

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		FirefoxDriverManager.getInstance().setup();
	}

	@Before
	public void setupTest() {
		driver = new FirefoxDriver();
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() throws InterruptedException {
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
