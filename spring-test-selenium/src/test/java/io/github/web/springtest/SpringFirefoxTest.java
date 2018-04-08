package io.github.web.springtest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestDemoApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringFirefoxTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
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
