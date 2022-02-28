package org.wipro.auspost.browsers.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class FirefoxManager {
    private FirefoxManager() {
    }

    public static WebDriver getDriver(Boolean flag) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions option = new FirefoxOptions();
        option.setHeadless(flag);
        return new FirefoxDriver(option);
    }

    public static WebDriver getDriver(String url) throws MalformedURLException {
        return new RemoteWebDriver(new URL(url), new FirefoxOptions());
    }
}