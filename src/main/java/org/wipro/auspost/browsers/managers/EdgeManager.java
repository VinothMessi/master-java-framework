package org.wipro.auspost.browsers.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class EdgeManager {
    private EdgeManager() {
    }

    public static WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    public static WebDriver getDriver(Boolean flag) {
        WebDriverManager.edgedriver().setup();
        EdgeOptions option = new EdgeOptions();
        option.setHeadless(flag);
        return new EdgeDriver(option);
    }

    public static WebDriver getDriver(String url) throws MalformedURLException {
        return new RemoteWebDriver(new URL(url), new EdgeOptions());
    }
}