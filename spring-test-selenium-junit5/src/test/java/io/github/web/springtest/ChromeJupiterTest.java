package io.github.web.springtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.github.bonigarcia.SeleniumExtension;

@ExtendWith({ SeleniumExtension.class, SpringExtension.class })
@SpringBootTest(classes = SpringTestDemoApp.class, webEnvironment = RANDOM_PORT)
public class ChromeJupiterTest {

    @LocalServerPort
    int serverPort;

    @Test
    public void test(ChromeDriver driver) {
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
