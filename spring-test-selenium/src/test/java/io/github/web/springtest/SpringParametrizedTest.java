package io.github.web.springtest;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.github.bonigarcia.wdm.ChromeDriverManager;

@RunWith(Parameterized.class)
public class SpringParametrizedTest {

	private static final long TIMEOUT = 30; // seconds
	private WebDriver driver;
	private Class<? extends WebDriver> driverClass;
	private ConfigurableApplicationContext context;

	public SpringParametrizedTest(Class<? extends WebDriver> driverClass)
			throws InstantiationException, IllegalAccessException {
		this.driverClass = driverClass;
	}

	@Parameters(name = "{index}: {0}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { ChromeDriver.class },
				{ FirefoxDriver.class } });
	}

	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}

	@Before
	public void setup() throws Exception {
		this.driver = driverClass.newInstance();
		this.context = SpringApplication.run(SpringTestDemoApp.class);
	}

	@After
	public void teardown() {
		if (context != null) {
			context.close();
		}
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
		Assert.assertTrue(ExpectedConditions
				.titleIs("Spring Boot Test - Page 1").apply(driver));

		// Click on link
		driver.findElement(By.linkText("another")).click();

		// Verify second page text content
		Assert.assertTrue(ExpectedConditions
				.textToBePresentInElementLocated(By.tagName("body"), "Hello")
				.apply(driver));
	}

}
