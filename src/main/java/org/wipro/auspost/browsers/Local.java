package org.wipro.auspost.browsers;

import org.openqa.selenium.WebDriver;
import org.wipro.auspost.browsers.managers.ChromeManager;
import org.wipro.auspost.browsers.managers.EdgeManager;
import org.wipro.auspost.browsers.managers.FirefoxManager;
import org.wipro.auspost.browsers.enums.BrowserType;

import java.util.EnumMap;
import java.util.function.Supplier;

public class Local {
    private Local() {
    }

    private static final EnumMap<BrowserType, Supplier<WebDriver>> map = new EnumMap<>(BrowserType.class);

    private static final Supplier<WebDriver> chrome = () -> ChromeManager.getDriver(false);
    private static final Supplier<WebDriver> edge = () -> EdgeManager.getDriver(false);
    private static final Supplier<WebDriver> firefox = () -> FirefoxManager.getDriver(false);
    private static final Supplier<WebDriver> headlessChrome = () -> ChromeManager.getDriver(true);
    private static final Supplier<WebDriver> headlessEdge = () -> EdgeManager.getDriver(true);
    private static final Supplier<WebDriver> headlessFirefox = () -> FirefoxManager.getDriver(true);

    static {
        map.put(BrowserType.CHROME, chrome);
        map.put(BrowserType.EDGE, edge);
        map.put(BrowserType.FIREFOX, firefox);
        map.put(BrowserType.HEADLESS_CHROME, headlessChrome);
        map.put(BrowserType.HEADLESS_EDGE, headlessEdge);
        map.put(BrowserType.HEADLESS_FIREFOX, headlessFirefox);
    }

    public static WebDriver launch(BrowserType browserType) {
        ThreadLocal<WebDriver> browser = ThreadLocal.withInitial(map.get(browserType));
        return browser.get();
    }
}