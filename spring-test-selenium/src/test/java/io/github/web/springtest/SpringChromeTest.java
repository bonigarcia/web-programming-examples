package io.github.web.springtest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestDemoApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringChromeTest {

    private WebDriver driver;

    @LocalServerPort
    protected int serverPort;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
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
        // Open system under test
        driver.get("http://localhost:" + serverPort);

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
