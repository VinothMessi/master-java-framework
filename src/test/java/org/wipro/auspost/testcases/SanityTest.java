package org.wipro.auspost.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.wipro.auspost.browsers.Local;
import org.wipro.auspost.browsers.enums.BrowserType;
import org.wipro.auspost.properties.Properties;

public class SanityTest {
    @Test
    public void chromeTest() {
        System.out.println("My Browser:" + Properties.get().browser());
        WebDriver browser = Local.launch(Properties.get().browser());
        browser.manage().window().maximize();
        browser.get("http://www.google.com");
        browser.quit();
    }

    @Test
    public void edgeTest() {
        System.out.println("My Browser:" + BrowserType.EDGE);
        WebDriver browser = Local.launch(BrowserType.EDGE);
        browser.manage().window().maximize();
        browser.get("http://www.google.com");
        browser.quit();
    }

    @Test
    public void firefoxTest() {
        System.out.println("My Browser:" + BrowserType.FIREFOX);
        WebDriver browser = Local.launch(BrowserType.FIREFOX);
        browser.manage().window().maximize();
        browser.get("http://www.google.com");
        browser.quit();
    }
}