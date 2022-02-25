package org.wipro.auspost.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.wipro.auspost.enums.Browsers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.function.Supplier;

public class BrowserSupplier {
    private BrowserSupplier() {
    }

    private static final EnumMap<Browsers, Supplier<WebDriver>> map = new EnumMap<>(Browsers.class);

    private static final Supplier<WebDriver> chrome = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };
    private static final Supplier<WebDriver> edge = () -> {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };
    private static final Supplier<WebDriver> firefox = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };
    private static final Supplier<WebDriver> headlessChrome = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        return new ChromeDriver(option);
    };
    private static final Supplier<WebDriver> headlessFirefox = () -> {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions option = new FirefoxOptions();
        option.setHeadless(true);
        return new FirefoxDriver(option);
    };
    private static final Supplier<WebDriver> remoteChrome = () -> {
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to create remoteChrome session");
        }
    };
    private static final Supplier<WebDriver> remoteEdge = () -> {
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444"), new EdgeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to create remoteEdge session");
        }
    };
    private static final Supplier<WebDriver> remoteFirefox = () -> {
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444"), new FirefoxOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to create remoteFirefox session");
        }
    };

    static {
        map.put(Browsers.CHROME, chrome);
        map.put(Browsers.EDGE, edge);
        map.put(Browsers.FIREFOX, firefox);
        map.put(Browsers.HEADLESSCHROME, headlessChrome);
        map.put(Browsers.HEADLESSFIREFOX, headlessFirefox);
        map.put(Browsers.REMOTECHROME, remoteChrome);
        map.put(Browsers.REMOTEEDGE, remoteEdge);
        map.put(Browsers.REMOTEFIREFOX, remoteFirefox);
    }

    public static WebDriver launch(Browsers browserType) {
        ThreadLocal<WebDriver> browser = ThreadLocal.withInitial(map.get(browserType));
        return browser.get();
    }
}