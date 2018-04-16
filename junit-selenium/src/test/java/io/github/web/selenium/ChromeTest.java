package io.github.web.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.SeleniumExtension;

@ExtendWith(SeleniumExtension.class)
public class ChromeTest {

    @Test
    void testChrome(ChromeDriver driver) {
        driver.get("http://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("Software");
        driver.findElement(By.id("searchButton")).click();

        boolean containsText = driver.findElement(By.tagName("body")).getText()
                .contains("Computer software");
        assertTrue(containsText);
    }

}
