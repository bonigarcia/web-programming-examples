package io.github.web.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTest {

    private static final int TIMEOUT = 30; // seconds
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testFirefox() {
        driver.get("http://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("Software");
        driver.findElement(By.id("searchButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.tagName("body"), "Computer software"));
    }

}
