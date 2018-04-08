package io.github.web.selenium;

import static org.openqa.selenium.remote.DesiredCapabilities.firefox;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteFirefoxTest {

    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),
                firefox());
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testRemote() {
        driver.get("http://www.google.com/");
    }

}
