package org.wipro.auspost.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.wipro.auspost.browsers.LocalBrowsers;
import org.wipro.auspost.enums.Browsers;
import org.wipro.auspost.properties.Properties;

public class SanityTest {
    @Test
    public void chromeTest() {
        System.out.println("My Browser:" + Properties.get().browser());
        WebDriver browser = LocalBrowsers.launch(Properties.get().browser());
        browser.manage().window().maximize();
        browser.get("http://www.google.com");
        browser.quit();
    }

    @Test
    public void edgeTest() {
        System.out.println("My Browser:" + Browsers.EDGE);
        WebDriver browser = LocalBrowsers.launch(Browsers.EDGE);
        browser.manage().window().maximize();
        browser.get("http://www.google.com");
        browser.quit();
    }

    @Test
    public void firefoxTest() {
        System.out.println("My Browser:" + Browsers.FIREFOX);
        WebDriver browser = LocalBrowsers.launch(Browsers.FIREFOX);
        browser.manage().window().maximize();
        browser.get("http://www.google.com");
        browser.quit();
    }
}