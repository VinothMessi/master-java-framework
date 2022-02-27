package org.wipro.auspost.browsers.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class ChromeManager {
    private ChromeManager() {
    }

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver getDriver(Boolean flag) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(flag);
        return new ChromeDriver(option);
    }

    public static WebDriver getDriver(String url) throws MalformedURLException {
        return new RemoteWebDriver(new URL(url), new ChromeOptions());
    }
}