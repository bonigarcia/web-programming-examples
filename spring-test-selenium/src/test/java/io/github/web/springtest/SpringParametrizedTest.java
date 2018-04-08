package io.github.web.springtest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class SpringParametrizedTest {

    private WebDriver driver;
    private ConfigurableApplicationContext context;

    @Parameter
    public Class<? extends WebDriver> driverClass;

    @Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { ChromeDriver.class },
                { FirefoxDriver.class } });
    }

    @Before
    public void setup() throws Exception {
        context = SpringApplication.run(SpringTestDemoApp.class);

        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
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
        // Open system under test
        driver.get("http://localhost:8080/");

        // Verify first page title
        String firstPageTitle = driver.getTitle();
        String expectedFirstPageTitle = "Spring Boot Test - Page 1";
        assertEquals(expectedFirstPageTitle, firstPageTitle);

        // Click on link
        driver.findElement(By.linkText("another")).click();

        // Verify second page caption
        String secondPageCaption = driver.findElement(By.id("caption"))
                .getText();
        String expectedSecondPageTitle = "Other page";
        assertEquals(expectedSecondPageTitle, secondPageCaption);
    }

}
